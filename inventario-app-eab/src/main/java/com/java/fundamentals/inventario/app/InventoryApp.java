package com.java.fundamentals.inventario.app;

import com.java.fundamentals.inventario.app.exceptions.InvalidMeasureUnitException;
import com.java.fundamentals.inventario.app.exceptions.InvalidProductQuantityException;
import com.java.fundamentals.inventario.app.exceptions.StoreNameTooLongException;
import com.java.fundamentals.inventario.app.exceptions.StoreNotFoundException;
import com.java.fundamentals.inventario.app.model.Product;
import com.java.fundamentals.inventario.app.model.Store;
import com.java.fundamentals.inventario.app.repositories.impl.ProductRepositoryImpl;
import com.java.fundamentals.inventario.app.repositories.impl.StoreRepositoryImpl;
import com.java.fundamentals.inventario.app.services.ProductServiceI;
import com.java.fundamentals.inventario.app.services.StoreServiceI;
import com.java.fundamentals.inventario.app.services.impl.ProductServiceImpl;
import com.java.fundamentals.inventario.app.services.impl.StoreServiceImpl;
import com.java.fundamentals.inventario.app.utils.MeasureUnit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edwin Acosta Bravo
 */
public class InventoryApp {
    
    private StoreServiceI storeServiceI;
    private ProductServiceI productServiceI;

    public InventoryApp(StoreServiceI storeServiceI, ProductServiceI productServiceI) {
        this.storeServiceI = storeServiceI;
        this.productServiceI = productServiceI;
    }
    
    public static void main(String[] args) {
        try {
            var storeRepositoryImpl = new StoreRepositoryImpl();
            var storeService = new StoreServiceImpl(storeRepositoryImpl);
            var productService = new ProductServiceImpl(new ProductRepositoryImpl());
            
            var inventoryApp = new InventoryApp(storeService, productService);
            
            storeService.checkStores();
            switch(args[0]){
                case "findAllStores":
                    inventoryApp.findAllStores();
                    break;
                case "findStoreById":
                    inventoryApp.findStoreById();
                    break;
                case "update":
                    inventoryApp.update();
                    break;
                case "delete":
                    inventoryApp.delete();
                    break;
                case "registerNewProduct":
                    inventoryApp.registerNewProduct();
                    break;
                default:
                    System.out.println("No se reconoció ninguna operacion");
                    break;               
            }
        } catch (Exception ex) {
            Logger.getLogger(InventoryApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void findAllStores(){
        List<Store> foundStores = this.storeServiceI.findAll();
                
        for(Store foundStore: foundStores) {
            if(foundStore != null){
                System.out.println("Las tiendas encontradas son : " + foundStore);            
            }
        }        
    }
    
    public void findStoreById() throws Exception{
        Store foundStore;
        try {
            foundStore = this.storeServiceI.findById((short)2);
            System.out.println("La información de la tienda es: " + foundStore);
        } catch (StoreNotFoundException ex) {
            Logger.getLogger(InventoryApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void  update(){
        try {
            var storeToUpdate = new Store((short)1, "Tienda", "Una Nueva direccion", "New York");                        
            var updatedStore = this.storeServiceI.update(storeToUpdate);
            System.out.println("La tienda actualizada es: " + updatedStore);
            
        } catch (StoreNotFoundException ex) {
            Logger.getLogger(InventoryApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (StoreNameTooLongException ex1) {
            Logger.getLogger(InventoryApp.class.getName()).log(Level.SEVERE, ex1.getMessage(), ex1);
        } catch (Exception ex) {
            Logger.getLogger(InventoryApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        this.storeServiceI.delete((short)3);        
        this.findAllStores();
    }
    
    public void registerNewProduct(){
        var productToRegister = new Product();
        productToRegister.setId((short)1);
        productToRegister.setCurrentQuantity(10000);
        productToRegister.setName("Cafe");
        productToRegister.setMeasureUnit(MeasureUnit.GR);
        productToRegister.setMinQuantity(1000);
        
        Store store = null;
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
        } catch (InvalidMeasureUnitException | InvalidProductQuantityException ex) {
            Logger.getLogger(InventoryApp.class.getName()).log(Level.   SEVERE, null, ex);
        }finally{
            System.out.println("ESTE BLOQUE DE COPDIGO SIEMPRE SE EJECUTA");
        }
        
        List<Product> lista = this.findAll();
        System.out.println("PRODUCTOS REGISTRADOS");
        for(Product prod : lista){
            System.out.println("Producto " + prod);
        }
    }
    
    public List<Product> findAll(){
        return null;
    }
}
