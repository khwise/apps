package com.clone.apps.global.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by kh.jin on 2019. 7. 6.
 */
@Component
@ConfigurationProperties(prefix = "properties")
public class PropertyService {

    @Setter
    @Getter
    private String filePath;
}