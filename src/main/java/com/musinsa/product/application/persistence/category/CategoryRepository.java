package com.musinsa.product.application.persistence.category;

import com.musinsa.product.core.domain.Category;

public interface CategoryRepository {
    long count();
    Category findByName(String categoryName);
    Category findById(Long categoryId);
}
