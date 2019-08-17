package com.clone.apps.business.member;

import com.clone.apps.persistence.entity.member.Member;

/**
 * Created by kh.jin on 2019. 7. 2.
 */
public interface MemberService {

    Member signUp(Member member);
}
