package com.musinsa.product.core.service.brand;

import com.musinsa.product.application.persistence.brand.BrandRepository;
import com.musinsa.product.core.domain.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
    @Transactional
    public Brand create(String command) {
        Brand newBrand = Brand.builder()
                .name(command)
                .build();
        return brandRepository.save(newBrand);
    }

    @Transactional
    public Brand update(Brand command){
        Brand brand = brandRepository.findById(command.getId());
        brand.setName(command.getName());
        return brand;
    }

    @Transactional
    public Brand delete(Long id) {
        Brand brand = brandRepository.findById(id);
        return brand.deactive();
    }
}
