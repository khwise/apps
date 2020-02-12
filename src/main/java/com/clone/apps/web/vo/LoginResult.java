package com.clone.apps.web.vo;

import com.clone.apps.domains.members.persistences.entity.Member;
import com.clone.apps.commons.code.MemberStatusCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by kh.jin on 2019. 9. 13.
 */
@NoArgsConstructor
@Getter
public class LoginResult {

    private boolean result;

    private int failedCnt;

    private MemberStatusCode memberStatus;

    private Member member;

    @Builder
    public LoginResult(boolean result, int failedCnt, MemberStatusCode memberStatus, Member member) {
        this.result = result;
        this.failedCnt = failedCnt;
        this.memberStatus = memberStatus;
        this.member = member;
    }
}
