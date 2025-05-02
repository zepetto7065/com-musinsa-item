package com.musinsa.product.core.service.item.summary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
@AllArgsConstructor
public class SingleBrandMinItem {
    String categoryName;
    BigDecimal minPrice;
}
