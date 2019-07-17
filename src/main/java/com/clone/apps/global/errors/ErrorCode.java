package com.clone.apps.global.errors;

import lombok.Getter;

@Getter
public enum ErrorCode {

    BAD_REQUEST ("E400", "잘못된 전달 값이 있습니다.")
    ,
    NOT_FOUND ("E404", "요청하신 {0} 리소스가 없습니다.")
    ,
    DUPLICATE_DATA ("E490", "중복된 데이터가 존재합니다.")
    ,
    INTERNAL_SERVER_ERROR ("E500", "{0} 중 예기치 못한 에러가 발생하였습니다. 관리자에게 문의해주세요.")
    ;

    private final String code;
    private final String message;

    ErrorCode(final String code, final String message) {
        this.code = code;
        this.message = message;
    }
}
