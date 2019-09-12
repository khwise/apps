package com.clone.apps.global.errors;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

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
