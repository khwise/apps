package com.clone.apps.domain.member.service;

import com.clone.apps.domain.member.persistence.entity.MemberAuthentication;
import com.clone.apps.domain.member.persistence.repository.MemberAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kh.jin on 2019. 9. 13.
 */
public abstract class AbstractMemberStatusService {

    @Autowired
    private MemberAuthenticationRepository repository;

    public void updateStatus(MemberAuthentication authentication) {
        repository.save(authentication);
    }
}
