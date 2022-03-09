package com.example.orm.model.serializer;

import com.example.orm.model.BasePaymentRecord;
import com.example.orm.model.CardPayment;
import com.example.orm.model.OnlinePayment;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@JsonComponent
public class  PaymentSerializer <T extends BasePaymentRecord> extends JsonSerializer<List<T>> {


    @Override
    public void serialize(List<T> tList, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

//        List<T> cardPaymentList = tList.stream().filter(r -> {
//            return r instanceof CardPayment;
//        }).collect(Collectors.toList());
//        List<T> onlinePayment = tList.stream().filter(r->{
//            return r instanceof OnlinePayment;
//        }).collect(Collectors.toList());

        Map<String, List<T>> map = tList.stream().collect(Collectors.groupingBy(r ->{
            if (r instanceof CardPayment) return "cardPayment";
            else if (r instanceof OnlinePayment) return "onlinePayment";
            return "default";
        } , Collectors.toList()));

        jsonGenerator.writeStartObject();
        serializeList(map.get("cardPayment"),"cardPayment",jsonGenerator);
        serializeList(map.get("onlinePayment"),"onlinePayment",jsonGenerator);
        jsonGenerator.writeEndObject();

        /*
        jsonGenerator.writeStartObject();
        for(T a: tList){
            if(a instanceof CardPayment) jsonGenerator.writeFieldName("cardPayment");
            else if(a instanceof OnlinePayment) jsonGenerator.writeFieldName("onlinePayment");
            try {
                jsonGenerator.writeStartObject();
                serializeField(a,jsonGenerator);
                jsonGenerator.writeEndObject();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        jsonGenerator.writeEndObject();
        */


    }
    public void serializeList(List<T> list,String stringField,JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeFieldName(stringField);
        jsonGenerator.writeStartArray();
        for(T a: list){
            try {
                jsonGenerator.writeStartObject();
                serializeField(a,jsonGenerator);
                jsonGenerator.writeEndObject();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        jsonGenerator.writeEndArray();
    }

    public void serializeField(T object,JsonGenerator jsonGenerator) throws IOException, IllegalAccessException {
        for(Field field:object.getClass().getDeclaredFields()){
            field.setAccessible(true);
            if(field.getType().isAssignableFrom(String.class)){
                jsonGenerator.writeStringField(field.getName(),(String) field.get(object));
            }else if(field.getType().isAssignableFrom(Date.class)){
                jsonGenerator.writeNumberField(field.getName(), ((Date) field.get(object)).getTime());
            }
        }

    }
}
