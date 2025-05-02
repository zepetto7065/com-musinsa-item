package com.musinsa.product.application.api.item.payload;

import com.musinsa.product.core.domain.Item;
import com.musinsa.product.core.service.item.summary.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemConverter {
    ItemConverter INSTANCE = Mappers.getMapper(ItemConverter.class);

    ItemMinPricePerCategorySummaryResponse map(MinItemSummary summary);

    ItemMinPricePerCategorySummaryResponse.ItemMinPricePerCategory map(MinItem item);

    SingleBrandMinSummaryResponse mapTo(SingleBrandMinItemSummary summary);

    SingleBrandMinSummaryResponse.MinPriceByCategory mapTo(SingleBrandMinItem item);

    PriceSummaryByCategoryResponse map(PriceSummary summary);

    PriceSummaryByCategoryResponse.PriceSummaryByCategoryDetail map(PriceSummaryItem item);

    @Mapping(target = "brandName", source = "brand.name")
    @Mapping(target = "categoryName", source = "category.name")
    ItemSaveResponse map(Item update);
}
