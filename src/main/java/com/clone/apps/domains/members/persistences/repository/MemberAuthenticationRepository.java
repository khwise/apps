package com.clone.apps.domains.members.persistences.repository;

import com.clone.apps.domains.members.persistences.entity.MemberAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kh.jin on 2019. 7. 19.
 */

@Repository
public interface MemberAuthenticationRepository extends JpaRepository<MemberAuthentication, Long> {
}
