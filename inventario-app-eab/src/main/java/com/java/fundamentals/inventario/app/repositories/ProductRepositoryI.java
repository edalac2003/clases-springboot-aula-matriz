/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.fundamentals.inventario.app.repositories;

import com.java.fundamentals.inventario.app.model.Product;
import java.util.List;

/**
 *
 * @author edala
 */
public interface ProductRepositoryI extends RepositoryI<Product, Short>{
    
    Product create(Product productToCreate);
    
    List<Product> findAll();
}
