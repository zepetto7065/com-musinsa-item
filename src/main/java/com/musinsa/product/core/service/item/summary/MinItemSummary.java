package com.musinsa.product.core.service.item.summary;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Value
@Builder
public class MinItemSummary {
    BigDecimal totalPrice;
    List<MinItem> detailList;
}
