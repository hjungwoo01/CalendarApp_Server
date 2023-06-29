package com.hjungwoo01.calendarappserver.config;

import javax.sql.DataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "eventEntityManagerFactory",
        transactionManagerRef = "eventTransactionManager",
        basePackages = { "com.hjungwoo01.calendarappserver.repositories.event" }
)
public class EventDBConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.event.datasource")
    public DataSourceProperties eventDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean(name = "eventDataSource")
    public DataSource eventDataSource(@Qualifier("eventDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "eventEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean eventEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("eventDataSource") DataSource eventDataSource) {
        return builder
                .dataSource(eventDataSource)
                .packages("com.hjungwoo01.calendarappserver.model.event")
                .persistenceUnit("event")
                .build();
    }

    @Bean(name = "eventTransactionManager")
    public PlatformTransactionManager eventTransactionManager(
            @Qualifier("eventEntityManagerFactory") EntityManagerFactory eventEntityManagerFactory) {
        return new JpaTransactionManager(eventEntityManagerFactory);
    }
}
