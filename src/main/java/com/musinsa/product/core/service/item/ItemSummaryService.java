package com.musinsa.product.core.service.item;

import com.musinsa.product.application.persistence.category.CategoryRepository;
import com.musinsa.product.application.persistence.item.ItemRepository;
import com.musinsa.product.core.domain.Brand;
import com.musinsa.product.core.domain.Category;
import com.musinsa.product.core.domain.Item;
import com.musinsa.product.core.service.item.summary.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemSummaryService {
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public MinItemSummary getMinPricePerCategory() {
        List<MinItem> minPricedItemsPerCategory = itemRepository.findMinPricedProductPerCategory();

        BigDecimal totalPrice = minPricedItemsPerCategory.stream()
                .map(MinItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return MinItemSummary.builder()
                .totalPrice(totalPrice)
                .detailList(minPricedItemsPerCategory)
                .build();
    }

    @Transactional(readOnly = true)
    public SingleBrandMinItemSummary getSingleBrandMinSummary() {
        //모든 Item, (실제 규모에 따라 제한 혹은 별도로 분리)
        List<Item> allItems = itemRepository.findAll();
        final long totalCategoryCount = categoryRepository.count();

        //브랜드별로 그룹화
        Map<Brand, List<Item>> itemsByBrand = allItems.stream()
                .collect(Collectors.groupingBy(Item::getBrand));

        List<BrandMinSummary> brandMinItemSummaries = new ArrayList<>();

        for (Map.Entry<Brand, List<Item>> entry : itemsByBrand.entrySet()) {
            Brand brand = entry.getKey();
            List<Item> brandItems = entry.getValue();

            Map<Category, Item> itemByCategory = brandItems.stream()
                    .collect(Collectors.toMap(
                            Item::getCategory,
                            Function.identity(),
                            (item1, item2) -> item1.getPrice().compareTo(item2.getPrice()) <= 0 ? item1 : item2
                    ));

            //모든 카테고리를 보유했는지 check
            if(itemByCategory.size() == totalCategoryCount){
                BigDecimal totalPrice = itemByCategory.values().stream()
                        .map(Item::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                brandMinItemSummaries.add(new BrandMinSummary(brand, itemByCategory, totalPrice));
            }
        }

        if(brandMinItemSummaries.isEmpty()) {
            throw new RuntimeException("모든 카테고리를 보유한 브랜드가 없습니다.");
        }

        //총 합계가 최소인 브랜드 선택
        BrandMinSummary minSummary = brandMinItemSummaries.stream()
                .min(Comparator.comparing(BrandMinSummary::getTotalPrice))
                .orElseThrow(() -> new RuntimeException("최소 합계를 가진 브랜드가 없습니다"));

        //각 카테고리의 상세 정보 변환
        List<SingleBrandMinItem> details = minSummary.getItemByCategory().entrySet().stream()
                .map(e -> new SingleBrandMinItem(e.getKey().getName(), e.getValue().getPrice()))
                .toList();

        return new SingleBrandMinItemSummary(minSummary.getBrand().getName(), minSummary.getTotalPrice(), details);
    }

    @Transactional(readOnly = true)
    public PriceSummary getPriceSummary(final String categoryName) {
        Category category = categoryRepository.findByName(categoryName);

        List<Item> items = itemRepository.findAllByCategory(category);

        if(items.isEmpty()) throw new IllegalArgumentException("해당하는 카테고리 아이템이 없습니다. cateogory :: " + categoryName);

        Item minItem = items.stream().min(Comparator.comparing(Item::getPrice))
                .orElseThrow(() -> new RuntimeException("최저가 상품을 찾을 수 없습니다"));

        Item maxItem = items.stream().max(Comparator.comparing(Item::getPrice))
                .orElseThrow(() -> new RuntimeException("최고가 상품을 찾을 수 없습니다"));

        return new PriceSummary(
                categoryName,
                List.of(new PriceSummaryItem(minItem.getBrand().getName(), minItem.getPrice())),
                List.of(new PriceSummaryItem(maxItem.getBrand().getName(), maxItem.getPrice()))
        );
    }
}
