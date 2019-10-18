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
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()->new NotFoundException("No record with id "+id+" found"));
    }

    @Override
    public Category updateCategory(Category category) {
        Category category1 = findById(category.getId());
        category1.setName(category.getName());
        return categoryRepository.save(category1);

    }
}
