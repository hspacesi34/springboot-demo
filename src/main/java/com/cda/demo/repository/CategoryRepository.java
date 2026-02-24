package com.cda.demo.repository;

import com.cda.demo.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Optional<Category> findByName(String name);
}
