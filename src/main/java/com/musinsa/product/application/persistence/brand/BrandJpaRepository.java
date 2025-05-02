package com.musinsa.product.application.persistence.brand;

import com.musinsa.product.core.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandJpaRepository extends JpaRepository<Brand, Long> {
}
