package com.recantogeek.recantogeekv2.dto;


import com.recantogeek.recantogeekv2.models.CategoryModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class NewProductDTO {

    @NotBlank
    private String name;
    @NotNull
    private Double price;
    @NotBlank
    private String description;
    @NotNull
    private Integer rating;
    @NotNull
    private CategoryModel category;
    @NotNull
    private Integer quantity;
    @NotBlank
    private String imageURL;


}
