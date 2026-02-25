package com.cda.demo.controller;

import com.cda.demo.entity.Category;
import com.cda.demo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CategoryController extends AbstractController<Category> {
    private CategoryService categoryService;

    @PostMapping("/category")
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody Category category) throws URISyntaxException {
        return this.categoryService.create(category);
    }
    @GetMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category findById(@PathVariable Integer id) {
        return this.categoryService.findById(id);
    }
    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Category> findAll() {
        return this.categoryService.findAll();
    }
    @DeleteMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> delete(@PathVariable Integer id) {
        this.categoryService.delete(id);
        Map<String,String> map = new HashMap<>();
        map.put("message","Category deleted");
        return map;
    }
    @PutMapping("/category")
    @ResponseStatus(HttpStatus.OK)
    public Category update(@RequestBody Category category) {
        return categoryService.update(category);
    }
}
