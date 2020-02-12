package com.clone.apps.web.api.external;

import com.clone.apps.domains.members.persistences.entity.Member;
import com.clone.apps.domains.members.services.SignupService;
import com.clone.apps.web.api.BaseWebController;
import com.clone.apps.web.DefaultResponse;
import com.clone.apps.web.vo.SignupRequest;
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
