package com.musinsa.product.core.service.item;

import com.musinsa.product.application.persistence.brand.BrandRepository;
import com.musinsa.product.application.persistence.category.CategoryRepository;
import com.musinsa.product.application.persistence.item.ItemRepository;
import com.musinsa.product.core.domain.Brand;
import com.musinsa.product.core.domain.Category;
import com.musinsa.product.core.domain.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemServiceTest {

    private ItemRepository itemRepository;
    private BrandRepository brandRepository;
    private CategoryRepository categoryRepository;
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        itemRepository = mock(ItemRepository.class);
        brandRepository = mock(BrandRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        itemService = new ItemService(itemRepository, brandRepository, categoryRepository);
    }

    @Test
    void create_shouldSaveItemWithBrandAndCategory() {
        // given
        Long brandId = 1L;
        Long categoryId = 2L;
        Brand brand = Brand.builder().id(brandId).name("브랜드").build();
        Category category = Category.builder().id(categoryId).name("카테고리").build();
        ItemVo command = ItemVo.builder()
                .name("아이템명")
                .price(BigDecimal.valueOf(1000L))
                .brandId(brandId)
                .categoryId(categoryId)
                .build();

        Item savedItem = Item.builder()
                .name("아이템명")
                .price(BigDecimal.valueOf(1000L))
                .brand(brand)
                .category(category)
                .build();

        when(brandRepository.findById(brandId)).thenReturn(brand);
        when(categoryRepository.findById(categoryId)).thenReturn(category);
        when(itemRepository.save(any(Item.class))).thenReturn(savedItem);

        // when
        Item result = itemService.create(command);

        // then
        assertThat(result.getName()).isEqualTo("아이템명");
        assertThat(result.getBrand()).isEqualTo(brand);
        assertThat(result.getCategory()).isEqualTo(category);
        verify(itemRepository).save(any(Item.class));
    }

    @Test
    void update_shouldAdjustItem() {
        // given
        Long itemId = 10L;
        Long brandId = 1L;
        Long categoryId = 2L;
        Item item = mock(Item.class);
        Brand brand = Brand.builder().id(brandId).name("브랜드").build();
        Category category = Category.builder().id(categoryId).name("카테고리").build();

        ItemVo command = ItemVo.builder()
                .itemId(itemId)
                .name("변경이름")
                .price(BigDecimal.valueOf(1000L))
                .brandId(brandId)
                .categoryId(categoryId)
                .build();

        when(itemRepository.findById(itemId)).thenReturn(item);
        when(item.getBrand()).thenReturn(brand); // 기존 브랜드 존재
        when(item.getCategory()).thenReturn(category); // 기존 카테고리 존재
        when(brandRepository.findById(brandId)).thenReturn(brand);
        when(categoryRepository.findById(categoryId)).thenReturn(category);
        when(item.adjust(command, brand, category)).thenReturn(item);

        // when
        Item result = itemService.update(command);

        // then
        assertThat(result).isEqualTo(item);
        verify(item).adjust(command, brand, category);
    }

    @Test
    void delete_shouldDeactivateItem() {
        // given
        Long itemId = 5L;
        Item item = mock(Item.class);
        when(itemRepository.findById(itemId)).thenReturn(item);
        when(item.deactive()).thenReturn(item);

        // when
        Item result = itemService.delete(itemId);

        // then
        assertThat(result).isEqualTo(item);
        assertThat(result.isActive()).isFalse();
        verify(itemRepository).findById(itemId);
        verify(item).deactive();
    }
}