package com.clone.apps.business.member;

import com.clone.apps.persistence.entity.member.Member;

import java.util.List;

/**
 * Created by kh.jin on 2019. 7. 2.
 */
public interface MemberService {

    Member save(List<Member> members);
}
