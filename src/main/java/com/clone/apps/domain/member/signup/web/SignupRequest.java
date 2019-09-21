package com.clone.apps.domain.member.signup.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Created by kh.jin on 2019. 9. 11.
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode(callSuper = false)
public class SignupRequest {

    @JsonProperty("email")
    @Email
    private String email;

    @JsonProperty("name")
    @NotEmpty
    private String name;

    @JsonProperty("use_lunar_calendar")
    private String useLunarCalendar;

    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("telecom_company_code")
    private String telecomCompanyCode;

    @JsonProperty("mobile_number")
    private String mobileNumber;

    @JsonProperty("profile_image_url")
    private String profileImageUrl;

    @JsonProperty("password")
    @NotEmpty
    private String password;
}
