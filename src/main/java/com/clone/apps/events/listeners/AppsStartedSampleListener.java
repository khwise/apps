package com.clone.apps.events.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by kh.jin on 2019. 7. 17.
 */

@Component
public class AppsStartedSampleListener implements ApplicationListener<ApplicationStartedEvent> {

    private final Logger log = LoggerFactory.getLogger(AppsStartedSampleListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        log.info("############### app stared.");
    }
}
