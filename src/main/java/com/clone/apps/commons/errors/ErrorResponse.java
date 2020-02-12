package com.clone.apps.commons.errors;

import lombok.*;
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
public class ErrorResponse {

    @Getter
    private String code;
    @Getter
    private String message;
    @Getter
    private List<ErrorItem> errors;

    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class ErrorItem {
        @Getter
        private String field;
        @Getter
        private String value;
        @Getter
        private String reason;
    }

    public static ErrorResponse of(String code) {
        return ErrorResponse.of(code, "Business Exception.");
    }

    /**
     *
     * @param code
     * @param message
     * @return
     */
    public static ErrorResponse of(String code, String message) {
        ErrorResponse response = new ErrorResponse();
        response.code = code;
        response.message = message;
        return response;
    }

    /**
     * BadRequestException 용 Response
     * @param code
     * @param bindingResult
     * @return
     */
    public static ErrorResponse of(String code, BindingResult bindingResult) {
        ErrorResponse response = ErrorResponse.of(code);
        List<ErrorItem> errorItems = new ArrayList<>();
        for (FieldError error : bindingResult.getFieldErrors()) {
            errorItems.add(
                    ErrorItem.builder()
                            .field(error.getField())
                            .value(error.getCode())
                            .reason(error.getDefaultMessage())
                            .build()
            );
        }
        response.errors = errorItems;
        return response;
    }
}
