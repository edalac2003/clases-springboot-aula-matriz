package com.java.fundamentals.inventory.app.repositories.impl;

import com.java.fundamentals.inventory.app.constants.MeasureUnit;
import com.java.fundamentals.inventory.app.entities.Product;
import com.java.fundamentals.inventory.app.exceptions.StoreNotFoundException;
import com.java.fundamentals.inventory.app.repositories.ProductRepositoryI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author capri
 */
public class ProductRepositoryImpl implements ProductRepositoryI {
    
   private List<Product> products = new ArrayList<>();
   private static short counter = 0;
   private StoreRepositoryImpl storeRepositoryImpl = new StoreRepositoryImpl();

    public ProductRepositoryImpl() {
       Product coffeeProduct = new Product();
       coffeeProduct.setName("Café");
       coffeeProduct.setCurrentQuantity(5_500);
       coffeeProduct.setId((short)1);
       coffeeProduct.setMeasureUnit(MeasureUnit.GR);
       coffeeProduct.setMinQuantity(1_000);
       try {
           coffeeProduct.setStore(storeRepositoryImpl.findById((short)1));
       } catch (StoreNotFoundException ex) {
           Logger.getLogger(ProductRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       products.add(coffeeProduct);
       
       Product coffeeProductStore2 = new Product();
       coffeeProductStore2.setName("Café");
       coffeeProductStore2.setCurrentQuantity(5_500);
       coffeeProductStore2.setId((short)1);
       coffeeProductStore2.setMeasureUnit(MeasureUnit.GR);
       coffeeProductStore2.setMinQuantity(1_000);
       try {
           coffeeProductStore2.setStore(storeRepositoryImpl.findById((short)2));
       } catch (StoreNotFoundException ex) {
           Logger.getLogger(ProductRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       products.add(coffeeProductStore2);
       
       Product sugarProductStore2 = new Product();
       sugarProductStore2.setName("Azúcar");
       sugarProductStore2.setCurrentQuantity(4_000);
       sugarProductStore2.setId((short)1);
       sugarProductStore2.setMeasureUnit(MeasureUnit.GR);
       sugarProductStore2.setMinQuantity(500);
       
       try {
           sugarProductStore2.setStore(storeRepositoryImpl.findById((short)2));
       } catch (StoreNotFoundException ex) {
           Logger.getLogger(ProductRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       products.add(sugarProductStore2);
       
       
    }

    @Override
    public Product create(Product productToCreate) {
        productToCreate.setId(++counter);
        this.products.add((Product)productToCreate);
       
       return productToCreate;
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

    @Override
    public List<Product> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
   
}
