package com.musinsa.product.application.api.brand.payload;

import com.musinsa.product.core.domain.Brand;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-02T15:06:00+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 17.0.14 (Amazon.com Inc.)"
)
public class BrandConverterImpl implements BrandConverter {

    @Override
    public BrandSaveResponse map(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = brand.getId();
        name = brand.getName();

        BrandSaveResponse brandSaveResponse = new BrandSaveResponse( id, name );

        return brandSaveResponse;
    }
}
