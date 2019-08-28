package com.clone.apps.domain.sample.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kh.jin on 2019. 7. 17.
 */
@RestController
public class HealthCheckController {

    private final Logger log = LoggerFactory.getLogger(HealthCheckController.class);

    @GetMapping("/health")
    public String healthCheck() {
        log.trace("TRACE");
        log.debug("DEBUG");
        log.info("INFO");
        log.warn("WARN");
        log.error("ERROR");
        
        return "I am running..";
    }
}
