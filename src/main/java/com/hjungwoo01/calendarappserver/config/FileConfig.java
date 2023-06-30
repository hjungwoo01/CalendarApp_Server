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
        entityManagerFactoryRef = "fileEntityManagerFactory",
        transactionManagerRef = "fileTransactionManager",
        basePackages = { "com.hjungwoo01.calendarappserver.repositories.file" }
)
public class FileConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.file.datasource")
    public DataSourceProperties fileDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean(name = "fileDataSource")
    public DataSource fileDataSource(@Qualifier("fileDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "fileEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean fileEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("fileDataSource") DataSource fileDataSource) {
        return builder
                .dataSource(fileDataSource)
                .packages("com.hjungwoo01.calendarappserver.model.file")
                .persistenceUnit("file")
                .build();
    }

    @Bean(name = "fileTransactionManager")
    public PlatformTransactionManager fileTransactionManager(
            @Qualifier("fileEntityManagerFactory") EntityManagerFactory fileEntityManagerFactory) {
        return new JpaTransactionManager(fileEntityManagerFactory);
    }
}
