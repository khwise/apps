package com.clone.apps.configurations;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by kh.jin on 2019. 6. 26.
 *
 * DB 관련 설정
 * DataSource (Hikari), Transaction, MYBATIS, Hibernate(JPA)
 */

@EnableTransactionManagement
@Configuration
public class PersistenceConfiguration {
    private final Logger log = LoggerFactory.getLogger(PersistenceConfiguration.class);

    @Autowired
    @Bean("dataSource")
    public HikariDataSource hikariDataSource(@Qualifier("hikariConfig") HikariConfig config) {
        log.info("HikariDataSource. config : {}", config.getJdbcUrl());
        return new HikariDataSource(config);
    }

    @ConfigurationProperties(prefix = "config.hikari")
    @Bean(name = "hikariConfig")
    public HikariConfig hikariConfig() {
        log.info("HikariConfig");
        return new HikariConfig();
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory (
            @Qualifier("dataSource") DataSource dataSource,
            @Qualifier("hibernateProperty") Map<String,String> hibernateProperty) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.clone.apps.persistence");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaPropertyMap(hibernateProperty);
        return em;
    }

    @ConfigurationProperties(prefix = "config.hibernate")
    @Bean(name = "hibernateProperty")
    public Map<String,String> hibernateProperty() {
        log.info("hibernateProperty");
        return new HashMap<>();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory em) {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(em);
        return tm;
    }

    @Bean
    public AuditorAware<Long> auditorAware() {
        return new AuditorAwareImpl();
    }

    public class AuditorAwareImpl implements AuditorAware<Long> {
        private Long auditor = 10000L;

        @Override
        public Optional<Long> getCurrentAuditor() {
            return Optional.of(auditor);
        }
    }

}
