package com.java.fundamentals.inventario.app.functions;

import com.java.fundamentals.inventario.app.model.Product;

public class LessThanXQuantityPredicate implements Predicate{

    @Override
    public boolean evaluateCondition(Product product) {
        return product.getCurrentQuantity() < 3000;
    }
    
}
