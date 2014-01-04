package com.gp.simpleinsight.repository.impl;

import com.gp.simpleinsight.util.CurrentTenantResolver;
import com.gridpulse.simpleinsight.domain.MultiTennantDomainObject;
import com.gridpulse.simpleinsight.domain.Organization;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 *
 * @author bogdan
 * @param <T> the type that will be handled by the repository
 */
public abstract class AbstractRepository< T extends Object, ID extends Serializable> {

    private Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    @Resource(name = "tenantResolver")
    CurrentTenantResolver<Organization> tenantResolver;

    public AbstractRepository() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T findOne(final ID id) {
        return (T) entityManager.find(clazz, id);
    }

    public long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<T> findAll(Iterable<ID> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<T> findAll() {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(clazz);
        Root root = query.from(clazz);

        if (isMultiTenantAware(clazz)) {
            query.where(builder.equal(root.get("organization"), tenantResolver.getCurrentTenant()));
        }

        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public <S extends T> S save(S entity) {

        if (isMultiTenantAware(entity.getClass())) {
            ((MultiTennantDomainObject) entity).setOrganization(tenantResolver.getCurrentTenant());
        }

        entity = entityManager.merge(entity);
        return entity;
    }

    public <S extends T> List<S> save(Iterable<S> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public T update(final T entity) {
        return (T) entityManager.merge(entity);
    }

    public void delete(ID id) {
        T entity = findOne(id);
        if (entity != null) {
            delete(entity);
        }
    }

    public void delete(final T entity) {
        entityManager.remove(entity);
    }

    public void delete(Iterable<? extends T> itrbl) {
        for (T entity : itrbl) {
            delete(entity);
        }
    }

    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean exists(ID id) {
        return entityManager.contains(id);
    }

    public List<T> findAll(Sort sort) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public T saveAndFlush(T t) {
        t = save(t);
        flush();
        return t;
    }

    public void deleteInBatch(Iterable<T> itrbl) {
        delete(itrbl);
    }

    public void deleteAllInBatch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Page<T> findAll(Pageable pgbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void flush() {
        entityManager.flush();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void setClazz(final Class< T> clazzToSet) {
        clazz = clazzToSet;
    }

    private Boolean isMultiTenantAware(Class c) {
        return MultiTennantDomainObject.class.isAssignableFrom(c);
    }

}
