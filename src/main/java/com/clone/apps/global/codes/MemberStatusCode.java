package com.clone.apps.global.codes;

import lombok.Getter;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by kh.jin on 2019. 6. 26.
 */

@Getter
public enum MemberStatusCode {

    ACTIVATED(1)
    ,
    INACTIVATED(2)
    ,
    BLOCKED(3)
    ,
    LOCKED(4)
    ;

    private int code;

    MemberStatusCode(int code) {
        this.code = code;
    }

    private static final Map<Integer, MemberStatusCode> map
            = Stream.of(MemberStatusCode.values()).collect(Collectors.toMap(MemberStatusCode::getCode, Function.identity()));

    public static MemberStatusCode from(int code) {
        return map.get(code);
    }
}