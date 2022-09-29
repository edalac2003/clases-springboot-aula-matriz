/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.fundamentals.inventario.app.repositories.impl;

import com.java.fundamentals.inventario.app.model.Product;
import com.java.fundamentals.inventario.app.repositories.ProductRepositoryI;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edala
 */
public class ProductRepositoryImpl implements ProductRepositoryI{
    
    private List<Product> products = new ArrayList<>();   
    private static short counter = 0;
    
    
//    @Override
//    public Product create(Product productToCreate){
//        productToCreate.setId(++counter);
//        this.products.add(productToCreate);        
//        return productToCreate;
//    }
//    
//    public Product findById(short idProduct){
//        return null;
//    }
//    
//    public List<Product> findAll(){
//        return products;
//    }
//    
//    public Product update(Product producttoUpdate){
//        return null;
//    }
//    
//    public void delete(short idProduct){
//        
//    }

    @Override
    public Product create(Product productToCreate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product update(Product entityToUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product findById(Short entityId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Short entityId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
