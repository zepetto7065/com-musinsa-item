package com.musinsa.product.core.service.item.summary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
@Builder
@AllArgsConstructor
public class SingleBrandMinItemSummary {
    String brandName;
    BigDecimal totalPrice;
    List<SingleBrandMinItem> details;
}
