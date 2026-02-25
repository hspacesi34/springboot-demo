package com.cda.demo.service;

import com.cda.demo.entity.Category;
import com.cda.demo.exception.ResourceAlreadyExistsException;
import com.cda.demo.exception.ResourceNotFoundException;
import com.cda.demo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService extends AbstractService<Category> {
    private CategoryRepository categoryRepository;

    @Override
    public Category findById(Integer id) {
        return this.categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Category.class));
    }

    @Override
    public Iterable<Category> findAll() {
        Iterable<Category> categories = this.categoryRepository.findAll();
        if (!categories.iterator().hasNext()) {
            throw new ResourceNotFoundException(Category.class);
        }
        return categories;
    }

    @Override
    public void delete(Integer id) {
        if (this.categoryRepository.existsById(id)) {
            this.categoryRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(Category.class);
        }
    }

    @Override
    public Category create(Category entity) {
        if (this.categoryRepository.findByName(entity.getName()).isPresent()) {
            throw new ResourceAlreadyExistsException(Category.class);
        }
        Category category = this.categoryRepository.save(entity);
        return category;
    }

    @Override
    public Category update(Category entity) {
        if (this.categoryRepository.existsById(entity.getId())) {
            if (this.categoryRepository.findByName(entity.getName()).isPresent()) {
                throw new ResourceAlreadyExistsException(Category.class);
            }
            return this.categoryRepository.save(entity);
        }
        throw new ResourceNotFoundException(Category.class);
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
