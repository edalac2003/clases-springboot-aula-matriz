package com.java.fundamentals.inventario.app.services;

import com.java.fundamentals.inventario.app.exceptions.InvalidMeasureUnitException;
import com.java.fundamentals.inventario.app.exceptions.InvalidProductQuantityException;
import com.java.fundamentals.inventario.app.model.Product;
import java.util.List;

/**
 *
 * @author edala
 */
public interface ProductServiceI {
    void registerProduct(Product product) throws InvalidMeasureUnitException, InvalidProductQuantityException;
    
    List<Product> findAll();
    
    List<Product> getProductGreaterThanXQuantity(int quantity);
    
    List<Product> getProductLessThanXQuantity(int quantity);
    
    List<Product> getProductByName(String name);
}
