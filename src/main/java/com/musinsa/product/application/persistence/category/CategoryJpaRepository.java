package com.musinsa.product.application.persistence.category;

import com.musinsa.product.core.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryJpaRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String categoryName);
}
