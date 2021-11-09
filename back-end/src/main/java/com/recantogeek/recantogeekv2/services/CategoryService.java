package com.recantogeek.recantogeekv2.services;

import com.recantogeek.recantogeekv2.models.CategoryModel;

import java.util.List;

public interface CategoryService {
    
    List<CategoryModel> findAll();
    CategoryModel findById(Long id);
    CategoryModel save(CategoryModel category);
}
