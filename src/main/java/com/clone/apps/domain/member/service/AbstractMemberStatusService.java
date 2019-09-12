package com.clone.apps.domain.member.service;

import com.clone.apps.domain.member.repository.MemberAuthenticationRepository;
import com.clone.apps.entity.member.MemberAuthentication;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kh.jin on 2019. 9. 13.
 */
public abstract class AbstractMemberStatusService {

    private MemberAuthenticationRepository repository;

    @Autowired
    public AbstractMemberStatusService(final MemberAuthenticationRepository repository) {
        this.repository = repository;
    }

    public void updateStatus(MemberAuthentication authentication) {
        repository.save(authentication);
    }
}
