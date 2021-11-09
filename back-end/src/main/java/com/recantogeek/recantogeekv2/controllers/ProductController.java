package com.recantogeek.recantogeekv2.controllers;

import com.recantogeek.recantogeekv2.dto.NewProductDTO;
import com.recantogeek.recantogeekv2.dto.OneProductDTO;
import com.recantogeek.recantogeekv2.dto.ProductsListDTO;
import com.recantogeek.recantogeekv2.mapper.ProductMapper;
import com.recantogeek.recantogeekv2.models.ProductModel;
import com.recantogeek.recantogeekv2.services.CategoryService;
import com.recantogeek.recantogeekv2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductMapper productMapper;

    @GetMapping("/products")
    ResponseEntity<List<ProductsListDTO>> findAll(){
        categoryService.findAll(); //for mem cache
        List<ProductModel> allProducts = productService.findAll();
        List<ProductsListDTO> productsDTOS = allProducts
                .stream()
                .map(productMapper::productListToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(productsDTOS);
    }

    @GetMapping("products/{id}")
    ResponseEntity<OneProductDTO> findById(@PathVariable Long id){
        ProductModel product = productService.findById(id);
        OneProductDTO productDTO = productMapper.oneProductToDTO(product);
        return ResponseEntity.status(HttpStatus.OK).body(productDTO);
    }

    @GetMapping("/category/{id}")
    ResponseEntity<List<ProductsListDTO>> findByCategory(@PathVariable Long id){
        categoryService.findAll(); //for mem cache
        List<ProductModel> productByCategory = productService.findByCategory(id);
        List<ProductsListDTO> productsListDTOS = productByCategory.stream().map(productMapper::productListToDTO).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(productsListDTOS);
    }

    @PostMapping("/products")
    ResponseEntity<ProductModel> insert(@Valid @RequestBody NewProductDTO newProductDTO){
        ProductModel newObj = productMapper.toObj(newProductDTO);
        ProductModel newProduct = productService.save(newObj);
        return ResponseEntity.status(HttpStatus.OK).body(newProduct);
    }

}
