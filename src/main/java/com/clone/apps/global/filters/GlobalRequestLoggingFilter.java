package com.clone.apps.global.filters;

import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kh.jin on 2019. 8. 11.
 */
public class GlobalRequestLoggingFilter extends AbstractRequestLoggingFilter {

    @Override
    protected void beforeRequest(HttpServletRequest httpServletRequest, String s) {

    }

    @Override
    protected void afterRequest(HttpServletRequest httpServletRequest, String s) {

    }
}
