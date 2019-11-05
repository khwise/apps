package com.clone.commons.utils;

import lombok.Getter;

/**
 * Created by kh.jin on 2019. 8. 2.
 */

public enum DelimiterUtils {

    COLON(":")
    ,
    COMMA(",")
    ;

    @Getter
    private String display;

    DelimiterUtils(String display) {
        this.display = display;
    }
}
