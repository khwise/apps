package com.clone.apps.commons.code;

import com.clone.apps.commons.errors.BusinessException;
import lombok.Getter;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by kh.jin on 2019. 6. 26.
 */
public enum MemberStatusCode {
    ACTIVATED(1)
    ,
    INACTIVATED(2)
    ,
    BLOCKED(3)
    ,
    LOCKED(4)
    ;

    @Getter
    private int code;

    MemberStatusCode(int code) {
        this.code = code;
    }

    private static final Map<Integer, MemberStatusCode> map =
            Stream
            .of(MemberStatusCode.values())
            .collect(Collectors.toMap(MemberStatusCode::getCode, Function.identity()));

    public static MemberStatusCode from(int code) {
        return Optional.ofNullable(map.get(code)).orElseThrow(() -> new BusinessException());
    }
}