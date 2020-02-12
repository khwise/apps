package com.clone.apps.web.api;

import com.clone.apps.commons.errors.BadRequestException;
import org.springframework.validation.BindingResult;

public interface BaseWebController {
    default void checkBindings(BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result);
        }
    }
}