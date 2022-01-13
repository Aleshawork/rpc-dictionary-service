package com.example.orm.model.converter;

import com.example.orm.model.User;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class UserJsonDeSerializer extends StdDeserializer<User> {
    public UserJsonDeSerializer(Class<User> t) {
        super(t);
    }


    @Override
    public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        int age = ((IntNode) node.get("age")).intValue();
        String name = node.get("name").asText();
        User user= new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }
}
