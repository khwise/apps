package com.clone.apps.global.service;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by kh.jin on 2019. 7. 6.
 */
@ConfigurationProperties(prefix = "properties")
public class PropertyService {

    @Getter
    private String filePath;
}