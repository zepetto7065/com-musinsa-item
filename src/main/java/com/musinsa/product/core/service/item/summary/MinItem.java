package com.musinsa.product.core.service.item.summary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MinItem {

    private String categoryName;
    private String brandName;
    private BigDecimal price;
}
