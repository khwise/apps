package com.clone.apps.domain.member.signup.web;

import com.clone.apps.domain.member.signup.service.SignupService;
import com.clone.apps.entity.member.Member;
import com.clone.apps.global.web.BaseWebController;
import com.clone.apps.global.web.response.DefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by kh.jin on 2019. 9. 11.
 */
@RestController
public class SignupController implements BaseWebController {

    private SignupService service;

    @Autowired
    public SignupController(final SignupService service) {
        this.service = service;
    }

    @PostMapping(value = "/signup")
    public DefaultResponse<Member> signup(@RequestBody @Valid SignupRequest request, BindingResult result) {
        checkBindings(result);
        return DefaultResponse.success(
                Optional.ofNullable(service.signup(request)).get()
        );
    }
}
