package com.clone.apps.global.errors;

import lombok.Getter;

@Getter
public enum ErrorCode {

    BAD_REQUEST ("E400", "잘못된 전달 값이 있습니다.")

    ;

    private final String code;
    private final String message;

    ErrorCode(final String code, final String message) {
        this.code = code;
        this.message = message;
    }
}
