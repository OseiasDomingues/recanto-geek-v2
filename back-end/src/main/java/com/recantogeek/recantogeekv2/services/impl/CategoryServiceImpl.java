package com.recantogeek.recantogeekv2.services.impl;

import com.recantogeek.recantogeekv2.models.CategoryModel;
import com.recantogeek.recantogeekv2.repositories.CategoryRepository;
import com.recantogeek.recantogeekv2.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryModel> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryModel findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public CategoryModel insert(CategoryModel category) {
        return categoryRepository.save(category);
    }
}
