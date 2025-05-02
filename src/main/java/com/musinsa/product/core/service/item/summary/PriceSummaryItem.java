package com.musinsa.product.core.service.item.summary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
@AllArgsConstructor
public class PriceSummaryItem {
    String brandName;
    BigDecimal price;
}
