package com.clone.apps.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by kh.jin on 2019. 7. 6.
 * Formatter, ViewResolve, MessageConvert, Interceptor 등을 정의한다.
 */
@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {
    // multipartResolve 의 경우, AutoConfigure 로 처리함. (단순해서, 나중에 뭔가 핸들링이 필요할 때 Java 설정으로 변경)
}
