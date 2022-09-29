package com.java.fundamentals.inventario.app.repositories.impl;

import com.java.fundamentals.inventario.app.exceptions.StoreNotFoundException;
import com.java.fundamentals.inventario.app.model.Store;
import com.java.fundamentals.inventario.app.repositories.StoreRepositoryI;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edala
 */
public class StoreRepositoryImpl implements StoreRepositoryI{
        
    private List<Store> stores = new ArrayList<>();
    
    public StoreRepositoryImpl(){
        stores.add(new Store((short)1, "Tienda 1", "Direccion 1"));
        stores.add(new Store((short)2, "Tienda 2", "Direccion 2"));
        stores.add( new Store((short)3, "Tienda 3", "Direccion 3"));
    }
    
    @Override
    public Store create(Store storeToCreate){
        return null;
    }
    
    @Override
    public Store findById(Short idStore) throws StoreNotFoundException{
        Store foundStore = null;
        if(stores.contains(new Store(idStore, "", ""))){
            for(Store storeIterate : stores){
                if(idStore == storeIterate.getId()){
                    foundStore = storeIterate;
                    break;
                }
            }
            if(foundStore == null){
                throw new StoreNotFoundException("El id suministrado " + idStore + " no produjo ningún resultado.");
            }
        }        
        return foundStore;
    }
    
    @Override
    public List findAll(){
        return stores;
    }
    
    @Override
    public Store update(Store storeToUpdate) throws StoreNotFoundException{
        var foundStore = findById(storeToUpdate.getId());
        foundStore.setName(storeToUpdate.getName());
        foundStore.setAddress(storeToUpdate.getAddress());
        foundStore.setCiudad(storeToUpdate.getCiudad());
                
        return storeToUpdate;
    }
    
    @Override
    public void delete(Short idStore){
        //Buscar y eliminar el Store
//        for (int i = 0; i < stores.length; i++) {
//            if(stores[i].getId() == idStore){
//                stores[i] = null;
//                break;
//            }
//        }
//        
//        //Recorrer y ordenar el array
//        for (int i = 0; i < stores.length-1; i++) {
//            if(stores[i] == null && stores[i+1] != null){
//                stores[i] = stores[i+1];
//                stores[i+1] = null;
//            }
//        }
    }
}
