package com.clone.apps.web.login;

import com.clone.apps.web.BaseWebController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kh.jin on 2019. 8. 6.
 */
@RestController(value = "/login")
public class LoginController implements BaseWebController {

    private final Logger log = LoggerFactory.getLogger(LoginController.class);

    @PostMapping
    public void login() {

    }
}