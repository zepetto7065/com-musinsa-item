package com.musinsa.product.application.api.item.payload;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaveItemRequest {
    private Long itemId;

    @NotBlank(message = "상품 이름은 비어 있을 수 없습니다.")
    @Size(min = 2, max = 100, message = "상품 이름은 2자 이상 100자 이하로 입력해야 합니다.")
    private String name;

    @NotNull(message = "가격은 필수 입력 값입니다.")
    @DecimalMin(value = "1", message = "가격은 1원 이상이어야 합니다.")
    private BigDecimal price;

    @NotNull(message = "브랜드 ID는 필수입니다.")
    private Long brandId;

    @NotNull(message = "카테고리 ID는 필수입니다.")
    private Long categoryId;
}
