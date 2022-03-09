package com.example.orm.service.impl;

import com.example.orm.model.BigDecimalModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BigDecimalImplTest {
    @Autowired
    private BigDecimalImpl bigDecimal;

    @Test
    void getAll() {
        List<BigDecimalModel> all = bigDecimal.getAll();
        all.forEach(el-> System.out.println(el.getHours().toString()));

    }
}