/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.simpleinsight.repository.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bogdan
 */
public abstract class AbstractRepository< T extends Serializable> {

    private Class< T> clazz;
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void setClazz(final Class< T> clazzToSet) {
        clazz = clazzToSet;
    }

    public T findOne(final long id) {
        return (T) entityManager.find(clazz, id);
    }

    public List< T> findAll() {
        return entityManager
                .createQuery("from " + clazz.getName()).getResultList();
    }

    public void save(final T entity) {
        entityManager.persist(entity);
    }

    public T update(final T entity) {
        return (T) entityManager.merge(entity);
    }

    public void delete(final T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(final long id) {
        final T entity = findOne(id);
        delete(entity);
    }
}
