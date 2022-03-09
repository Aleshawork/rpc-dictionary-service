package com.example.orm.controller;

import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class PaymentTest extends AbstractPaymentTest {


    @Test
    public void shouldFindAll() throws Exception {
        mockMvc.perform(
                post("/pay/all")

        ).andDo(print());
    }
}
