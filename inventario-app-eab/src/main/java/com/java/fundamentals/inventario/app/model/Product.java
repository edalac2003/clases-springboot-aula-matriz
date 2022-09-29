package com.java.fundamentals.inventario.app.model;

import com.java.fundamentals.inventario.app.utils.MeasureUnit;

/**
 *
 * @author edala
 */
public class Product {
    private short id;
    private String name;
    private float currentQuantity;
    private float minQuantity;
    private MeasureUnit measureUnit;
    private Store store;

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(float currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public float getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(float minQuantity) {
        this.minQuantity = minQuantity;
    }

    public MeasureUnit getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(MeasureUnit measureUnit) {
        this.measureUnit = measureUnit;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", currentQuantity=" + currentQuantity + ", minQuantity=" + minQuantity + ", measureUnit=" + measureUnit + ", store=" + store + '}';
    }
    
    
}
