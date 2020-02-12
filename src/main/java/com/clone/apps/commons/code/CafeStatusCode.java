package com.clone.apps.commons.code;

import lombok.Getter;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by kh.jin on 2020. 1. 11.
 */
public enum CafeStatusCode {
    PENDING(0)
    ,
    OPEN(1)
    ,
    CLOSED(2)
    ;

    @Getter
    private int code;

    CafeStatusCode(int code) {
        this.code = code;
    }

    private static final Map<Integer, CafeStatusCode> map =
            Stream
            .of(CafeStatusCode.values())
            .collect(Collectors.toMap(CafeStatusCode::getCode, Function.identity()))
            ;

    public static CafeStatusCode from(int code) {
        return map.get(code);
    }
}