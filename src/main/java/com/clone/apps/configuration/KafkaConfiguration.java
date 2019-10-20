package com.clone.apps.configuration;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kh.jin on 2019. 9. 21.
 */
@Configuration
public class KafkaConfiguration {

    private final static String BOOTSTRAP_SERVERS_HOST = "127.0.0.1";

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_HOST);
        return new KafkaAdmin(configs);
    }
}
