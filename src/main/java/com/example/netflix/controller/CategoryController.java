package com.example.netflix.controller;

import com.example.netflix.model.Category;
import com.example.netflix.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "categories")
    public List<Category> getCategories(){
        return categoryService.getAllCategories();
    }

}
