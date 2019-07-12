package com.clone.apps.global.errors;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.validation.BindingResult;

/**
 * Created by kh.jin on 2019. 6. 22.
 * Controller 에서 전달 받은 파라메터에 대해서 @Valid 를 이용하여 검증 후
 * 유효하지 않는 값이 있을 때 발생시키는 예외이다
 */
@EqualsAndHashCode(callSuper = false)
public class BadRequestException extends BusinessException {

    @Getter
    private BindingResult bindingResult;

    public BadRequestException(BindingResult bindingResult) {
        super(ErrorCode.BAD_REQUEST.getCode(), ErrorCode.BAD_REQUEST.getMessage());
        this.bindingResult = bindingResult;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
