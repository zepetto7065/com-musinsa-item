package com.musinsa.product.application.api.brand.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BrandSaveResponse {
    private Long id;
    private String name;
}
