package com.clone.apps.commons.code;

import lombok.Getter;

/**
 * Created by kh.jin on 2020. 1. 11.
 */
public enum DisplayCode {
    ON(1)
    ,
    OFF(2)
    ;

    @Getter
    private int code;

    DisplayCode(int code) {
       this.code = code;
    }
}