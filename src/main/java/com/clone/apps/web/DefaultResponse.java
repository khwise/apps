package com.clone.apps.web;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by kh.jin on 2019. 6. 23.
 */
@NoArgsConstructor
@Getter
public class DefaultResponse<T> {

    // TODO : message 추가 ()

    private final static String DEFAULT_CODE = "SUCCESS";

    private T contents;
    private String code;

    public DefaultResponse(T contents) {
        this.code = DEFAULT_CODE;
        this.contents = contents;
    }

    public static <T> DefaultResponse<T> success(T result) {
        return new DefaultResponse<>(result);
    }
}