package com.musinsa.product.core.domain;

import com.musinsa.product.core.service.item.ItemVo;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends BaseTimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;

    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Item deactive() {
        this.active = false;
        return this;
    }

    public Item adjust(ItemVo command, Brand brand, Category category) {
        this.name = command.getName();
        this.price = command.getPrice();
        this.brand = brand;
        this.category = category;
        return this;
    }
}
