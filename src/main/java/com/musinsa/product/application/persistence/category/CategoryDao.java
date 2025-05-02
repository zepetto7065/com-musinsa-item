package com.musinsa.product.application.persistence.category;

import com.musinsa.product.core.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryDao implements CategoryRepository {
    private final CategoryJpaRepository categoryJpaRepository;
    @Override
    public long count() {
        return categoryJpaRepository.count();
    }

    @Override
    public Category findByName(String categoryName) {
        return categoryJpaRepository.findByName(categoryName)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다. category :: " + categoryName));
    }

    @Override
    public Category findById(Long categoryId) {
        return categoryJpaRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리 id 입니다. id :: " + categoryId));
    }
}
