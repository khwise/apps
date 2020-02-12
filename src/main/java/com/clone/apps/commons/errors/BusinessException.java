package com.clone.apps.commons.errors;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by kh.jin on 2020. 1. 19.
 * Business 흐름에서 발생하는 예외에 대한 처리를 담당한다.
 */

@EqualsAndHashCode(callSuper = false)
@ToString
public class BusinessException extends AppsException {

    @Getter
    private ErrorCode code;

    public BusinessException() {
        super();
    }

    public BusinessException(ErrorCode code) {
        super();
        this.code = code;
    }

    public BusinessException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
