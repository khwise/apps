package com.clone.apps.web.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Created by kh.jin on 2019. 7. 2.
 */
@Data
public class MemberRequest {

    @Valid
    @NotEmpty
    private List<Member> members;

    @Data
    public static class Member {

        @JsonProperty("member_id")
        @NotEmpty
        private String memberId;

        @JsonProperty("password")
        @NotEmpty
        private String password;
    }
}
