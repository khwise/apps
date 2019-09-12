package com.clone.apps.domain.member.service;

import com.clone.apps.domain.member.repository.MemberAuthenticationRepository;
import com.clone.apps.entity.member.MemberAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kh.jin on 2019. 9. 13.
 *
 */

@Service
public class MemberBlockedService extends AbstractMemberStatusService {
    private final Logger log = LoggerFactory.getLogger(MemberBlockedService.class);

    @Autowired
    public MemberBlockedService(MemberAuthenticationRepository repository) {
        super(repository);
    }

    @Transactional
    public void blocked(MemberAuthentication authentication) {
        authentication.blocked();
        updateStatus(authentication);
    }
}