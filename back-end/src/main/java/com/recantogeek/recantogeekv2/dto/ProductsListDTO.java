package com.recantogeek.recantogeekv2.dto;


import lombok.Data;

@Data
public class ProductsListDTO {

    private Long id;
    private String name;
    private Double price;
    private Integer rating;

}
