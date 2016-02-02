package com.ted.stream.mongo.service;

import java.util.List;

import com.ted.stream.mongo.entity.Category;

public interface CategoryService {
    
    Category createCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategory(String id);
    List<Category> findAll();
    void removeAll();
    Category findUserById(String id);
}
