package com.musinsa.product.application.api;

import com.musinsa.product.comm.ResponseCode;
import com.musinsa.product.comm.ApiCommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiCommonResponse> handleRuntimeException(RuntimeException ex) {
        log.error("예상치 못한 예외 발생: {}", ex.getMessage(), ex);
        ResponseCode errorCode = ResponseCode.SERVER_ERROR;
        ApiCommonResponse errorResponse = ApiCommonResponse.of(errorCode.getCode(), errorCode.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(errorCode.getStatus()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiCommonResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("잘못된 입력: {}", ex.getMessage(), ex);
        ResponseCode errorCode = ResponseCode.INVALID_INPUT;
        ApiCommonResponse errorResponse = ApiCommonResponse.of(errorCode.getCode(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(errorCode.getStatus()));
    }
}
