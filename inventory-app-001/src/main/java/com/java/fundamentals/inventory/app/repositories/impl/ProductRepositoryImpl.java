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
        Product coffeeProduct1 = new Product();
        coffeeProduct1.setName("Café");
        coffeeProduct1.setCurrentQuantity(5_500);
        coffeeProduct1.setId((short)1);
        coffeeProduct1.setMeasureUnit(MeasureUnit.GR);
        coffeeProduct1.setMinQuantity(1_000);
       try {
           coffeeProduct1.setStore(storeRepositoryImpl.findById((short)1));
       } catch (StoreNotFoundException ex) {
           Logger.getLogger(ProductRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
       }
       products.add(coffeeProduct1);
       
       Product coffeeProduct2 = new Product();
        coffeeProduct2.setName("Café");
        coffeeProduct2.setCurrentQuantity(5_500);
        coffeeProduct2.setId((short)2);
        coffeeProduct2.setMeasureUnit(MeasureUnit.GR);
        coffeeProduct2.setMinQuantity(1_000);
       try {
           coffeeProduct2.setStore(storeRepositoryImpl.findById((short)2));
       } catch (StoreNotFoundException ex) {
           Logger.getLogger(ProductRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
       }
       products.add(coffeeProduct2);
       
       Product sugarProductStore2 = new Product();
        sugarProductStore2.setName("Azucar");
        sugarProductStore2.setCurrentQuantity(4_000);
        sugarProductStore2.setId((short)3);
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
