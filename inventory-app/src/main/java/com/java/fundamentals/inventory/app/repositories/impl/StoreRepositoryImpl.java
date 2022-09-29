package com.java.fundamentals.inventory.app.repositories.impl;

import com.java.fundamentals.inventory.app.entities.Store;
import com.java.fundamentals.inventory.app.exceptions.StoreNotFoundException;
import com.java.fundamentals.inventory.app.repositories.StoreRepositoryI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.Driver;

/**
 *
 * @author capri
 */
public class StoreRepositoryImpl implements StoreRepositoryI {
   
    private List<Store> stores = new ArrayList<>();
    
    private static short i = 3;
    

    public StoreRepositoryImpl() {
        
        var store1 = new Store((short)1, "Tienda1", "Calle 1");
        stores.add(store1);
        
        var store2 = new Store((short)2, "Tienda2", "Calle 2");
        stores.add(store2);
        
        var store3 = new Store((short)3, "Tienda3", "Calle 3");
        stores.add(store3);
    }
    
    private static short getI() {
        return i;
    }
    
    private short incrementI() {
       i = (short)(getI() + 1);
       return i;
        
    }
   
    @Override
    public Store create(Store storeToCreate) {
        System.out.println("" + Thread.currentThread().getName());
        short idToAssign = incrementI();
       
        storeToCreate.setId(idToAssign);
        stores.add(storeToCreate);
       
        return storeToCreate;
    }

    @Override
    public Store findById(Short idStore) throws StoreNotFoundException {
        
        return stores.stream()
                     .filter((Store store) -> store.getId() == idStore)
                     .findAny()
                     .orElseThrow(() -> new StoreNotFoundException("El id suministrado: " + idStore + " no produjo ningún resultado"));
    }

    @Override
    public List<Store> findAll() {
        String url = "jdbc:postgresql://localhost:5432/inventoryApp";
        String user = "postgres";
        String password = ".r00t.s0p0rt3";
        String query = "SELECT * FROM public.\"TBL_STORE\"";
        List<Store> storesFromBD = new ArrayList<Store>();
        
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException ex) {
            Logger.getLogger(StoreRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try(Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();) {
            
            Store store;
            while(resultSet.next()){
                store = new Store(resultSet.getShort("ID"), resultSet.getString("NAME"), resultSet.getString("ADDRESS"));
                storesFromBD.add(store);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoreRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return storesFromBD;
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
