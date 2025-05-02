package com.musinsa.product.application.api.item.payload;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
@Builder
public class PriceSummaryByCategoryResponse {
    String categoryName;
    List<PriceSummaryByCategoryDetail> minItem;
    List<PriceSummaryByCategoryDetail> maxItem;

    @Value
    @Builder
    static class PriceSummaryByCategoryDetail {
        String brandName;
        BigDecimal price;
    }
}
