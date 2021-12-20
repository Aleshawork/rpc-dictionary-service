package com.example.orm;

import com.example.orm.model.Message;
import com.example.orm.service.MessageDulByHqlPrivateService;
import com.example.orm.service.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmApplication {



    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(OrmApplication.class, args);

    }

}
