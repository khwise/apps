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
        return new ResponseEntity<>(ErrorResponse.of(e.getCode(), e.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException e) {
        log.debug("[exception handle] Bad Request.");
        return new ResponseEntity<>(ErrorResponse.of(e.getCode(), e.getMessage(), e.getBindingResult()), HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException e) {
        log.debug("[exception handle] Bad Request.");
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(ErrorResponse.of(errorCode.getCode(), String.format(errorCode.getMessage(), e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}