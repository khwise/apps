package com.clone.apps.global.components;

import com.clone.apps.global.errors.BusinessException;
import com.clone.apps.global.errors.ErrorCode;
import com.clone.apps.global.utils.DelimiterUtils;
import com.clone.apps.persistence.MemberRepositoryService;
import com.clone.apps.persistence.entity.member.Member;
import com.clone.apps.persistence.entity.member.MemberAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kh.jin on 2019. 7. 3.
 */

@Component
public class EmailUniqueValidator implements UniqueValidator {

    private final Logger log = LoggerFactory.getLogger(EmailUniqueValidator.class);

    private MemberRepositoryService memberRepositoryService;

    @Autowired
    public EmailUniqueValidator(final MemberRepositoryService memberRepositoryService) {
        this.memberRepositoryService = memberRepositoryService;
    }

    @Override
    public void valid(Object param) {
        Member member = (Member) param;
        log.debug("[Email Unique Validation] - param : {}", param);
        if (memberRepositoryService.findByEmail(member.getEmail()) != null) {
            throw new BusinessException(ErrorCode.DUPLICATE_DATA);
        }
    }
}