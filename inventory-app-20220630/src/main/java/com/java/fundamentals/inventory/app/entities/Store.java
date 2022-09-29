package com.java.fundamentals.inventory.app.entities;

/**
 *
 * @author capri
 */
//lombok.jar
public class Store {
    
    private Short id;
    private String name;
    private String address;
    private Company company;

    public Store(short id, String name, String address, Company company) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.company = company;
    }

    public Store(short id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Store{id=");
        sb.append(id);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", company=").append(company);
        sb.append('}');
        return sb.toString();
    }
    
  //lombok.jar

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
