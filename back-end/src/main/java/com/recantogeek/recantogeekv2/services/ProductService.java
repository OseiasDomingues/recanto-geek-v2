package com.recantogeek.recantogeekv2.services;

import com.recantogeek.recantogeekv2.models.ProductModel;

import java.util.List;

public interface ProductService {

    List<ProductModel> findAll();
    List<ProductModel> findByCategory(Long id);
    ProductModel findById(Long id);
    ProductModel save(ProductModel product);
    ProductModel update(ProductModel product,Long id);
    void delete(Long id);

}
