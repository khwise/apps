package com.clone.apps.business.member;

import com.clone.apps.global.annotations.Unique;
import com.clone.apps.global.components.EmailUniqueValidator;
import com.clone.apps.persistence.MemberRepositoryService;
import com.clone.apps.persistence.entity.member.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kh.jin on 2019. 7. 2.
 */
@Service
public class MemberServiceImpl implements MemberService {

    private final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

    private MemberRepositoryService memberRepositoryService;

    @Autowired
    public MemberServiceImpl(MemberRepositoryService memberRepositoryService) {
        this.memberRepositoryService = memberRepositoryService;
    }

    @Transactional
    @Unique(executor = EmailUniqueValidator.class)
    @Override
    public Member signUp(Member member) {
        log.debug("[Save Member] - param : {}", member);
        return memberRepositoryService.save(member);
    }
}