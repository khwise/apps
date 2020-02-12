package com.clone.apps.web.api.external;

import com.clone.apps.domains.members.services.LoginService;
import com.clone.apps.commons.errors.AppsException;
import com.clone.apps.web.DefaultResponse;
import com.clone.apps.web.api.ExternalContextController;
import com.clone.apps.web.vo.LoginRequest;
import com.clone.apps.web.vo.LoginResult;
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
public class SigninController implements ExternalContextController {
    private final Logger log = LoggerFactory.getLogger(SigninController.class);

    private LoginService service;

    @Autowired
    public SigninController(final LoginService service) {
        this.service = service;
    }

    @PostMapping(value = "/signin")
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