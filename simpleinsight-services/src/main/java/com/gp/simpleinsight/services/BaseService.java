package com.gp.simpleinsight.services;

import java.util.List;

/**
 *
 * @author bogdan
 * @param <T>
 */
public interface BaseService<T> {

    public List<T> findAll();

    public T save(T entity);

    public T findById(Long entityId);

}
