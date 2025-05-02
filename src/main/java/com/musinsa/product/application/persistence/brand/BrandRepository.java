package com.musinsa.product.application.persistence.brand;

import com.musinsa.product.core.domain.Brand;

public interface BrandRepository {
    Brand save(Brand brand);
    Brand findById(Long id);
}
