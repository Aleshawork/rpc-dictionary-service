package com.example.orm.model;



import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class MainInformationTest {

    String mainInformation = "{\"code\":\"client ifo\",\"source\":\"Oleg Petrov send 100$\",\"date\":\"2021-03-12\"}";

    @Test
    public void testConverter(){
        MainInformation mainInformation = null;
        try {
            mainInformation = new MainInformation(
                    "123-er",
                    "main operation",
                    "2021-03-04"

            );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertThat(mainInformation.getCode(),is("123-er"));
    }

}