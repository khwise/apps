package com.clone.apps.commons.errors;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by kh.jin on 2020. 1. 19.
 * 서비스 간 전달되는 인자 값이 유효하지 않을 경우에 대한 예외처리
 */
@EqualsAndHashCode(callSuper = false)
@ToString
public class InvalidAgrsException extends AppsException {
}
