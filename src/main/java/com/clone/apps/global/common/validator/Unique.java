package com.clone.apps.global.common.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by kh.jin on 2019. 7. 3.
 *
 * Duplication Key 확인을 위한 Annotation 입니다.
 * executor 에 Duplication 여부를 확인하기 위한 실행 클래스 정보를 담으면 됩니다.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {

    Class<? extends UniqueValidator> executor();
}
