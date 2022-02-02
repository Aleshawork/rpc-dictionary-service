package com.example.orm.dto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class SqlDtoConverterTest {
    private List<String> names = List.of("name","age");
    private List<Object> values = List.of("Alexey",20);
    private SqlDtoConverter sqlDtoConverter = new SqlDtoConverter();
    private Map<String,Object> map = Map.of(
            "name","Alexey",
            "age",20
            );

    @Test
    void convert() {

    }
}