package com.clone.apps.configurations;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
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
@EnableJpaAuditing
@Configuration
public class PersistenceConfiguration {
    private final Logger log = LoggerFactory.getLogger(PersistenceConfiguration.class);

    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties("spring.datasource.hikari")
    public HikariDataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @ConfigurationProperties(prefix = "config.hikari")
    @Bean(name = "hikariConfig")
    public HikariConfig hikariConfig() {
        log.info("HikariConfig");
        return new HikariConfig();
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory () {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.clone.apps.persistence");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "none");
        properties.put("hibernate.show-sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

        em.setJpaPropertyMap(properties);
        return em;
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
