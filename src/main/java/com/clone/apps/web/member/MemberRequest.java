package com.clone.apps.web.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Created by kh.jin on 2019. 7. 2.
 */
@Data
public class MemberRequest {

    @JsonProperty("member_id")
    @NotEmpty
    private String memberId;

    @JsonProperty("password")
    @NotEmpty
    private String password;
}
