package com.musinsa.product.application.persistence.item;

import com.musinsa.product.core.domain.Category;
import com.musinsa.product.core.domain.Item;
import com.musinsa.product.core.service.item.summary.MinItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ItemDao implements ItemRepository {

    private final ItemJpaRepository itemJpaRepository;

    @Override
    public List<MinItem> findMinPricedProductPerCategory() {
        return itemJpaRepository.findMinPricedProductPerCategory();
    }

    @Override
    public List<Item> findAll() {
        return itemJpaRepository.findAllWithBrandAndCategory();
    }

    @Override
    public List<Item> findAllByCategory(Category category) {
        return itemJpaRepository.findAllByCategory(category);
    }

    @Override
    public Item save(Item newItem) {
        return itemJpaRepository.save(newItem);
    }

    @Override
    public Item findById(Long itemId) {
        return itemJpaRepository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Item id 입니다. id ::  "+ itemId));
    }

    @Override
    public void deleteById(Long itemId) {
        itemJpaRepository.deleteById(itemId);
    }


}
