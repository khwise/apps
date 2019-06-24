package com.clone.apps.global.errors;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created Date 2019.06.23
 * Created By KH.JIN
 *
 * 예외 발생 시 JSON Response Format 클래스
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ErrorResponse {

    private String code;
    private String message;
    private List<ErrorItem> errors;

    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Getter
    public static class ErrorItem {
        private String field;
        private String value;
        private String reason;
    }

    /**
     * 대부분의 예외 발생 시 응답할 Response
     * @param errorCode
     * @return
     */
    public static ErrorResponse of(ErrorCode errorCode) {
        ErrorResponse response = new ErrorResponse();
        response.code = errorCode.getCode();
        response.message = errorCode.getMessage();
        return response;
    }

    // TODO : BindingResult 에 대한 파악이 더 필요함.
    /**
     * BadRequestException 에서 사용될 예정
     * @param errorCode
     * @param bindingResult
     * @return
     */
    public static ErrorResponse of(ErrorCode errorCode, BindingResult bindingResult) {
        ErrorResponse response = ErrorResponse.of(errorCode);
        List<ErrorItem> errorItems = new ArrayList<>();
        for (FieldError error : bindingResult.getFieldErrors()) {
            ErrorItem errorItem = new ErrorItem();
            errorItem.field = error.getField();
            errorItem.value = error.getCode();
            errorItem.reason = error.getDefaultMessage();
            errorItems.add(errorItem);
        }
        response.errors = errorItems;
        return response;
    }
}
