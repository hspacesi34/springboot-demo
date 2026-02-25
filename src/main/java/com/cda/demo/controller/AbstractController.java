package com.cda.demo.controller;

import com.cda.demo.entity.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URISyntaxException;
import java.util.Map;

public abstract class AbstractController<T extends BaseEntity> {
    public abstract T create(@RequestBody T entity) throws URISyntaxException;
    public abstract T update(@RequestBody T entity);
    public abstract Map<String, String> delete(@PathVariable Integer id);
    public abstract Iterable<T> findAll();
    public abstract T findById(@PathVariable Integer id);
}
