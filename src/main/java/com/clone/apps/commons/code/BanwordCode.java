package com.clone.apps.commons.code;

import lombok.Getter;

/**
 * Created by kh.jin on 2020. 2. 8.
 */
public enum BanwordCode {

    EQUALS(1)
    ,
    LIKE(2)
    ;

    @Getter
    private int code;

    BanwordCode(int code) {
        this.code = code;
    }
}
