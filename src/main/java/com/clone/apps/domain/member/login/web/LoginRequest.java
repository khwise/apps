package com.clone.apps.domain.member.login.web;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Created by kh.jin on 2019. 9. 8.
 */

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRequest {
    
    @Email
    private String email;

    @NotBlank
    private String password;

}