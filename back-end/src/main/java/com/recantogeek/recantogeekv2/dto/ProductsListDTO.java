package com.recantogeek.recantogeekv2.dto;


import com.recantogeek.recantogeekv2.models.CategoryModel;
import lombok.Data;

@Data
public class ProductsListDTO {

    private Long id;
    private String name;
    private Double price;
    private Integer rating;
    private String imageURL;
    private CategoryModel category;

}
