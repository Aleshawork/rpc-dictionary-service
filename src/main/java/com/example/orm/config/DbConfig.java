package com.example.orm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Value("${db.cred.url}")
    private String url;

    @Value("${db.cred.password}")
    private String password;

    @Value("${db.cred.username}")
    private String username;

    @Value("${db.vendor}")
    private String vendor;


    @Bean
    public DataSource createDataSource(){
       return  DataSourceBuilder.create()
               .driverClassName(vendor)
                .url(url)
                .username(username)
                .password(password).build();
    }

}
