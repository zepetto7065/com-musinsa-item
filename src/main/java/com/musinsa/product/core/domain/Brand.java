package com.musinsa.product.core.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Brand extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    private boolean active;

    @OneToMany(mappedBy = "brand")
    private List<Item> items = new ArrayList<>();

    public Brand deactive() {
        active = false;
        return this;
    }
}
