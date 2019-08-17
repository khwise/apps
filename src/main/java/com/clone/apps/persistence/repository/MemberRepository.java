package com.clone.apps.persistence.repository;

import com.clone.apps.persistence.entity.member.Member;
import com.clone.apps.persistence.entity.member.MemberAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by kh.jin on 2019. 6. 27.
 *
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);
}
