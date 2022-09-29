package com.java.fundamentals.inventario.app.services.impl;

import com.java.fundamentals.inventario.app.exceptions.InvalidMeasureUnitException;
import com.java.fundamentals.inventario.app.exceptions.InvalidProductQuantityException;
import com.java.fundamentals.inventario.app.functions.Predicate;
import com.java.fundamentals.inventario.app.model.Product;
import com.java.fundamentals.inventario.app.repositories.ProductRepositoryI;
import com.java.fundamentals.inventario.app.services.ProductServiceI;
import com.java.fundamentals.inventario.app.utils.MeasureUnit;
import java.util.ArrayList;
import java.util.List;


public class ProductServiceImpl implements ProductServiceI{

    private ProductRepositoryI productRepositoryI;

    public ProductServiceImpl(ProductRepositoryI productRepositoryI) {
        this.productRepositoryI = productRepositoryI;
    }
        
    @Override
    public void registerProduct(Product product) throws InvalidMeasureUnitException, InvalidProductQuantityException {
        if(product != null && product.getMeasureUnit() != null){
            if(product.getMeasureUnit() == MeasureUnit.GR){
                if(product.getCurrentQuantity() < 1000){
                    throw new InvalidProductQuantityException();
                }
            }
            productRepositoryI.create(product);
        } else {
            throw new InvalidMeasureUnitException();
        } 
        
        System.out.println("PRODUCTO GUARDADO SATISFACTORIAMENTE");
    }

    @Override
    public List<Product> findAll() {
        return productRepositoryI.findAll();
    }

    @Override
    public List<Product> getProductGreaterThanXQuantity(int quantity) {
        List<Product> allProducts = productRepositoryI.findAll();
        List<Product> productsGraterThan = new ArrayList<>();
        for(Product product : allProducts){
            if(product.getCurrentQuantity() > quantity){
                productsGraterThan.add(product);
            }
        }
        
        return productsGraterThan;
    }

    @Override
    public List<Product> getProductLessThanXQuantity(int quantity) {
        List<Product> allProducts = productRepositoryI.findAll();
        List<Product> productsLessThan = new ArrayList<>();
        for(Product product : allProducts){
            if(product.getCurrentQuantity() < quantity){
                productsLessThan.add(product);
            }
        }

        return productsLessThan;
       
    }

    @Override
    public List<Product> getProductByName(String name) {
        List<Product> allProducts = productRepositoryI.findAll();
        List<Product> productsByName = new ArrayList<>();
        for(Product product : allProducts){
            if(product.getName().equals(name)){
                productsByName.add(product);
            }
        }

        return productsByName;
    }
    
    private List<Product> getProductsByFilter(String comparisionParam, Predicate filter){
        List<Product> allProducts = productRepositoryI.findAll();
        List<Product> productsByName = new ArrayList<>();
        
    }
    
}
