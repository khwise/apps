package com.clone.apps.global.errors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
        log.debug("[exception handle] Business Exception.");
        return new ResponseEntity<>(ErrorResponse.of(e.getCode().name(), e.getCode().name()), HttpStatus.OK);
    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException e) {
        log.debug("[exception handle] Bad Request.");
        return new ResponseEntity<>(ErrorResponse.of(e.getCode().code, e.getBindingResult()), HttpStatus.OK);
    }

    @ExceptionHandler(AppsException.class)
    protected ResponseEntity<ErrorResponse> handleRuntimeException(AppsException e) {
        log.debug("[exception handle] Apps Exception.");
        return new ResponseEntity<>(ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR.code, e.getMessage()), HttpStatus.OK);
    }
}