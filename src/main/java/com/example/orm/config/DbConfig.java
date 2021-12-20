package com.example.orm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Value("${db.cred.url}")
    private String url;

    @Value("${db.cred.password}")
    private String password;

    @Value("${db.cred.username}")
    private String username;


    @Bean
    public DataSource createDataSource(){
       return  DataSourceBuilder.create()
               .driverClassName("org.postgresql.Driver")
                .url(url)
                .username(username)
                .password(password).build();
    }

}
