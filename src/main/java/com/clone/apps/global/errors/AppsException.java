package com.clone.apps.global.errors;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.validation.BindingResult;

/**
 * Created by kh.jin on 2019. 6. 22.
 * Apps 어플리케이션에서 RuntimeException.class 를 상속받는 최상위 개체입니다
 */
@EqualsAndHashCode(callSuper = false)
public class AppsException extends RuntimeException {

    @Getter
    private String code;

    @Getter
    private String message;

    public AppsException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
