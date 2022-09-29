package com.java.fundamentals.inventory.app;

import com.java.fundamentals.inventory.app.entities.Product;
import com.java.fundamentals.inventory.app.entities.Store;
import com.java.fundamentals.inventory.app.exceptions.InvalidMeasureUnitException;
import com.java.fundamentals.inventory.app.exceptions.InvalidProductQuantityException;
import com.java.fundamentals.inventory.app.exceptions.StoreNotFoundException;
import com.java.fundamentals.inventory.app.repositories.impl.ProductRepositoryImpl;
import com.java.fundamentals.inventory.app.repositories.impl.StoreRepositoryImpl;
import com.java.fundamentals.inventory.app.services.ProductServiceI;
import com.java.fundamentals.inventory.app.services.StoreServiceI;
import com.java.fundamentals.inventory.app.services.impl.ProductServiceImpl;
import com.java.fundamentals.inventory.app.services.impl.StoreServiceImpl;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author capri
 */
public class InventoryApp {
    
    private StoreServiceI storeServiceI;
    private ProductServiceI productServiceI;
    
    public InventoryApp(StoreServiceI storeServiceI, ProductServiceI productServiceI) {
        this.storeServiceI = storeServiceI; 
        this.productServiceI = productServiceI;
    }
    
    public static void main(String[] args) {
        var storeRepository = new StoreRepositoryImpl();
        var storeService = new StoreServiceImpl(storeRepository);
        var productService = new ProductServiceImpl(new ProductRepositoryImpl());
        
        var  inventoryApp = new InventoryApp(storeService, productService);
        
        storeService.checkStores();
        
        switch(args[0]) {
            case "findAllStores": 
                inventoryApp.findAllStores();
                break;
            case "findStoreById":
                inventoryApp.findStoreById();
                break;
            case "updateStore":
                inventoryApp.updateStore();
                break;
            case "registerANewProduct":
                inventoryApp.registerANewProduct();
                break;
            default:
                System.out.println("No se reconoció ninguna operación!!");
                break;
        }
    }
    
    public void findAllStores() {
        var foundStores = this.storeServiceI.findAll();
        
        for (Store foundStore : foundStores) {
            System.out.println("La tienda encontrada es: " + foundStore);
        }
    }
    
    public void findStoreById() {
        Store foundStore;
        try {
            foundStore = this.storeServiceI.findById((short)2);
             System.out.println("La información de la tienda es: " + foundStore.toString());
        } catch (StoreNotFoundException ex) {
            Logger.getLogger(InventoryApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(InventoryApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateStore() {
        var storeToUpdate = new Store((short)4, "Tienda1 modificada", "Calle 1");
        
        try {
            var updatedStore = this.storeServiceI.update(storeToUpdate);
            System.out.println("La tienda modificada es: " + updatedStore);
        } catch(StoreNotFoundException storeNotFoundException) {
            Logger.getLogger(InventoryApp.class.getName()).log(Level.SEVERE, null, storeNotFoundException);
        } catch (Exception ex) {
            Logger.getLogger(InventoryApp.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void registerANewProduct() {
        var productToRegister = new Product();
        productToRegister.setCurrentQuantity(10000);
        productToRegister.setName("Café");
        //productToRegister.setMeasureUnit(GR);
        productToRegister.setMinQuantity(1000);
        
        Store store = new Store((short)0, "", "");
        try {
            store = storeServiceI.findById((short)1);
        } catch (StoreNotFoundException ex) {
            Logger.getLogger(InventoryApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(InventoryApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        productToRegister.setStore(store);
        
        try {
            productServiceI.registerProduct(productToRegister);
        } catch (InvalidMeasureUnitException | InvalidProductQuantityException ex) {//Multi-catch
            Logger.getLogger(InventoryApp.class.getName()).log(Level.SEVERE, null, ex);
            //Enviando un correo a un administrador.....
        } catch (Exception ex) {
            Logger.getLogger(InventoryApp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println("Este bloque de código siempre se ejecuta"); 
        }
        
        System.out.println("La operación de registro de producto fue ejecutada");
        
        //Invocar una nueva operación que devuelva la lista de productos.
        //Imprimir la lista de productos.
        
    }
}
