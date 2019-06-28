package com.clone.apps.persistence.mapper;

import com.clone.apps.persistence.entity.member.Member;

import java.util.List;

/**
 * Created by kh.jin on 2019. 6. 28.
 */
public interface MemberMapper {

    List<Member> selectMembers();
}
