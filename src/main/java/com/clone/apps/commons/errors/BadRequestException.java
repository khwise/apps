package com.clone.apps.commons.errors;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.validation.BindingResult;

/**
 * Created by kh.jin on 2019. 6. 22.
 * Request 정보에서 유효하지 않는 값에 대한 예외처리
 */
@EqualsAndHashCode(callSuper = false)
@ToString
public class BadRequestException extends BusinessException {

    @Getter
    private BindingResult bindingResult;

    public BadRequestException(BindingResult bindingResult) {
        super(ErrorCode.BAD_REQUEST);
        this.bindingResult = bindingResult;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
