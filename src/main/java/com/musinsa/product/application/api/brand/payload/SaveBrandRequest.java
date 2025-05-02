package com.musinsa.product.application.api.brand.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaveBrandRequest {
    @NotBlank
    @Size(min = 1, max = 50, message = "브랜드 이름은 1자 이상 50자 이하로 입력해야 합니다.")
    private String name;
}
