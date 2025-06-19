package com.omnisell.marketplace.repository;


import com.omnisell.marketplace.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}