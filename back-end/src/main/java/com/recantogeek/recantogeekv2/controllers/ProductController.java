package com.recantogeek.recantogeekv2.controllers;

import com.recantogeek.recantogeekv2.models.ProductModel;
import com.recantogeek.recantogeekv2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    ResponseEntity<List<ProductModel>> findAll(){
        List<ProductModel> allProducts = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(allProducts);
    }

    @GetMapping("products/{id}")
    ResponseEntity<ProductModel> findById(@PathVariable Long id){
        ProductModel product = productService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/category/{id}")
    ResponseEntity<List<ProductModel>> findByCategory(@PathVariable Long id){
        List<ProductModel> productByCategory  = productService.findByCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body(productByCategory);
    }

    @PostMapping("/products")
    ResponseEntity<ProductModel> insert(@RequestBody ProductModel product){
        ProductModel newProduct = productService.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(newProduct);
    }

}
