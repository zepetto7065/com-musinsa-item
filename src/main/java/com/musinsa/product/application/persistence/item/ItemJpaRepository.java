package com.musinsa.product.application.persistence.item;

import com.musinsa.product.core.domain.Category;
import com.musinsa.product.core.domain.Item;
import com.musinsa.product.core.service.item.summary.MinItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//N+1 해결을 위한 fetch 조인 적용
public interface ItemJpaRepository extends JpaRepository<Item, Long> {
    @Query("SELECT new com.musinsa.product.core.service.item.summary.MinItem(i.category.name, i.brand.name, i.price) " +
            "FROM Item i " +
            "WHERE i.price = (SELECT MIN(i2.price) FROM Item i2 WHERE i2.category = i.category) " +
            "AND i.id = (SELECT MAX(i3.id) FROM Item i3 WHERE i3.category = i.category AND i3.price = i.price)" +
            "ORDER BY i.category.id ASC")
    List<MinItem> findMinPricedProductPerCategory();

    @Query("select i from Item i join fetch i.brand where i.category = :category")
    List<Item> findAllByCategory(Category category);

    @Query("select distinct i from Item i join fetch i.brand join fetch i.category")
    List<Item> findAllWithBrandAndCategory();
}
