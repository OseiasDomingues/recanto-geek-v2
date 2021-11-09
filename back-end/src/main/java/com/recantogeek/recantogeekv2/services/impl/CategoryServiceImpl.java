package com.recantogeek.recantogeekv2.services.impl;

import com.recantogeek.recantogeekv2.models.CategoryModel;
import com.recantogeek.recantogeekv2.repositories.CategoryRepository;
import com.recantogeek.recantogeekv2.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public CategoryModel save(CategoryModel category) {
        return categoryRepository.save(category);
    }
}
