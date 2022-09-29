package com.java.fundamentals.inventario.app.model;

/**
 *
 * @author edala
 */
public class Store {
    private short id;
    private String name;
    private String address;
    private String ciudad;
    private Company empresa;

    public Store(short id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Store(short id, String name, String address, String ciudad) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.ciudad = ciudad;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Company getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Company empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Store{" + "id=" + id + ", name=" + name + ", address=" + address + ", ciudad=" + ciudad + ", empresa=" + empresa + '}';
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Store other = (Store) obj;
        if (obj instanceof Store){
            if (this.id != other.id) {
                return false;
            }         
        }
        return true;
    }
}
