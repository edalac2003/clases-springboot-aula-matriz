package com.java.programming.ii.junio.io;

import java.io.Serializable;

/**
 *
 * @author edala
 */
public class Cliente implements Serializable{
    
    private static final long serialVersionUID = 1000L;
    
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", name=" + name + '}';
    }
}
