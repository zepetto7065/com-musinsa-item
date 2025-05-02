package com.musinsa.product.application.api.item.payload;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
@Builder
public class SingleBrandMinSummaryResponse {
    String brandName;
    BigDecimal totalPrice;
    List<MinPriceByCategory> details;

    @Value
    @Builder
    static class MinPriceByCategory {
        String categoryName;
        BigDecimal minPrice;
    }
}
