package com.java.fundamentals.inventory.app.exceptions;

/**
 * Esta excepción se generará en caso de que no se logre encontrar una tienda en particular.
 * 
 * @author capri
 */
public class StoreNotFoundException extends Exception {

    public StoreNotFoundException(String message) {
        super(message);
    }

    public StoreNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
