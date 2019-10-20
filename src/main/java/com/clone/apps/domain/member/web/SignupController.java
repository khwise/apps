package com.clone.apps.domain.member.web;

import com.clone.apps.domain.member.persistence.entity.Member;
import com.clone.apps.domain.member.service.SignupService;
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
