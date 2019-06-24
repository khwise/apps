package com.clone.apps.global.response;

import lombok.Data;

/**
 * Created by kh.jin on 2019. 6. 23.
 */

@Data
public class DefaultResponse<T> {

    private T result;
    private String code;
    private String message;

    public DefaultResponse(SuccessCode successCode, T result) {
        this.code = successCode.getCode();
        this.message = successCode.getMessage();
        this.result = result;
    }

    public static <T> DefaultResponse<T> success(SuccessCode successCode, T result) {
        return new DefaultResponse<>(successCode, result);
    }
}
