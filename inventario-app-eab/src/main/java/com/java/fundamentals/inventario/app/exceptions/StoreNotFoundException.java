package com.java.fundamentals.inventario.app.exceptions;

/**
 * Esta excepción se generará cuand ono se encuentra una excepcion
 * @author edala
 */
public class StoreNotFoundException extends Exception {

    public StoreNotFoundException(String message) {
        super(message);
    }

    public StoreNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
