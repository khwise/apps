package com.clone.apps.web.member;

import com.clone.apps.global.codes.MemberStatusCode;
import com.clone.apps.global.response.DefaultResponse;
import com.clone.apps.global.response.SuccessCode;
import com.clone.apps.persistence.MemberRepositoryService;
import com.clone.apps.persistence.entity.member.Member;
import com.clone.apps.web.BaseWebController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * Created by kh.jin on 2019. 6. 27.
 */
@RestController
public class MemberController implements BaseWebController {

    private final Logger log = LoggerFactory.getLogger(MemberController.class);

    private MemberRepositoryService memberRepositoryService;

    @Autowired
    public MemberController(MemberRepositoryService memberRepositoryService) {
        this.memberRepositoryService = memberRepositoryService;
    }

    @PostMapping("/member")
    public DefaultResponse<Member> saveMember() {
        Member member = memberRepositoryService.save(Member
                .builder()
                .id("test-account1")
                .password("1234")
                .status(MemberStatusCode.ACTIVATED)
                .lastPasswordChangedDate(LocalDate.now())
                .loginFailedCount(0)
                .build()
        );

        return DefaultResponse.success(SuccessCode.CREATED, member);
    }
}
