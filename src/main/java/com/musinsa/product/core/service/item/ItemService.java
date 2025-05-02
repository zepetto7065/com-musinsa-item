package com.musinsa.product.core.service.item;

import com.musinsa.product.application.persistence.brand.BrandRepository;
import com.musinsa.product.application.persistence.category.CategoryRepository;
import com.musinsa.product.application.persistence.item.ItemRepository;
import com.musinsa.product.core.domain.Brand;
import com.musinsa.product.core.domain.Category;
import com.musinsa.product.core.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    @Transactional
    public Item create(ItemVo command) {
        Brand brand = brandRepository.findById(command.getBrandId());
        Category category = categoryRepository.findById(command.getCategoryId());

        Item newItem = Item.builder()
                .name(command.getName())
                .price(command.getPrice())
                .brand(brand)
                .category(category)
                .build();

        return itemRepository.save(newItem);
    }

    @Transactional
    public Item update(ItemVo command){
        if(command.getItemId() == null){
            throw new IllegalArgumentException("item id is null");
        }
        Item item = itemRepository.findById(command.getItemId());

        Brand brand = null;
        if(item.getBrand() != null){
            brand = brandRepository.findById(command.getBrandId());
        }

        Category category = null;
        if(item.getCategory() != null){
            category = categoryRepository.findById(command.getCategoryId());
        }

        return item.adjust(command, brand, category);
    }

    @Transactional
    public Item delete(Long itemId) {
        Item byId = itemRepository.findById(itemId);
        return byId.deactive();
    }
}
