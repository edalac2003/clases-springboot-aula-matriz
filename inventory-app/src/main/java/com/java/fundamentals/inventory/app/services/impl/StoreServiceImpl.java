package com.java.fundamentals.inventory.app.services.impl;

import com.java.fundamentals.inventory.app.entities.Store;
import com.java.fundamentals.inventory.app.exceptions.StoreNotFoundException;
import com.java.fundamentals.inventory.app.exceptions.runtime.AtLeastOneStoreIsRequiredException;
import com.java.fundamentals.inventory.app.repositories.StoreRepositoryI;
import com.java.fundamentals.inventory.app.services.StoreServiceI;
import static java.util.Comparator.comparing;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static java.util.stream.Collectors.*;

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

    @Override
    public List<String> getStoreNamesWithMoreThanFiveCharacters() {
        return storeRepository.findAll()
                              .stream()
                              .filter(store -> store.getName().length() > 5)
                              .map(Store::getName)
                              .collect(toList());
    }

    @Override
    public List<Store> findAllStoresSortedByName() {
        
        return storeRepository.findAll()
                              .stream()
                              .distinct()
                              .sorted(comparing(Store::getName))
                              .collect(toList());
    }

    @Override
    public List<Store> findAllStoresSortedById() {
        
        return storeRepository.findAll()
                              .stream()
                              .distinct()
                              .sorted(comparing(Store::getId))
                              .collect(toList());
    }

    @Override
    public Set<Store> findAllDistinctStores() {
        return new HashSet<>(storeRepository.findAll());
    }

    @Override
    public Store create(Store storeToCreate) {
        return storeRepository.create(storeToCreate);
    }
    
    
    
}
