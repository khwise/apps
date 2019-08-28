package com.clone.apps.domain.member.repository;

import com.clone.apps.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kh.jin on 2019. 6. 27.
 *
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);
}
