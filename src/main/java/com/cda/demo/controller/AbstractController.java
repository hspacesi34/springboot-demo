package com.cda.demo.controller;

import com.cda.demo.entity.AbstractEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public abstract class AbstractController<T extends AbstractEntity> {
    public abstract ResponseEntity create(@RequestBody T entity);
    public abstract ResponseEntity update(@RequestBody T entity);
    public abstract ResponseEntity<Map<String, String>> delete(@PathVariable Integer id);
    public abstract ResponseEntity<Iterable<T>> findAll();
    public abstract ResponseEntity<T> findById(@PathVariable Integer id);
}
