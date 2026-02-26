package com.cda.demo.controller;

import com.cda.demo.dto.CategoryCreateDto;
import com.cda.demo.dto.CategoryReadDto;
import com.cda.demo.dto.CategoryUpdateDto;
import com.cda.demo.entity.Category;
import com.cda.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController extends AbstractController<CategoryCreateDto, CategoryUpdateDto, CategoryReadDto> {
    private final CategoryService categoryService;

    @PostMapping("/category")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryReadDto create(@RequestBody CategoryCreateDto categoryCreateDto) {
        Category category = modelMapper.map(categoryCreateDto, Category.class);
        Category categorySaved = this.categoryService.create(category);
        return modelMapper.map(categorySaved, CategoryReadDto.class);
    }
    @GetMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryReadDto findById(@PathVariable Integer id) {
        Category category = this.categoryService.findById(id);
        return modelMapper.map(category, CategoryReadDto.class);
    }
    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryReadDto> findAll() {
        List<CategoryReadDto> categoryDtos = new ArrayList<>();
        for (Category category : this.categoryService.findAll()) {
            categoryDtos.add(modelMapper.map(category, CategoryReadDto.class));
        }
        return categoryDtos;
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
    public CategoryReadDto update(@RequestBody CategoryUpdateDto categoryUpdateDto) {
        Category category = modelMapper.map(categoryUpdateDto, Category.class);
        Category categorySaved = this.categoryService.update(category);
        return modelMapper.map(categorySaved, CategoryReadDto.class);
    }
}
