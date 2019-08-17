package com.clone.apps.persistence;

import com.clone.apps.persistence.entity.member.Member;
import com.clone.apps.persistence.entity.member.MemberAuthentication;
import com.clone.apps.persistence.repository.MemberAuthenticationRepository;
import com.clone.apps.persistence.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by kh.jin on 2019. 6. 27.
 */

@Component
public class MemberRepositoryService {

    private final Logger log = LoggerFactory.getLogger(MemberRepositoryService.class);

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberAuthenticationRepository memberAuthenticationRepository;

    public Member save(Member member) {
        memberRepository.save(member);
        log.info("member id : {}", member.getId());
        member.getMemberAuthentication().setId(member.getId());
        memberAuthenticationRepository.save(member.getMemberAuthentication());
        return member;
    }

    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}