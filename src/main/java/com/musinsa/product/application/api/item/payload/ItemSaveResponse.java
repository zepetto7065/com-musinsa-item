package com.musinsa.product.application.api.item.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ItemSaveResponse {
    private Long id;
    private String name;
    private BigDecimal price;
    private String brandName;
    private String categoryName;
}
