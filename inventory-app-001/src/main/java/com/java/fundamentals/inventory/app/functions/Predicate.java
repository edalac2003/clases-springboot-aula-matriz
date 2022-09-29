package com.java.fundamentals.inventory.app.functions;

import com.java.fundamentals.inventory.app.entities.Product;

/**
 *
 * @author capri
 */
@FunctionalInterface
public interface Predicate {
    
    boolean evaluateCondition(Product product);//Descriptor de función.
    
}
