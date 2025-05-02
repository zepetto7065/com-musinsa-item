package com.musinsa.product.core.service;

import com.musinsa.product.application.persistence.category.CategoryRepository;
import com.musinsa.product.application.persistence.item.ItemRepository;
import com.musinsa.product.core.domain.Brand;
import com.musinsa.product.core.domain.Category;
import com.musinsa.product.core.domain.Item;
import com.musinsa.product.core.service.item.ItemSummaryService;
import com.musinsa.product.core.service.item.summary.MinItem;
import com.musinsa.product.core.service.item.summary.MinItemSummary;
import com.musinsa.product.core.service.item.summary.PriceSummary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ItemSummaryServiceTest {
    @InjectMocks
    private ItemSummaryService itemSummaryService;
    @Mock
    private ItemRepository itemRepository;
    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void summation_test(){
        //Given
        MinItem item1 = MinItem.builder()
                .price(BigDecimal.valueOf(2000L))
                .categoryName("상의")
                .brandName("A")
                .build();
        MinItem item2 = MinItem.builder()
                .price(BigDecimal.valueOf(10000L))
                .categoryName("하의")
                .brandName("C")
                .build();
        List<MinItem> minItemList = new ArrayList<>(Arrays.asList(item1, item2));
        when(itemRepository.findMinPricedProductPerCategory()).thenReturn(minItemList);

        //When
        MinItemSummary minPricePerCategory = itemSummaryService.getMinPricePerCategory();

        //Then
        assertEquals(minPricePerCategory.getTotalPrice(), BigDecimal.valueOf(12000L));
        assertEquals(minPricePerCategory.getDetailList().size(), 2);
    }

    @Test
    @DisplayName("모든 카테고리를 보유한 브랜드가 없을 경우")
    void getSingleBrandMinSummary_WhenNoBrandHasAllCategories_ShouldThrowException() {
        when(categoryRepository.count()).thenReturn(8L);

        when(itemRepository.findAll()).thenReturn(Collections.emptyList());

        assertThrows(RuntimeException.class, () -> {
            itemSummaryService.getSingleBrandMinSummary();
        });
    }

    @Test
    @DisplayName(" 최저가와 최고가가 올바르게 반환되는지 확인")
    void getPriceSummary_ShouldReturnCorrectSummary_WhenValidCategory() {
        // given: 존재하는 카테고리와 아이템을 가정
        Category category = new Category(1L, "상의", null);
        Brand brandA = new Brand(1L, "A", true, null);
        Brand brandB = new Brand(2L, "B", true, null);

        Item cheapItem = new Item(1L,"티셔츠", new BigDecimal("10000"), true,  category, brandA);
        Item expensiveItem = new Item(2L, "자켓", new BigDecimal("20000"), true, category, brandB);

        when(categoryRepository.findByName("상의")).thenReturn(category);
        when(itemRepository.findAllByCategory(category)).thenReturn(List.of(cheapItem, expensiveItem));

        // when
        PriceSummary result = itemSummaryService.getPriceSummary("상의");

        // then
        assertEquals("상의", result.getCategoryName());
        assertEquals(1, result.getMinItem().size());
        assertEquals("A", result.getMinItem().get(0).getBrandName());
        assertEquals(new BigDecimal("10000"), result.getMinItem().get(0).getPrice());

        assertEquals(1, result.getMaxItem().size());
        assertEquals("B", result.getMaxItem().get(0).getBrandName());
        assertEquals(new BigDecimal("20000"), result.getMaxItem().get(0).getPrice());
    }

    @Test
    @DisplayName("존재하지 않는 카테고리")
    void getPriceSummary_ShouldThrowException_WhenCategoryNotFound() {
        // given
        when(categoryRepository.findByName("하의")).thenThrow(new IllegalArgumentException("해당하는 카테고리를 찾을 수 없습니다: 하의"));

        // when & then
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> itemSummaryService.getPriceSummary("하의"));
        assertTrue(thrown.getMessage().contains("해당하는 카테고리를 찾을 수 없습니다"));
    }
}