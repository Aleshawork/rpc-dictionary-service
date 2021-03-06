package com.example.orm.config;

import com.example.orm.model.User;
import com.example.orm.model.converter.UserJsonSerializer;
import com.example.orm.service.MessageByHqlService;
import com.example.orm.service.MessageDulByHqlPrivateService;
import com.example.orm.service.MessageService;
import com.example.orm.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.googlecode.jsonrpc4j.spring.JsonServiceExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RpcConfig {

    @Bean(name ="/com.example.orm.service.MessageService")
    public JsonServiceExporter getMessageServiceExporter(MessageService messageService){
        JsonServiceExporter jsonServiceExporter = new JsonServiceExporter();
        jsonServiceExporter.setService(messageService);
        jsonServiceExporter.setServiceInterface(MessageService.class);
        return jsonServiceExporter;
    }

    @Bean(name="/com.example.orm.service.MessageByHqlService")
    public JsonServiceExporter getMessageByHqlService(MessageByHqlService messageByHqlService){
        JsonServiceExporter jsonServiceExporter = new JsonServiceExporter();
        jsonServiceExporter.setService(messageByHqlService);
        jsonServiceExporter.setServiceInterface(MessageByHqlService.class);
        return jsonServiceExporter;
    }

    @Bean(name="/com.example.orm.service.MessageDulByHqlPrivateService")
    public JsonServiceExporter getMessageByHqlService(MessageDulByHqlPrivateService messageDulByHqlPrivateService){
        JsonServiceExporter jsonServiceExporter = new JsonServiceExporter();
        jsonServiceExporter.setService(messageDulByHqlPrivateService);
        jsonServiceExporter.setServiceInterface(MessageDulByHqlPrivateService.class);
        return jsonServiceExporter;
    }

    @Bean(name="/com.example.orm.service.UserService")
    public JsonServiceExporter getUserByHql(UserService userService){
        JsonServiceExporter jsonServiceExporter = new JsonServiceExporter();
        jsonServiceExporter.setService(userService);
        jsonServiceExporter.setServiceInterface(UserService.class);
        ObjectMapper objectMapper = new ObjectMapper();
       SimpleModule simpleModule =  new SimpleModule();
        simpleModule.addSerializer(new UserJsonSerializer(User.class));
        objectMapper.registerModule(simpleModule);
        jsonServiceExporter.setObjectMapper(objectMapper);
        return jsonServiceExporter;
    }
}
