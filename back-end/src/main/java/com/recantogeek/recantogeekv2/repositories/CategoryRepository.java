package com.recantogeek.recantogeekv2.repositories;

import com.recantogeek.recantogeekv2.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
}
