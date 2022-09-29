package com.java.fundamentals.inventory.app.repositories.impl;

import com.java.fundamentals.inventory.app.entities.Store;
import com.java.fundamentals.inventory.app.exceptions.StoreNotFoundException;
import com.java.fundamentals.inventory.app.repositories.StoreRepositoryI;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author capri
 */
public class StoreRepositoryImpl implements StoreRepositoryI {
   
    private List<Store> stores = new ArrayList<>();

    public StoreRepositoryImpl() {
        
        var store1 = new Store((short)1, "Tienda1", "Calle 1");
        stores.add(store1);
        
        var store2 = new Store((short)2, "Tienda2", "Calle 2");
        stores.add(store2);
        
        var store3 = new Store((short)3, "Tienda3", "Calle 3");
        stores.add(store3);
    }
   
    @Override
    public Store create(Store storeToCreate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Store findById(Short idStore) throws StoreNotFoundException {
        Store foundStore = null;
        
        var storeToSearch = new Store(idStore, "", "");
        
        if (!stores.contains(storeToSearch)) {
            throw new StoreNotFoundException("El id suministrado: " + idStore + " no produjo ningún resultado");
        }
        
        for(Store storeToIterate: stores) {
            if (idStore == storeToIterate.getId()) {
                foundStore = storeToIterate;
                break;
            }
        }
        
        return foundStore;
    }

    @Override
    public List<Store> findAll() {
        return stores;
    }

    @Override
    public Store update(Store storeToUpdate) throws StoreNotFoundException {
        var foundStore = findById(storeToUpdate.getId());
        
        foundStore.setName(storeToUpdate.getName());
        foundStore.setAddress(storeToUpdate.getAddress());
        foundStore.setCompany(storeToUpdate.getCompany());
        
        return foundStore;
    }

    @Override
    public void delete(Short idStore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
