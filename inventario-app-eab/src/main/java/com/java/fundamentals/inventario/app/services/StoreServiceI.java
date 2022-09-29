package com.java.fundamentals.inventario.app.services;

import com.java.fundamentals.inventario.app.exceptions.StoreNameTooLongException;
import com.java.fundamentals.inventario.app.exceptions.StoreNotFoundException;
import com.java.fundamentals.inventario.app.model.Store;
import java.util.List;

/**
 *
 * @author Edwin Acosta Bravo
 */
public interface StoreServiceI {
    List<Store> findAll();
    
    Store findById(short id) throws Exception, StoreNotFoundException;
    
    Store update(Store storeToUpdate) throws Exception;
    
    void delete(short idStore);
    
    void checkStores();
}
