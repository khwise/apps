package com.clone.apps.commons.errors;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by kh.jin on 2019. 9. 11.
 * Login 관련 Exception.
 */
@EqualsAndHashCode(callSuper = false)
@ToString
public class LoginException extends AppsException {

    private final static String DEFAULT_MESSAGE = "Failed Login.";

    public LoginException() {
        super(DEFAULT_MESSAGE);
    }

    public LoginException(String message) {
        super(message);
    }
}
