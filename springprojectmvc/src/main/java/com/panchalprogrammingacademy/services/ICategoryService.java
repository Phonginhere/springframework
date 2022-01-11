package com.panchalprogrammingacademy.services;

import com.panchalprogrammingacademy.model.Category;

import java.util.List;

public interface ICategoryService {
//    public Category create(Category category);
    List<Category> findAll();
}
