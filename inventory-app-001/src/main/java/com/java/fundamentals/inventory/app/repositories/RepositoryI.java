package com.java.fundamentals.inventory.app.repositories;

import java.util.List;

/**
 *
 * @author capri
 */
public interface RepositoryI<T,ID> {
    
    public T create(T entityToCreate);
    public T update(T entityToUpdate) throws Exception;
    public T findById(ID entityId) throws Exception;
    public List<T> findAll();
    public void delete(ID entityId);
    
}
