package com.java.fundamentals.inventory.app.services.impl;

import com.java.fundamentals.inventory.app.entities.Store;
import com.java.fundamentals.inventory.app.exceptions.StoreNotFoundException;
import com.java.fundamentals.inventory.app.exceptions.runtime.AtLeastOneStoreIsRequiredException;
import com.java.fundamentals.inventory.app.repositories.StoreRepositoryI;
import com.java.fundamentals.inventory.app.services.StoreServiceI;
import java.util.List;

/**
 *
 * @author capri
 */
public class StoreServiceImpl implements StoreServiceI {

    private StoreRepositoryI storeRepository;
    
    public StoreServiceImpl(StoreRepositoryI storeRepository) {
        this.storeRepository = storeRepository;
    }
    
    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store findById(short storeId) throws StoreNotFoundException, Exception {
        return storeRepository.findById(storeId);
    }

    @Override
    public Store update(Store storeToUpdate) throws Exception, StoreNotFoundException {
        //Debería hacerse la validación de negocio respecto al máximo número de caracteres en el nombre de la tienda.
        return storeRepository.update(storeToUpdate);
    }

    @Override
    public void checkStores() throws AtLeastOneStoreIsRequiredException {
        List<Store> stores = storeRepository.findAll();
        if (stores == null || stores.isEmpty()) {
            throw new AtLeastOneStoreIsRequiredException();
        }
    }

    @Override
    public String checkIfStoreHasValidName(Store storeToVerify) {
        
        return (storeToVerify.getName().length() > 8) ? "ERROR": "OK";
    }
}
