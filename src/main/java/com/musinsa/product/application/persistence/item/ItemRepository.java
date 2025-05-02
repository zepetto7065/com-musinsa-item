package com.musinsa.product.application.persistence.item;

import com.musinsa.product.core.domain.Category;
import com.musinsa.product.core.domain.Item;
import com.musinsa.product.core.service.item.summary.MinItem;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

public interface ItemRepository {
    List<MinItem> findMinPricedProductPerCategory();

    List<Item> findAll();

    List<Item> findAllByCategory(Category category);

    Item save(Item newItem);

    Item findById(Long itemId);

    void deleteById(Long itemId);
}
