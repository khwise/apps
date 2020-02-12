package com.clone.apps.commons.code;

import lombok.Getter;

/**
 * Created by kh.jin on 2020. 1. 12.
 */
public enum DeviceCode {
    ALL(0)
    ,
    PC(1)
    ,
    MOBILE(2)
    ;

    @Getter
    private int code;
    DeviceCode(int code) {
        this.code = code;
    }
}
