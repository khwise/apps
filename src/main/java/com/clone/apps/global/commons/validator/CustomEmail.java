package com.clone.apps.global.commons.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by kh.jin on 2019. 7. 19.
 */

@Documented
@Constraint(validatedBy = CustomEmailValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomEmail {

    String message() default "Email 형식이 잘못되었습니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
