package com.java.fundamentals.inventory.app.services;

import com.java.fundamentals.inventory.app.entities.Product;
import java.util.List;

/**
 *
 * @author capri
 */
public interface ProductServiceI {
    
    void registerProduct(Product product) throws Exception;
    List<Product> getProductsGreaterThanXQuantity(int quantity);
    List<Product> getProductsLessThanXQuantity(int quantity);
    List<Product> getProductsByName(String name);
    List<String> getStoreNamesThatHaveOneProduct();
    List<String> getStoreNamesThatHaveGreaterThanOneProduct();
    List<String> getAllStoreNamesAndProductQuantity();
    
}
