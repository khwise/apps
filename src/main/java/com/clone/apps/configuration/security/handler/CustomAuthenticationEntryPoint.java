package com.clone.apps.configuration.security.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kh.jin on 2019. 10. 26.
 */
public class CustomAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
    private final Logger log = LoggerFactory.getLogger(CustomAuthenticationEntryPoint.class);

    public CustomAuthenticationEntryPoint(String s) {
        super(s);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.info("Authentication entry point.");
        super.commence(request, response, authException);
    }
}
