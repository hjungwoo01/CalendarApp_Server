package com.hjungwoo01.calendarappserver.config;

import javax.sql.DataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "memoEntityManagerFactory",
        transactionManagerRef = "memoTransactionManager",
        basePackages = { "com.hjungwoo01.calendarappserver.repositories.memo" }
)
public class MemoDBConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.memo.datasource")
    public DataSourceProperties memoDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean(name = "memoDataSource")
    public DataSource memoDataSource(@Qualifier("memoDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "memoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean memoEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                                @Qualifier("memoDataSource") DataSource memoDataSource) {
        return builder
                .dataSource(memoDataSource)
                .packages("com.hjungwoo01.calendarappserver.model.memo")
                .persistenceUnit("memo")
                .build();
    }

    @Bean(name = "memoTransactionManager")
    public PlatformTransactionManager memoTransactionManager(
            @Qualifier("memoEntityManagerFactory") EntityManagerFactory memoEntityManagerFactory) {
        return new JpaTransactionManager(memoEntityManagerFactory);
    }
}
