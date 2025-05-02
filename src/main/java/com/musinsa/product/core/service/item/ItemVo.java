package com.musinsa.product.core.service.item;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class ItemVo {
    Long itemId;
    String name;
    BigDecimal price;
    Long brandId;
    Long categoryId;
}
