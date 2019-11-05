package com.clone.apps.configuration.security;

import com.clone.apps.configuration.security.filters.JwtAuthenticationFilter;
import com.clone.apps.configuration.security.filters.JwtAuthorizationFilter;
import com.clone.apps.configuration.security.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * Created by kh.jin on 2019. 10. 24.
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("customAuthenticationProvider")
    private AuthenticationProvider authenticationProvider;

    @Override
    public void configure(WebSecurity web) {
        //web.ignoring().antMatchers("/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html", "/webjars/**", "/swagger/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();
//        http.httpBasic()
//                .disable() // Form Login 사용 시 활성화 (난 rest 라서 비활성화)
//            .csrf()
//                .disable() //
//            .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // JWT 토큰을 사용할꺼라서 비활성화
//        .and()
//            .authorizeRequests()
//                .antMatchers("/signup", "/signin", "/health")
//                    .permitAll()
//                .anyRequest()
//                    .hasRole("USER") // 그외 나머지 요청은 모두 인증된 회원만 접근 가능
//        .and()
//            .exceptionHandling()
//                .accessDeniedHandler(accessDeniedHandler())            // 권한을 확인 할 수 없을 때 처리
//                .authenticationEntryPoint(authenticationEntryPoint())  // 인증 정보가 없을 경우 처리
//        .and()
//            .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessHandler(logoutSuccessHandler())
//        .and()
//            .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
//            .addFilter(jwtAuthenticationFilter())
//            .addFilter(jwtAuthorizationFilter())
        ;
    }

    /*
     * LogoutSuccessHandler bean register
     */
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        CustomLogoutSuccessHandler logoutSuccessHandler = new CustomLogoutSuccessHandler();
        logoutSuccessHandler.setDefaultTargetUrl("/loginPage?logout=logout");
        return logoutSuccessHandler;
    }

    /*
     * AccessDeniedHandler bean register
     */
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        CustomAccessDeniedHandler accessDeniedHandler = new CustomAccessDeniedHandler();
        return accessDeniedHandler;
    }

    /*
     * AuthenticationEntryPoint bean register
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint("/loginPage?error=e");
    }

    /*
     * Form Login 시 걸리는 Filter bean register
     */
    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager());
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");
        jwtAuthenticationFilter.setUsernameParameter("username");
        jwtAuthenticationFilter.setPasswordParameter("password");
        jwtAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
        jwtAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
        jwtAuthenticationFilter.afterPropertiesSet();
        return jwtAuthenticationFilter;
    }

    /*
     * Filter bean register
     */
    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter() throws Exception {
        JwtAuthorizationFilter jwtAuthorizationFilter = new JwtAuthorizationFilter(authenticationManager());
        return jwtAuthorizationFilter;
    }


    /*
     * SuccessHandler bean register
     */
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        CustomAuthenticationSuccessHandler successHandler = new CustomAuthenticationSuccessHandler();
        successHandler.setDefaultTargetUrl("/index");
        return successHandler;
    }

    /*
     * FailureHandler bean register
     */
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        CustomAuthenticationFailureHandler failureHandler = new CustomAuthenticationFailureHandler();
        failureHandler.setDefaultFailureUrl("/loginPage?error=error");
        return failureHandler;
    }
}