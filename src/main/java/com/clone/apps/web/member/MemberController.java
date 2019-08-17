package com.clone.apps.web.member;

import com.clone.apps.business.member.MemberService;
import com.clone.apps.global.codes.MemberStatusCode;
import com.clone.apps.global.utils.encypt.SHA256Helper;
import com.clone.apps.global.utils.encypt.SaltGenerator;
import com.clone.apps.persistence.MemberRepositoryService;
import com.clone.apps.persistence.entity.member.Member;
import com.clone.apps.persistence.entity.member.MemberAuthentication;
import com.clone.apps.web.BaseWebController;
import com.clone.apps.web.DefaultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

/**
 * Created by kh.jin on 2019. 6. 27.
 */
@RestController
public class MemberController implements BaseWebController {

    private final Logger log = LoggerFactory.getLogger(MemberController.class);

    private MemberService memberService;
    private MemberRepositoryService memberRepositoryService;

    @Autowired
    public MemberController(@Qualifier("memberRepositoryService") final MemberRepositoryService memberRepositoryService,
                            @Qualifier("memberServiceImpl") final MemberService memberService) {
        this.memberRepositoryService = memberRepositoryService;
        this.memberService = memberService;
    }

    @PostMapping("/members")
    public DefaultResponse<Member> saveMember(@RequestBody @Valid MemberRegistrationRequest request, BindingResult result) throws NoSuchAlgorithmException {
        checkBindings(result);

        Member member = request.convertMember();
        final String salt = SaltGenerator.generate();
        final String password = SHA256Helper.getInstance().encypt(request.getPassword(), salt);
        log.debug("salt : {}, password : {}, password size : {}", salt, password, password.length());
        // TODO : vo 레이어로 해당 내용 이용 시키자!
        member.setMemberAuthentication(
                MemberAuthentication
                .builder()
                .salt(salt)
                .password(password)
                .loginFailedCount(0)
                .lastPasswordChangedDate(LocalDate.now())
                .statusCode(MemberStatusCode.ACTIVATED)
                .build());

        Member savedMember = memberService.signUp(member);
        return DefaultResponse.success(savedMember);
    }
}