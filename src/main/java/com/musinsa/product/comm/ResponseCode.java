package com.musinsa.product.comm;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS(200,"S200","성공적으로 처리하였습니다."),
    CREATED(201,"S201","성공적으로 등록되었습니다."),
    INVALID_INPUT(400,"E400","잘못된 요청입니다. 요청 값을 확인하세요"),
    SERVER_ERROR(500,"E500","예상치 못한 서버 에러, 관리자에게 문의하세요");

    private final int status;
    private final String code;
    private final String message;
}
