package com.cda.demo.service;

import com.cda.demo.entity.BaseEntity;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractService<T extends BaseEntity> {

    public abstract T findById(Integer id) throws Exception;
    public abstract Iterable<T> findAll() throws Exception;
    public abstract void delete(Integer id) throws Exception;
    public abstract T create(T entity) throws Exception;
    public abstract T update(T entity) throws Exception;
    public abstract boolean exists(Integer id) throws Exception;

}
