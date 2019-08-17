package com.clone.apps.global.errors;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class BusinessException extends AppsException {

    public BusinessException(ErrorCode err) {
        super(err.getCode(), err.getMessage());
    }

    public BusinessException(String code, String message) {
        super(code, message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
