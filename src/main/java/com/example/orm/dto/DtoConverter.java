package com.example.orm.dto;

import java.lang.reflect.Method;

public  class DtoConverter {
    public static <T> T convertToDto(Object ob,Class<T> c){

        for(Method method:c.getMethods()){

        }
        return null;
    }
}
