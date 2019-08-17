package com.clone.apps.web.member;

import com.clone.apps.persistence.entity.member.Member;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Created by kh.jin on 2019. 7. 2.
 */
@Data
public class MemberRegistrationRequest {

    @JsonProperty("password")
    @NotEmpty
    private String password;

    @Email
    private String email;

    @NotEmpty
    private String name;

    private String useLunarCalendar;

    private String birthday;

    private String telecomCompanyCode;

    private String mobileNumber;

    private String profileImageUrl;


    public Member convertMember() {
        Member m = new Member();
        BeanUtils.copyProperties(this, m, password);
        return m;
    }
}