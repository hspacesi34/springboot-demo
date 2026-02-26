package com.cda.demo.service;

import org.springframework.stereotype.Service;

@Service
public abstract class AbstractService<T> {
    public abstract T findById(Integer id);
    public abstract Iterable<T> findAll();
    public abstract void delete(Integer id);
    public abstract T create(T entity);
    public abstract T update(T entity);
}
