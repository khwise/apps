package com.clone.apps.global.annotations;

import com.clone.apps.global.components.UniqueValidator;
import com.clone.apps.global.utils.beans.BeanUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by kh.jin on 2019. 7. 3.
 */
@Component
@Aspect
public class UniqueValidationAspect {

    @Before("@annotation(com.clone.apps.global.annotations.Unique)")
    public void handle(JoinPoint p) {
        Method ms = ((MethodSignature) p.getSignature()).getMethod();
        UniqueValidator bean = (UniqueValidator) BeanUtils.getBean(ms.getAnnotation(Unique.class).executor());
        bean.valid(p.getArgs()[0]);
    }
}