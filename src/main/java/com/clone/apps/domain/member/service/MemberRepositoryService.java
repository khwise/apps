package com.clone.apps.domain.member.service;

import com.clone.apps.entity.member.Member;
import com.clone.apps.entity.member.MemberAuthentication;
import com.clone.apps.domain.member.repository.MemberAuthenticationRepository;
import com.clone.apps.domain.member.repository.MemberRepository;
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
        Member savedMember = memberRepository.save(member);
        log.info("member id : {}", savedMember.getId());

        MemberAuthentication authentication = member.getMemberAuthentication();
        authentication.setId(savedMember.getId());
        log.info("authentication : {}", authentication);
        memberAuthenticationRepository.save(authentication);

        // event handle....
        return member;
    }

    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}