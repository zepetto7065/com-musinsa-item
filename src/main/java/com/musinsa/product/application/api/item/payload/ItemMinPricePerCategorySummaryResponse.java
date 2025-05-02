package com.musinsa.product.application.api.item.payload;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
@Builder
public class ItemMinPricePerCategorySummaryResponse {
    BigDecimal totalPrice;
    List<ItemMinPricePerCategory> detailList;

    @Value
    @Builder
    static class ItemMinPricePerCategory {
        String categoryName;
        String brandName;
        BigDecimal price;
    }
}
