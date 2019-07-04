package com.clone.apps.business.member;

import com.clone.apps.global.annotations.UniqueValidation;
import com.clone.apps.global.service.UniqueMemberIdValidator;
import com.clone.apps.global.models.codes.MemberStatusCode;
import com.clone.apps.global.utils.encypt.SHA256Helper;
import com.clone.apps.global.utils.encypt.SaltGenerator;
import com.clone.apps.persistence.MemberRepositoryService;
import com.clone.apps.persistence.entity.member.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

/**
 * Created by kh.jin on 2019. 7. 2.
 */
@Service
public class MemberServiceImpl implements MemberService {

    private final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

    private MemberRepositoryService memberRepositoryService;

    @Autowired
    public MemberServiceImpl(final MemberRepositoryService memberRepositoryService) {
        this.memberRepositoryService = memberRepositoryService;
    }

    @UniqueValidation(executor = UniqueMemberIdValidator.class)
    @Override
    public Member save(Member member) {

        // todo : ID 중복 체크 관련 AOP 만들기.

        //salt 생성
        String salt = SaltGenerator.generate();
        log.debug("salt : {}", salt);

        //password 변경
        try {
            member.setPassword(SHA256Helper.getInstance().encypt(member.getPassword(), salt));
            member.setSalt(salt);
        } catch (NoSuchAlgorithmException e) {
            log.error("An error occurred during password encryption.");
            // todo : exception 처리
        }

        // Default 값 설정
        member.setLastPasswordChangedDate(LocalDate.now());
        member.setLoginFailedCount(0);
        member.setStatus(MemberStatusCode.ACTIVATED);

        Member savedMember = memberRepositoryService.save(member);
        log.debug("saved member : {}", member);
        return savedMember;
    }
}