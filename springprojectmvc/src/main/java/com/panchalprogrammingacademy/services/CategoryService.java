package com.panchalprogrammingacademy.services;

import com.panchalprogrammingacademy.model.Category;
import com.panchalprogrammingacademy.model.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryService iCategoryService;

    @Override
    public List<Category> findAll(){
        return (List<Category>) iCategoryService.findAll();
    }
}
