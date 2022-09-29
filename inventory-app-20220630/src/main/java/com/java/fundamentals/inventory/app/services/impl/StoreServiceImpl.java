package com.java.fundamentals.inventory.app.services.impl;

import com.java.fundamentals.inventory.app.entities.Store;
import com.java.fundamentals.inventory.app.exceptions.StoreNotFoundException;
import com.java.fundamentals.inventory.app.exceptions.runtime.AtLeastOneStoreIsRequiredException;
import com.java.fundamentals.inventory.app.repositories.StoreRepositoryI;
import com.java.fundamentals.inventory.app.services.StoreServiceI;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Comparator.comparing;

/**
 *
 * @author capri
 */
public class StoreServiceImpl implements StoreServiceI {

    @Override
    public Store create(Store storeToCreate) {
        synchronized(this){
             return null;
        }
    }

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
    public List<String> findNameStoreWithFiveCharacterOrMore() {
        return this.findAll().stream()
                .filter(store -> store.getName().length() > 5)
                .map(store -> store.getName())
                .collect(Collectors.toList());
    }
    
    @Override
    public Set<Store> findAllStoresSortedByName() {
//        List<Store> stores = storeRepository.findAll();
//        Set<Store> storesSet = new TreeSet<>(this.comparing(Store::getName));
//        storesSet.addAll(stores);
//        return storesSet;
    	Supplier<Store> s;
    	Consumer<Store> c;
        return storeRepository.findAll()
                .stream()
                .sorted(comparing(Store::getName))
                .collect(toSet());
    }

    @Override
    public Set<Store> findAllStoresSortedById() {
        return storeRepository.findAll()
                .stream()
                .sorted(comparing(Store::getId))
                .collect(toSet());
    }

//    private <T,U extends Comparable<U>> Comparator<T> comparing(Function<T, ? extends U> keyExtractor){
//        return (T store1, T store2) -> keyExtractor.apply(store1).compareTo(keyExtractor.apply(store2));
//    }
}
