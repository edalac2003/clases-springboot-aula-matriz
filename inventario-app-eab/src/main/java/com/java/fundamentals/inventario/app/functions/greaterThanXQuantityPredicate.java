/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.fundamentals.inventario.app.functions;

import com.java.fundamentals.inventario.app.model.Product;

/**
 *
 * @author edala
 */
public class greaterThanXQuantityPredicate implements Predicate {

    @Override
    public boolean evaluateCondition(Product product) {
        return product.getCurrentQuantity() > 3000;
    }
    
}
