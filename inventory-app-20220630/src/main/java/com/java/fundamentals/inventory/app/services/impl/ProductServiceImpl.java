package com.java.fundamentals.inventory.app.services.impl;

import com.java.fundamentals.inventory.app.constants.MeasureUnit;
import com.java.fundamentals.inventory.app.entities.Product;
import com.java.fundamentals.inventory.app.entities.Store;
import com.java.fundamentals.inventory.app.exceptions.InvalidMeasureUnitException;
import com.java.fundamentals.inventory.app.exceptions.InvalidProductQuantityException;
import com.java.fundamentals.inventory.app.repositories.ProductRepositoryI;
import com.java.fundamentals.inventory.app.repositories.StoreRepositoryI;
import com.java.fundamentals.inventory.app.repositories.impl.StoreRepositoryImpl;
import com.java.fundamentals.inventory.app.services.ProductServiceI;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author capri
 */
public class ProductServiceImpl implements ProductServiceI {

    private final ProductRepositoryI productRepositoryI;
    private final StoreRepositoryI storeRepositoryI = new StoreRepositoryImpl();
    
    public ProductServiceImpl(ProductRepositoryI productRepositoryI) {
        this.productRepositoryI = productRepositoryI;
    }
    
    @Override
    public void registerProduct(Product product) throws Exception {
        
        if (product != null && product.getMeasureUnit() != null) {
            if (product.getMeasureUnit() == MeasureUnit.GR) {
                if (product.getCurrentQuantity() < 1000) {
                    throw new InvalidProductQuantityException();
                }
            }
            ///Proceder a hacer la inserción en el repositorio de datos.
            productRepositoryI.create(product);
        } else {
            throw new InvalidMeasureUnitException();
        }
        
    }

    @Override
    public List<Product> getProductsGreaterThanXQuantity(int quantity) {
        return productRepositoryI.findAll()
                .stream()
                .filter(product -> product.getCurrentQuantity() > quantity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsLessThanXQuantity(int quantity) {
        return productRepositoryI.findAll()
                .stream()
                .filter(product -> product.getCurrentQuantity() < quantity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepositoryI.findAll()
                .stream()
                .filter(product -> product.getName().equals(name))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<String> getStoreNamesThatHaveOneProduct() {
        
        return getStoreNamesByFilter((Short productsQuantity) -> productsQuantity == 1, 
                                     (Store store, Short productQty) -> store.getName());
    }

    @Override
    public List<String> getStoreNamesThatHaveGreaterThanOneProduct() {
        return getStoreNamesByFilter((Short productsQuantity) -> productsQuantity > 1, 
                                     (Store store, Short productQty) -> store.getName());
    }

    @Override
    public List<String> getAllStoreNamesAndProductQuantity() {
     
        return getStoreNamesByFilter((Short productQuantity) -> true, 
                                     (Store store, Short productQty) -> store.getName() + ":" + productQty);
    }
    
    
    private List<String> getStoreNamesByFilter(Predicate<Short> filter, BiFunction<Store, Short, String> mapper) {
        List<Product> products = productRepositoryI.findAll();
        List<Store> stores = storeRepositoryI.findAll();
        List<String> storeNames = new ArrayList<>();
        
        short productsQuantityByStore;
        
        for(Store store: stores) {
            productsQuantityByStore = 0;
            for(Product product: products) {
                if (product.getStore() != null && product.getStore().equals(store)) {
                    productsQuantityByStore++;
                }
            }
            
            if (filter.test(productsQuantityByStore)) {
                storeNames.add(mapper.apply(store, productsQuantityByStore));
            }
            
        }
        
        return storeNames;
    }
    
}
