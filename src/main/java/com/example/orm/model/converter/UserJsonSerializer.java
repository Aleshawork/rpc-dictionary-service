package com.example.orm.model.converter;

import com.example.orm.model.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class UserJsonSerializer extends StdSerializer<User> {
    public UserJsonSerializer(Class<User> t) {
        super(t);
    }

    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumberField("age",user.getAge());
        jsonGenerator.writeStringField("name",user.getName());
        jsonGenerator.writeEndObject();
    }
}
