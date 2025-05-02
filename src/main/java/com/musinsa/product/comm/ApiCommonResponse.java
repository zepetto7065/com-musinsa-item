package com.musinsa.product.comm;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiCommonResponse<T> {
    private String code;
    private String message;
    private T data;

    public ApiCommonResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> ApiCommonResponse<T> of(String code, String message) {
        return new ApiCommonResponse<>(code, message);
    }
    public static <T> ApiCommonResponse<T> of(String code, String message, T data) {
        return new ApiCommonResponse<>(code, message, data);
    }
}
