package com.recantogeek.recantogeekv2.dto;

import com.recantogeek.recantogeekv2.models.CategoryModel;
import lombok.Data;

@Data
public class OneProductDTO {

    private Long id;
    private String name;
    private Double price;
    private String description;
    private Integer rating;
    private Double installments;
    private CategoryModel category;
    private String imageURL;


}
