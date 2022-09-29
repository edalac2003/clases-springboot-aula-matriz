/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.fundamentals.inventario.app.repositories;

import java.util.List;

/**
 *
 * @author edala
 */
public interface RepositoryI<T, ID> {
    
    public T create(T entityToCreate);
    public T update(T entityToUpdate) throws Exception;
    public T findById(ID entityId) throws Exception;
    public List<T> findAll();
    public void delete(ID entityId);
}
