package com.musinsa.product.core.service.brand;

import com.musinsa.product.application.persistence.brand.BrandRepository;
import com.musinsa.product.core.domain.Brand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BrandServiceTest {

    private BrandRepository brandRepository;
    private BrandService brandService;

    @BeforeEach
    void setUp() {
        brandRepository = mock(BrandRepository.class);
        brandService = new BrandService(brandRepository);
    }

    @Test
    @DisplayName("새로운 브랜드 저장")
    void create_shouldSaveNewBrand() {
        // given
        String name = "무신사";
        Brand newBrand = Brand.builder().name(name).build();
        when(brandRepository.save(any(Brand.class))).thenReturn(newBrand);

        // when
        Brand result = brandService.create(name);

        // then
        assertThat(result.getName()).isEqualTo(name);
        verify(brandRepository).save(any(Brand.class));
    }

    @Test
    @DisplayName("브랜드 수정")
    void update_shouldUpdateBrandName() {
        // given
        Long brandId = 1L;
        Brand existingBrand = Brand.builder().id(brandId).name("OLD").build();
        Brand updateCommand = Brand.builder().id(brandId).name("NEW").build();

        when(brandRepository.findById(brandId)).thenReturn(existingBrand);

        // when
        Brand result = brandService.update(updateCommand);

        // then
        assertThat(result.getName()).isEqualTo("NEW");
        verify(brandRepository).findById(brandId);
    }

    @Test
    @DisplayName("soft delete , 비활성화 처리")
    void delete_shouldDeactivateBrand() {
        // given
        Long brandId = 1L;
        Brand brand = Brand.builder().id(brandId).name("무신사").build();

        when(brandRepository.findById(brandId)).thenReturn(brand);

        // when
        Brand result = brandService.delete(brandId);

        // then
        assertThat(result.isActive()).isFalse();
        verify(brandRepository).findById(brandId);
    }
}