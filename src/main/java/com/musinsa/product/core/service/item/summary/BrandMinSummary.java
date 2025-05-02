package com.musinsa.product.core.service.item.summary;

import com.musinsa.product.core.domain.Brand;
import com.musinsa.product.core.domain.Category;
import com.musinsa.product.core.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Map;

@Value
@Builder
@AllArgsConstructor
public class BrandMinSummary {
    Brand brand;
    Map<Category, Item> itemByCategory;
    BigDecimal totalPrice;
}
