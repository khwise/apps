package com.clone.apps.domain.member.signup.events;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * Created by kh.jin on 2019. 9. 12.
 */

@Getter
public class SignupEvent {

    @NotBlank
    private String email;

    public SignupEvent(@NotBlank String email) {
        this.email = email;
    }
}
