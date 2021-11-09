package com.recantogeek.recantogeekv2.repositories;

import com.recantogeek.recantogeekv2.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel,Long> {
}
