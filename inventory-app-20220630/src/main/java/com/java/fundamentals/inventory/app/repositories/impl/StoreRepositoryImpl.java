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
    
    public static short i = 4;

    public StoreRepositoryImpl() {
        
        var store1 = new Store((short)1, "Tienda de la Alegria", "Calle 1");
        stores.add(store1);
        
        var store2 = new Store((short)2, "T-01", "Calle 2");
        stores.add(store2);
        
        var store3 = new Store((short)3, "Tienda3", "Calle 3");
        stores.add(store3);
        
//        var store4 = new Store((short)4, "T-02", "Transversal 2");
//        stores.add(store4);
//        
//        var store5 = new Store((short)5, "Tienda don chucho", "Avenida 3");
//        stores.add(store5);
    }
    
    private static short getI(){
        return i;
    }
    
    private static short incrementI(){
        return (short) (getI() + 1);
    }
   
    @Override
    public Store create(Store storeToCreate) {
        short idToAssign  = incrementI();
        storeToCreate.setId(idToAssign);
        stores.add(storeToCreate);
        
        return storeToCreate;
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
