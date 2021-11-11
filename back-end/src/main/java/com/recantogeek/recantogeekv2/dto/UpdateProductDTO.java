package com.recantogeek.recantogeekv2.dto;


import com.recantogeek.recantogeekv2.models.CategoryModel;
import lombok.Data;

@Data
public class UpdateProductDTO {

    private Long id;
    private String name;
    private Double price;
    private String description;
    private Integer rating;
    private CategoryModel category;
    private Integer quantity;
    private String imageURL;


}
