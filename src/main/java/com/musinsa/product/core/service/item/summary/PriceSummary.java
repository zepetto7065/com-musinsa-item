package com.musinsa.product.core.service.item.summary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor
public class PriceSummary {
    String categoryName;
    List<PriceSummaryItem> minItem;
    List<PriceSummaryItem> maxItem;
}
