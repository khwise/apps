package com.clone.apps.web.member;

import com.clone.apps.business.member.MemberService;
import com.clone.apps.global.models.response.DefaultResponse;
import com.clone.apps.global.models.response.SuccessCode;
import com.clone.apps.persistence.MemberRepositoryService;
import com.clone.apps.persistence.entity.member.Member;
import com.clone.apps.web.BaseWebController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by kh.jin on 2019. 6. 27.
 */
@RestController
public class MemberController implements BaseWebController {

    private final Logger log = LoggerFactory.getLogger(MemberController.class);

    private MemberService memberService;
    private MemberRepositoryService memberRepositoryService;

    @Autowired
    public MemberController(final MemberRepositoryService memberRepositoryService,
                            final MemberService memberService) {
        this.memberRepositoryService = memberRepositoryService;
        this.memberService = memberService;
    }

    @PostMapping("/member")
    public DefaultResponse<Member> saveMember(@RequestBody @Valid MemberRequest request, BindingResult result) {
        checkBindings(result);

        Member member = new Member();
        BeanUtils.copyProperties(request, member);

        member = memberService.save(member);
        return DefaultResponse.success(SuccessCode.CREATED, member);
    }

    @GetMapping("/members")
    public DefaultResponse<List<Member>> getMembers() {
        List<Member> members = memberRepositoryService.getMembers();
        return DefaultResponse.success(SuccessCode.FIND_LIST, members);
    }
}
