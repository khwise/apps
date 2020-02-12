package com.clone.apps.domains.members.services;

import com.clone.apps.domains.members.persistences.entity.MemberAuthentication;
import com.clone.apps.domains.members.persistences.repository.MemberAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kh.jin on 2019. 9. 13.
 */
public abstract class AbstractMemberStatusService {

    @Autowired
    private MemberAuthenticationRepository repository;

    protected void updateStatus(MemberAuthentication authentication) {
        repository.save(authentication);
    }
}
