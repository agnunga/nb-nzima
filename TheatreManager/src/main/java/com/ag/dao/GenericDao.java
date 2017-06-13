package com.ag.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 3/23/2017.
 *
 * @param <T>
 * @param <PK>
 */
public class GenericDao<T, PK extends Serializable> implements GenericDaoI<T, PK> {

    private Class<T> entityClass;
    public EntityManager entityManager;
    private Logger jLogger;

    public GenericDao(Class<T> entityClass, EntityManager entityManager) {
        this.entityClass = entityClass;
        this.entityManager = entityManager;
        this.jLogger = LoggerFactory.getLogger(entityClass);
    }

    @Override
    public T save(T t) {
        jLogger.info(t.toString());
        try {
            this.entityManager.persist(t);
            return t;
        } catch (PersistenceException pe) {
            jLogger.error(pe.getMessage());
            return null;
        }
    }

    @Override
    public T findById(PK id) {
        jLogger.info(id.toString());
        try {
            return this.entityManager.find(entityClass, id);
        } catch (PersistenceException pe) {
            jLogger.error(pe.getMessage());
            return null;
        }
    }

    @Override
    public T merge(T t) {
        jLogger.info(t.toString());
        try {
            return this.entityManager.merge(t);
        } catch (PersistenceException pe) {
            jLogger.error(pe.getMessage());
            return null;
        }
    }

    @Override
    public List<T> findAll() {
        jLogger.warn("Finding all");
        jLogger.warn("EM: " + entityManager);
        return this.entityManager.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t").getResultList();
    }

    @Override
    public boolean remove(T t) {
        jLogger.info(t.toString());
        try {
            t = this.entityManager.merge(t);
            this.entityManager.remove(t);
            return true;
        } catch (PersistenceException pe) {
            jLogger.error(pe.getMessage());
            return false;
        }
    }
}
