package com.clone.apps.commons.errors;

/**
 * Business Exception 대응 Error Code
 */
public enum ErrorCode {
    // TODO : NO_DATA, 유효하지 않은 데이터 등

    BAD_REQUEST ("E400")
    ,
    NOT_FOUND ("E404")
    ,
    DUPLICATE_DATA ("E491")
    ,
    INTERNAL_SERVER_ERROR ("E500")
    ;

    public String code;

    ErrorCode(final String code) {
        this.code = code;
    }
}
