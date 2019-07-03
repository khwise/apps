package com.clone.apps.global.models.response;

import lombok.Getter;

/**
 * Created by kh.jin on 2019. 6. 23.
 */
@Getter
public enum SuccessCode {

    CREATED("SC01", "생성 성공")
    ,
    UPDATED("SU01", "변경 성공")
    ,
    DELETED("SD01", "삭제 성공")
    ,
    FIND("SF01", "조회 성공")
    ,
    FIND_LIST("SF02", "목록 조획 성공")

    ;

    private final String code;
    private final String message;

    SuccessCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
