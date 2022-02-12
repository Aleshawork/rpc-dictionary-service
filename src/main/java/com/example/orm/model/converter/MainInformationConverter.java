package com.example.orm.model.converter;

import com.example.orm.model.MainInformation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MainInformationConverter implements AttributeConverter<MainInformation,String> {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(MainInformation mainInformation) {

        String json="{}" ;
        try {
            json = objectMapper.writeValueAsString(mainInformation);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public MainInformation convertToEntityAttribute(String s) {
        MainInformation mainInformation = null;
        try {
            mainInformation = objectMapper.readValue(s, MainInformation.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return mainInformation;
    }
}
