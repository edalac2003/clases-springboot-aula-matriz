package com.java.fundamentals.inventory.app.constants;

/**
 *
 * @author capri
 */
public enum MeasureUnit {
    
    GR("GRMS","01"),
    LT("LITROS", "02"),
    UT("UNIDAD"),
    OZ("ONZAS", "04");
    
    private final String unitName;
    private final String unitCode;
    
    private MeasureUnit(String unitName, String unitCode){
        this.unitName = unitName;
        this.unitCode = unitCode;
    }
    
    private MeasureUnit(String unitName) {
        this.unitName = unitName;
        this.unitCode = "1000";
    }

    public String getUnitName() {
        return unitName;
    }

    public String getUnitCode() {
        return unitCode;
    }
}
