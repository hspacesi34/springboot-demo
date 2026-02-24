package com.cda.demo.service;

import com.cda.demo.entity.Category;
import com.cda.demo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService extends AbstractService<Category> {
    private CategoryRepository categoryRepository;

    @Override
    public Category findById(Integer id) throws Exception {
        try {
            Optional<Category> category = this.categoryRepository.findById(id);
            if (category.isPresent()) {
                return category.get();
            }
            throw new Exception("Category not found");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Iterable<Category> findAll() throws Exception {
        try {
            Iterable<Category> categories = this.categoryRepository.findAll();
            if (!categories.iterator().hasNext()) {
                throw new Exception("No categories found");
            }
            return categories;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            if (this.categoryRepository.existsById(id)) {
                this.categoryRepository.deleteById(id);
            }
            throw new Exception("Category not found");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Category create(Category entity) throws Exception {
        try {
            if (this.categoryRepository.findByName(entity.getName()).isPresent()) {
                throw new Exception("Category already exists");
            }
            Category category = this.categoryRepository.save(entity);
            return category;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Category update(Category entity) throws Exception {
        try {
            if (this.categoryRepository.existsById(entity.getId())) {
                if (this.categoryRepository.findByName(entity.getName()).isPresent()) {
                    throw new Exception("Category already exists");
                }
                return this.categoryRepository.save(entity);
            }
            throw new Exception("Category not found");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean exists(Integer id) throws Exception {
        try {
            boolean exists = this.categoryRepository.existsById(id);
            return exists;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
