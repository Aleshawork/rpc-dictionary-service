package com.example.orm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Collections;

@SpringBootApplication
public class OrmApplication {



    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(OrmApplication.class, args);

    }

}
