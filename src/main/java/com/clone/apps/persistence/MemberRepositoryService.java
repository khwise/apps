package com.clone.apps.persistence;

import com.clone.apps.persistence.entity.member.Member;

import java.util.List;

/**
 * Created by kh.jin on 2019. 6. 27.
 *
 */
public interface MemberRepositoryService {

    Member findOne(Long id);

    List<Member> findAll();

    Member save(Member member);

    Member update(Member member);

    void delete(Long id);

    Member findByMemberId(String memberId);

    List<Member> getMembers();
}
