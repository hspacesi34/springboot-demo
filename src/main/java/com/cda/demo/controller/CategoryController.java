package com.cda.demo.controller;

import com.cda.demo.entity.Category;
import com.cda.demo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CategoryController extends AbstractController<Category> {
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity create(@RequestBody Category category) {
        try {
            Category categorySaved = this.categoryService.create(category);
            return ResponseEntity.created(new URI("")).body(categorySaved);
        } catch (Exception e) {
            if (e.getMessage().contains("Category already exists")) {
                Map<String, String> map = new HashMap<>();
                map.put("error", e.getMessage());
                return ResponseEntity.badRequest().body(map);
            }
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        try {
            Category category = this.categoryService.findById(id);
            return ResponseEntity.ok().body(category);
        } catch (Exception e) {
            if (e.getMessage().contains("Category not found")) {
                return ResponseEntity.notFound().build();
            }
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping("/categories")
    public ResponseEntity<Iterable<Category>> findAll() {
        try {
            Iterable<Category> categories = this.categoryService.findAll();
            return ResponseEntity.ok().body(categories);
        } catch (Exception e) {
            if (e.getMessage().contains("No categories found")) {
                return ResponseEntity.notFound().build();
            }
            throw new RuntimeException(e.getMessage());
        }
    }
    @DeleteMapping("/category/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer id) {
        try {
            this.categoryService.delete(id);
            Map<String,String> map = new HashMap<>();
            map.put("message","Category deleted");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            if (e.getMessage().contains("Category not found")) {
                return ResponseEntity.notFound().build();
            }
            throw new RuntimeException(e.getMessage());
        }
    }
    @PutMapping("/category")
    public ResponseEntity update(@RequestBody Category category) {
        try {
            Category categoryUpdated = categoryService.update(category);
            return ResponseEntity.ok().body(categoryUpdated);
        } catch (Exception e) {
            if (e.getMessage().contains("Category not found")) {
                return ResponseEntity.notFound().build();
            }
            if (e.getMessage().contains("Category already exists")) {
                Map<String, String> map = new HashMap<>();
                map.put("error", e.getMessage());
                return ResponseEntity.badRequest().body(map);
            }
            throw new RuntimeException(e.getMessage());
        }
    }
}
