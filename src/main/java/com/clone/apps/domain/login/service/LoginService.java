package com.clone.apps.domain.login.service;

import com.clone.apps.domain.login.web.LoginRequest;
import com.clone.apps.domain.member.repository.MemberAuthenticationRepository;
import com.clone.apps.domain.member.repository.MemberRepository;
import com.clone.apps.domain.member.service.MemberBlockedService;
import com.clone.apps.entity.member.Member;
import com.clone.apps.entity.member.MemberAuthentication;
import com.clone.apps.global.errors.BusinessException;
import com.clone.apps.global.errors.LoginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

/**
 * Created by kh.jin on 2019. 9. 8.
 */
@Service
public class LoginService {
    private final Logger log = LoggerFactory.getLogger(LoginService.class);

    // TODO : 프로퍼티로 처리
    private final static int BLOCKED_CNT = 5;

    private MemberRepository memberRepository;
    private MemberAuthenticationRepository memberAuthenticationRepository;
    private MemberBlockedService memberBlockedService;

    @Autowired
    public LoginService(@Qualifier("memberRepository") final MemberRepository memberRepository,
                        @Qualifier("memberAuthenticationRepository") final MemberAuthenticationRepository memberAuthenticationRepository,
                        @Qualifier("memberBlockedService") final MemberBlockedService memberBlockedService) {
        this.memberRepository = memberRepository;
        this.memberAuthenticationRepository = memberAuthenticationRepository;
        this.memberBlockedService = memberBlockedService;
    }

    public Member login(LoginRequest request) throws NoSuchAlgorithmException {
        Member member = memberRepository.findByEmail(request.getEmail());
        Optional.ofNullable(member).orElseThrow(LoginException::new);
        log.debug("member : {}", member);

        Optional.ofNullable(member).map(Member::getMemberAuthentication).orElseThrow(LoginException::new);
        MemberAuthentication authentication = member.getMemberAuthentication();
        log.debug("member authentication : {}", authentication);

        if (!authentication.authenticate(request.getPassword())) {
            authentication.incrementLoginFailedCount();
            if (BLOCKED_CNT <= authentication.getLoginFailedCount()) {
                memberBlockedService.blocked(authentication);
            }
            // TODO : History Table 생성 저장
            throw new BusinessException();
        }
        authentication.initLoginFailedCount();
        memberAuthenticationRepository.save(authentication);

        // Login History
        return member;
    }
}
