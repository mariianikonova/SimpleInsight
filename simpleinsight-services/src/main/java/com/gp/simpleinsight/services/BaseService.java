package com.gp.simpleinsight.services;

import java.util.List;

/**
 *
 * @author bogdan
 * @param <T>
 */
public interface BaseService<T> {

    public List<T> findAll();

}
