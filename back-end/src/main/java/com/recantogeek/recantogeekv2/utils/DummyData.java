package com.recantogeek.recantogeekv2.utils;

import com.recantogeek.recantogeekv2.enums.RatingEnum;
import com.recantogeek.recantogeekv2.models.CategoryModel;
import com.recantogeek.recantogeekv2.models.ProductModel;
import com.recantogeek.recantogeekv2.repositories.CategoryRepository;
import com.recantogeek.recantogeekv2.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class DummyData {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @PostConstruct
    public void dummyData(){

        CategoryModel c1 = new CategoryModel(null, "Vestuario");
        CategoryModel c2 = new CategoryModel(null, "Decoração");
        CategoryModel c3 = new CategoryModel(null, "Funkos");
        CategoryModel c4 = new CategoryModel(null, "Livros");

        categoryRepository.saveAll(Arrays.asList(c1,c2,c3,c4));

        ProductModel p1 = new ProductModel(null, "Percy Jackson e os Olimpianos",36.43,"Nunquam fallere canis.", RatingEnum.FIVE,10,c4);
        ProductModel p2 = new ProductModel(null, "Moleton - Dragon Ball",28.43,"Where is the cold cannibal?", RatingEnum.FOUR,20,c1);
        ProductModel p3 = new ProductModel(null, "Funko - Madara",136.43,"Corsairs laugh with malaria!", RatingEnum.THREE,5,c3);
        ProductModel p4 = new ProductModel(null, "Almofada",16.43,"Nunquam fallere canis.Golly gosh, yer not burning me without a passion!", RatingEnum.TWO,10,c2);
        ProductModel p5 = new ProductModel(null, "Percy Jackson e os Olimpianos",36.43,"Nunquam fallere canis.", RatingEnum.FIVE,10,c4);
        ProductModel p6 = new ProductModel(null, "Moleton - Dragon Ball",28.43,"Where is the cold cannibal?", RatingEnum.FOUR,20,c1);
        ProductModel p7 = new ProductModel(null, "Funko - Madara",136.43,"Corsairs laugh with malaria!", RatingEnum.THREE,5,c3);
        ProductModel p8 = new ProductModel(null, "Almofada",16.43,"Nunquam fallere canis.Golly gosh, yer not burning me without a passion!", RatingEnum.TWO,10,c2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8));
    }

}
