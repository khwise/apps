package com.clone.apps.global.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Created by kh.jin on 2019. 7. 6.
 *
 * spring-servlet.xml 과 대응하는 Configuration.
 * web.xml 과 대응하는 Configuration.
 * - Interceptor
 * - Formatter
 * - Converter
 * - ViewResolve
 */
@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {
// multipartResolve 의 경우, AutoConfigure 로 처리함. (단순해서, 나중에 뭔가 핸들링이 필요할 때 Java 설정으로 변경)

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//    }
//
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        jsonConverter.setObjectMapper(mapper);

        // Convert 등록
        converters.add(jsonConverter);
    }

    /* Spring Bean 검색의 기본은 타입 > 이름 순이다. */
//    @Bean
//    public GlobalRequestLoggingFilter requestLoggingFilter() {
//        GlobalRequestLoggingFilter loggingFilter = new GlobalRequestLoggingFilter();
//        loggingFilter.setIncludeHeaders(true);
//        loggingFilter.setIncludeQueryString(true);
//        loggingFilter.setIncludePayload(true);
//        loggingFilter.setMaxPayloadLength(100);
//        loggingFilter.setIncludeClientInfo(true);
//        loggingFilter.setBeforeMessagePrefix("Before : ");
//        loggingFilter.setBeforeMessageSuffix("");
//        loggingFilter.setAfterMessageSuffix("");
//        loggingFilter.setAfterMessagePrefix("After : ");
//        return loggingFilter;
//    }
}
