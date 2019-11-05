package com.clone.apps.global.validator;

import com.clone.apps.domain.member.persistence.entity.Member;
import com.clone.apps.domain.member.persistence.repository.MemberRepository;
import com.clone.apps.global.errors.BusinessException;
import com.clone.apps.global.errors.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by kh.jin on 2019. 7. 3.
 */

@Component
public class EmailUniqueValidator implements UniqueValidator {

    private final Logger log = LoggerFactory.getLogger(EmailUniqueValidator.class);

    private MemberRepository memberRepository;

    @Autowired
    public EmailUniqueValidator(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void valid(Object param) {
        Member member = (Member) param;
        log.debug("[Email Unique Validation] - param : {}", param);
        if (memberRepository.findByEmail(member.getEmail()) != null) {
            throw new BusinessException(ErrorCode.DUPLICATE_DATA);
        }
    }
}