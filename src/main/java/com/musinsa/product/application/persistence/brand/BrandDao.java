package com.musinsa.product.application.persistence.brand;

import com.musinsa.product.core.domain.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BrandDao implements BrandRepository{
    private final BrandJpaRepository brandJpaRepository;
    @Override
    public Brand save(Brand brand) {
        return brandJpaRepository.save(brand);
    }

    @Override
    public Brand findById(Long id) {
        return brandJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 brand가 없습니다. :: " + id));
    }
}
