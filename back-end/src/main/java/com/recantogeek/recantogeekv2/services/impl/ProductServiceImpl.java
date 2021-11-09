package com.recantogeek.recantogeekv2.services.impl;

import com.recantogeek.recantogeekv2.models.ProductModel;
import com.recantogeek.recantogeekv2.repositories.ProductRepository;
import com.recantogeek.recantogeekv2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductModel> findByCategory(Long id) {
        List<ProductModel> productList = productRepository.findAll();
        return productList.stream().filter(product -> product.getCategory().getId().equals(id)).collect(Collectors.toList());
    }

    @Override
    public ProductModel findById(Long id) {
        return productRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public ProductModel save(ProductModel product) {
        return productRepository.save(product);
    }
}
