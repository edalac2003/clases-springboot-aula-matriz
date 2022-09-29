package com.java.fundamentals.inventario.app.utils;

public enum MeasureUnit {
    GR("GRAMOS", "01"), 
    LT("LITROS", "02"), 
    OZ("UNIDAD", "03"), 
    UT("ONZAS", "04");

    private final String unitName;
    private final String unitCode;
    
    private MeasureUnit(String unitName, String unitCode) {
        this.unitName = unitName;
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public String getUnitCode() {
        return unitCode;
    }
    
    

}
