package com.clone.apps;

import com.clone.apps.global.events.listeners.AppsStartedSampleListener;
import com.clone.apps.global.service.PropertyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({PropertyService.class})
public class AppsApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AppsApplication.class);
        app.addListeners(new AppsStartedSampleListener());
        app.run(args);
    }
}
