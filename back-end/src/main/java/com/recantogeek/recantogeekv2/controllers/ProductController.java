package com.recantogeek.recantogeekv2.controllers;

import com.recantogeek.recantogeekv2.dto.NewProductDTO;
import com.recantogeek.recantogeekv2.dto.OneProductDTO;
import com.recantogeek.recantogeekv2.dto.ProductsListDTO;
import com.recantogeek.recantogeekv2.dto.UpdateProductDTO;
import com.recantogeek.recantogeekv2.mapper.ProductMapper;
import com.recantogeek.recantogeekv2.models.ProductModel;
import com.recantogeek.recantogeekv2.services.CategoryService;
import com.recantogeek.recantogeekv2.services.ProductService;
import com.recantogeek.recantogeekv2.services.exceptions.FieldInvalidException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Api
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductMapper productMapper;

    @GetMapping("/products")
    @ApiOperation("Retorna todos os produtos")
    ResponseEntity<List<ProductsListDTO>> findAll() {
        categoryService.findAll(); //for mem cache
        List<ProductModel> allProducts = productService.findAll();
        List<ProductsListDTO> productsDTOS = allProducts
                .stream()
                .map(productMapper::productListToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(productsDTOS);
    }

    @GetMapping("products/{id}")
    @ApiOperation("Retorna um determinado produto")
    ResponseEntity<OneProductDTO> findById(@PathVariable Long id) {
        ProductModel product = productService.findById(id);
        OneProductDTO productDTO = productMapper.oneProductToDTO(product);
        return ResponseEntity.status(HttpStatus.OK).body(productDTO);
    }

    @GetMapping("/category/{id}")
    @ApiOperation("Retorna todos os produtos de uma determinada categoria")
    ResponseEntity<List<ProductsListDTO>> findByCategory(@PathVariable Long id) {
        categoryService.findAll(); //for mem cache
        List<ProductModel> productByCategory = productService.findByCategory(id);
        List<ProductsListDTO> productsListDTOS = productByCategory.stream().map(productMapper::productListToDTO).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(productsListDTOS);
    }

    @PostMapping("/products")
    @ApiOperation("Adiciona um novo produto")
    ResponseEntity<ProductModel> insert(@Valid @RequestBody NewProductDTO newProductDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FieldInvalidException("Algum campo está invalido!");
        }
        ProductModel newObj = productMapper.toObj(newProductDTO);
        ProductModel newProduct = productService.save(newObj);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @PutMapping("/products/{id}")
    @ApiOperation("Atualiza um produto")
    ResponseEntity<ProductModel> update(@RequestBody UpdateProductDTO updateProductDTO, @PathVariable Long id) {
        ProductModel updateObj = productMapper.toUpdateObj(updateProductDTO);
        ProductModel updatedProduct = productService.update(updateObj, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    @DeleteMapping("/products/{id}")
    @ApiOperation("Deleta um produto")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
