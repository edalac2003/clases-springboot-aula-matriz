package com.java.fundamentals.inventario.app.functions;

import com.java.fundamentals.inventario.app.model.Product;


public class ByNamePredicate implements Predicate{

    @Override
    public boolean evaluateCondition(Product product) {
        return product.getName().equals("CAFE");
    }
    
}
