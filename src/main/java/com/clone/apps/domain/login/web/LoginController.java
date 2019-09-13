package com.clone.apps.domain.login.web;

import com.clone.apps.domain.login.service.LoginService;
import com.clone.apps.entity.member.Member;
import com.clone.apps.global.errors.AppsException;
import com.clone.apps.global.web.BaseWebController;
import com.clone.apps.global.web.response.DefaultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kh.jin on 2019. 8. 6.
 */
@RestController
public class LoginController implements BaseWebController {
    private final Logger log = LoggerFactory.getLogger(LoginController.class);

    private LoginService service;

    @Autowired
    public LoginController(final LoginService service) {
        this.service = service;
    }

    @PostMapping(value = "/login")
    public DefaultResponse<LoginResult> login(@RequestBody @Valid final LoginRequest request) {
        try {
            LoginResult result = service.login(request);
            return DefaultResponse.success(result);
        } catch (NoSuchAlgorithmException e) {
            log.debug("NoSuchAlgorithmException.");
            throw new AppsException();
        }
    }
}