package com.java.fundamentals.inventory.app.services.impl;

import com.java.fundamentals.inventory.app.constants.MeasureUnit;
import com.java.fundamentals.inventory.app.entities.Product;
import com.java.fundamentals.inventory.app.exceptions.InvalidMeasureUnitException;
import com.java.fundamentals.inventory.app.exceptions.InvalidProductQuantityException;
import com.java.fundamentals.inventory.app.repositories.ProductRepositoryI;
import com.java.fundamentals.inventory.app.services.ProductServiceI;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author capri
 */
public class ProductServiceImpl implements ProductServiceI {

    private final ProductRepositoryI productRepositoryI;
    
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
        
        return getProductsByFilter(product -> product.getCurrentQuantity() > quantity);
    }

    @Override
    public List<Product> getProductsLessThanXQuantity(int quantity) {
        
        return getProductsByFilter(product -> product.getCurrentQuantity() < quantity);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        
        return getProductsByFilter(product -> product.getName().equals(name));
    }
    
    private List<Product> getProductsByFilter(Predicate<Product> filter) {
        List<Product> allProducts = productRepositoryI.findAll();
        List<Product> productsXQuantity = new ArrayList<>();
        
        for(Product product : allProducts) {
            if (filter.test(product)) {  
                productsXQuantity.add(product);
            }
        }
        
        return productsXQuantity;
    }
    
}
