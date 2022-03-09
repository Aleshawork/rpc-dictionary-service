package com.example.orm.controller;

import com.example.orm.model.BasePaymentRecord;
import com.example.orm.model.serializer.PaymentSerializer;
import com.example.orm.service.impl.PaymentServiceImpl;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pay")
public class PaymentController {

    private final PaymentServiceImpl paymentService;


    @Autowired
    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/all")
    public List<? extends BasePaymentRecord> getPaymentsByDate(Date date){
        return paymentService.getAllPaymentByDate(date);
    }
}
