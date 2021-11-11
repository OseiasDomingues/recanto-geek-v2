package com.recantogeek.recantogeekv2.services.impl;

import com.recantogeek.recantogeekv2.models.ProductModel;
import com.recantogeek.recantogeekv2.repositories.ProductRepository;
import com.recantogeek.recantogeekv2.services.ProductService;
import com.recantogeek.recantogeekv2.services.exceptions.DatabaseException;
import com.recantogeek.recantogeekv2.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public ProductModel save(ProductModel product) {
        return productRepository.save(product);
    }

    @Override
    public ProductModel update(ProductModel product, Long id) {
        ProductModel productToBeUpdated = productRepository.getById(id);
        ProductModel productUpdate = updateDate(product, productToBeUpdated);
        return productRepository.save(productUpdate);
    }

    private ProductModel updateDate(ProductModel product, ProductModel productToBeUpdated) {
        if (!product.getName().isBlank()) {
            productToBeUpdated.setName(product.getName());
        }
        if (!product.getDescription().isBlank()) {
            productToBeUpdated.setDescription(product.getDescription());
        }
        if (!product.getImageURL().isBlank()) {
            productToBeUpdated.setImageURL(product.getImageURL());
        }
        if (product.getCategory() != null) {
            productToBeUpdated.setCategory(product.getCategory());
        }
        if (product.getQuantity() != null) {
            productToBeUpdated.setQuantity(product.getQuantity());
        }
        if (product.getPrice() != null) {
            productToBeUpdated.setPrice(product.getPrice());
            productToBeUpdated.setInstallments(productToBeUpdated.calcInstallment());
        }
        if (product.getRating() != null) {
            productToBeUpdated.setRating(product.getRating());
        }

        return productToBeUpdated;
    }

    @Override
    public void delete(Long id) {
        try{
        productRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
}
