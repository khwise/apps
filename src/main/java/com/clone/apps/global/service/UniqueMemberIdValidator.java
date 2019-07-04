package com.clone.apps.global.service;

import com.clone.apps.global.errors.BusinessException;
import com.clone.apps.persistence.MemberRepositoryService;
import com.clone.apps.persistence.entity.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by kh.jin on 2019. 7. 3.
 */

@Component
public class UniqueMemberIdValidator implements UniqueValidator {
    private MemberRepositoryService memberRepositoryService;

    @Autowired
    public UniqueMemberIdValidator(final MemberRepositoryService memberRepositoryService) {
        this.memberRepositoryService = memberRepositoryService;
    }

    @Override
    public void valid(Object param) {
        Member member = (Member) param;
        if (memberRepositoryService.findByMemberId(member.getMemberId()) != null) {
            throw new BusinessException();
        }
    }
}
