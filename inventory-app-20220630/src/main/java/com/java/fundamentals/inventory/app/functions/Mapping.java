/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.fundamentals.inventory.app.functions;

import com.java.fundamentals.inventory.app.entities.Store;

/**
 *
 * @author capri
 */
@FunctionalInterface
public interface Mapping<T,U,R> {
    
    R map(T t, U s);//Descriptor de función.
    
}
