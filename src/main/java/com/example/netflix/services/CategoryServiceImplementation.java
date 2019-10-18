package com.example.netflix.services;

import com.example.netflix.NotFoundException;
import com.example.netflix.model.Category;
import com.example.netflix.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImplementation implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImplementation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(()->new NotFoundException("No such category found"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
