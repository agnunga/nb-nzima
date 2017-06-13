package com.ag.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDaoI<T, PK extends Serializable> {

    T save(T t);

    T findById(PK id);

    T merge(T t);

    List<T> findAll();

    boolean remove(T t);
}
