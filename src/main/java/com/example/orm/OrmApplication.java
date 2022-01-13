package com.example.orm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OrmApplication {



    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(OrmApplication.class, args);

    }

}
