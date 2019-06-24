package com.clone.apps.web;

import com.clone.apps.global.errors.BadRequestException;
import org.springframework.validation.BindingResult;

public interface BaseWebController {
    default void checkBindings(BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result);
        }
    }
}
