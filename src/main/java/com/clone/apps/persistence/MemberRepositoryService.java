package com.clone.apps.persistence;

import com.clone.apps.persistence.entity.member.Member;

import java.util.List;

/**
 * Created by kh.jin on 2019. 6. 27.
 *
 */
public interface MemberRepositoryService {

    Member getOne(Long id);

    List<Member> getAll();

    Member save(Member member);

    Member update(Member member);

    void delete(Long id);

    List<Member> getMembers();
}
