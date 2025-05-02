package com.musinsa.product.application.api.brand.payload;

import com.musinsa.product.core.domain.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandConverter {
    BrandConverter INSTANCE = Mappers.getMapper(BrandConverter.class);
    BrandSaveResponse map(Brand brand);
}
