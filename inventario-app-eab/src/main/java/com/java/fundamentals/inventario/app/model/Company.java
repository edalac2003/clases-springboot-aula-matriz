package com.java.fundamentals.inventario.app.model;

/**
 * 
 * @author edala
 */
public class Company {

    private String legalName;
    private String nit;
    private String administrator;

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

}
