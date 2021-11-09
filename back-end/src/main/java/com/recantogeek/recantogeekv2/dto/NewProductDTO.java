package com.recantogeek.recantogeekv2.dto;


import com.recantogeek.recantogeekv2.models.CategoryModel;
import lombok.Data;

@Data
public class NewProductDTO {

    private String name;
    private Double price;
    private String description;
    private Integer rating;
    private CategoryModel category;
    private Integer quantity;


}
