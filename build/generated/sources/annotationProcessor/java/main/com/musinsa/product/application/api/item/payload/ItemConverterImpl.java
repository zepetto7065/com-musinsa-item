package com.musinsa.product.application.api.item.payload;

import com.musinsa.product.core.domain.Brand;
import com.musinsa.product.core.domain.Category;
import com.musinsa.product.core.domain.Item;
import com.musinsa.product.core.service.item.summary.MinItem;
import com.musinsa.product.core.service.item.summary.MinItemSummary;
import com.musinsa.product.core.service.item.summary.PriceSummary;
import com.musinsa.product.core.service.item.summary.PriceSummaryItem;
import com.musinsa.product.core.service.item.summary.SingleBrandMinItem;
import com.musinsa.product.core.service.item.summary.SingleBrandMinItemSummary;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-02T15:06:00+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 17.0.14 (Amazon.com Inc.)"
)
public class ItemConverterImpl implements ItemConverter {

    @Override
    public ItemMinPricePerCategorySummaryResponse map(MinItemSummary summary) {
        if ( summary == null ) {
            return null;
        }

        ItemMinPricePerCategorySummaryResponse.ItemMinPricePerCategorySummaryResponseBuilder itemMinPricePerCategorySummaryResponse = ItemMinPricePerCategorySummaryResponse.builder();

        itemMinPricePerCategorySummaryResponse.totalPrice( summary.getTotalPrice() );
        itemMinPricePerCategorySummaryResponse.detailList( minItemListToItemMinPricePerCategoryList( summary.getDetailList() ) );

        return itemMinPricePerCategorySummaryResponse.build();
    }

    @Override
    public ItemMinPricePerCategorySummaryResponse.ItemMinPricePerCategory map(MinItem item) {
        if ( item == null ) {
            return null;
        }

        ItemMinPricePerCategorySummaryResponse.ItemMinPricePerCategory.ItemMinPricePerCategoryBuilder itemMinPricePerCategory = ItemMinPricePerCategorySummaryResponse.ItemMinPricePerCategory.builder();

        itemMinPricePerCategory.categoryName( item.getCategoryName() );
        itemMinPricePerCategory.brandName( item.getBrandName() );
        itemMinPricePerCategory.price( item.getPrice() );

        return itemMinPricePerCategory.build();
    }

    @Override
    public SingleBrandMinSummaryResponse mapTo(SingleBrandMinItemSummary summary) {
        if ( summary == null ) {
            return null;
        }

        SingleBrandMinSummaryResponse.SingleBrandMinSummaryResponseBuilder singleBrandMinSummaryResponse = SingleBrandMinSummaryResponse.builder();

        singleBrandMinSummaryResponse.brandName( summary.getBrandName() );
        singleBrandMinSummaryResponse.totalPrice( summary.getTotalPrice() );
        singleBrandMinSummaryResponse.details( singleBrandMinItemListToMinPriceByCategoryList( summary.getDetails() ) );

        return singleBrandMinSummaryResponse.build();
    }

    @Override
    public SingleBrandMinSummaryResponse.MinPriceByCategory mapTo(SingleBrandMinItem item) {
        if ( item == null ) {
            return null;
        }

        SingleBrandMinSummaryResponse.MinPriceByCategory.MinPriceByCategoryBuilder minPriceByCategory = SingleBrandMinSummaryResponse.MinPriceByCategory.builder();

        minPriceByCategory.categoryName( item.getCategoryName() );
        minPriceByCategory.minPrice( item.getMinPrice() );

        return minPriceByCategory.build();
    }

    @Override
    public PriceSummaryByCategoryResponse map(PriceSummary summary) {
        if ( summary == null ) {
            return null;
        }

        PriceSummaryByCategoryResponse.PriceSummaryByCategoryResponseBuilder priceSummaryByCategoryResponse = PriceSummaryByCategoryResponse.builder();

        priceSummaryByCategoryResponse.categoryName( summary.getCategoryName() );
        priceSummaryByCategoryResponse.minItem( priceSummaryItemListToPriceSummaryByCategoryDetailList( summary.getMinItem() ) );
        priceSummaryByCategoryResponse.maxItem( priceSummaryItemListToPriceSummaryByCategoryDetailList( summary.getMaxItem() ) );

        return priceSummaryByCategoryResponse.build();
    }

    @Override
    public PriceSummaryByCategoryResponse.PriceSummaryByCategoryDetail map(PriceSummaryItem item) {
        if ( item == null ) {
            return null;
        }

        PriceSummaryByCategoryResponse.PriceSummaryByCategoryDetail.PriceSummaryByCategoryDetailBuilder priceSummaryByCategoryDetail = PriceSummaryByCategoryResponse.PriceSummaryByCategoryDetail.builder();

        priceSummaryByCategoryDetail.brandName( item.getBrandName() );
        priceSummaryByCategoryDetail.price( item.getPrice() );

        return priceSummaryByCategoryDetail.build();
    }

    @Override
    public ItemSaveResponse map(Item update) {
        if ( update == null ) {
            return null;
        }

        String brandName = null;
        String categoryName = null;
        Long id = null;
        String name = null;
        BigDecimal price = null;

        brandName = updateBrandName( update );
        categoryName = updateCategoryName( update );
        id = update.getId();
        name = update.getName();
        price = update.getPrice();

        ItemSaveResponse itemSaveResponse = new ItemSaveResponse( id, name, price, brandName, categoryName );

        return itemSaveResponse;
    }

    protected List<ItemMinPricePerCategorySummaryResponse.ItemMinPricePerCategory> minItemListToItemMinPricePerCategoryList(List<MinItem> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemMinPricePerCategorySummaryResponse.ItemMinPricePerCategory> list1 = new ArrayList<ItemMinPricePerCategorySummaryResponse.ItemMinPricePerCategory>( list.size() );
        for ( MinItem minItem : list ) {
            list1.add( map( minItem ) );
        }

        return list1;
    }

    protected List<SingleBrandMinSummaryResponse.MinPriceByCategory> singleBrandMinItemListToMinPriceByCategoryList(List<SingleBrandMinItem> list) {
        if ( list == null ) {
            return null;
        }

        List<SingleBrandMinSummaryResponse.MinPriceByCategory> list1 = new ArrayList<SingleBrandMinSummaryResponse.MinPriceByCategory>( list.size() );
        for ( SingleBrandMinItem singleBrandMinItem : list ) {
            list1.add( mapTo( singleBrandMinItem ) );
        }

        return list1;
    }

    protected List<PriceSummaryByCategoryResponse.PriceSummaryByCategoryDetail> priceSummaryItemListToPriceSummaryByCategoryDetailList(List<PriceSummaryItem> list) {
        if ( list == null ) {
            return null;
        }

        List<PriceSummaryByCategoryResponse.PriceSummaryByCategoryDetail> list1 = new ArrayList<PriceSummaryByCategoryResponse.PriceSummaryByCategoryDetail>( list.size() );
        for ( PriceSummaryItem priceSummaryItem : list ) {
            list1.add( map( priceSummaryItem ) );
        }

        return list1;
    }

    private String updateBrandName(Item item) {
        if ( item == null ) {
            return null;
        }
        Brand brand = item.getBrand();
        if ( brand == null ) {
            return null;
        }
        String name = brand.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String updateCategoryName(Item item) {
        if ( item == null ) {
            return null;
        }
        Category category = item.getCategory();
        if ( category == null ) {
            return null;
        }
        String name = category.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
