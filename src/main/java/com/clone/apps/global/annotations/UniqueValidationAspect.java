package com.clone.apps.global.annotations;

import com.clone.apps.global.service.UniqueValidator;
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

    @Before("@annotation(com.clone.apps.global.annotations.UniqueValidation)")
    public void handle(JoinPoint p) throws Exception {
        Method ms = ((MethodSignature) p.getSignature()).getMethod();

        if (!ms.isAnnotationPresent(UniqueValidation.class)) {
            // todo : exception.
        }

        UniqueValidator bean = (UniqueValidator) BeanUtils.getBean(ms.getAnnotation(UniqueValidation.class).executor());
        bean.valid(p.getArgs()[0]);
    }
}
