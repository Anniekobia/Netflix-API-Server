package com.example.netflix.services;

import com.example.netflix.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category findById(Long id);

    Category updateCategory(Category category);
}
