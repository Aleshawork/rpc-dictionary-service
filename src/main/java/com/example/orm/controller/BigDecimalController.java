package com.example.orm.controller;

import com.example.orm.model.BigDecimalModel;
import com.example.orm.service.impl.BigDecimalImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/decimal")
public class BigDecimalController {

    @Autowired
    private BigDecimalImpl bigDecimal;

    @GetMapping(value = "/all")
    public List<BigDecimalModel> getAll(){
        return bigDecimal.getAll();
    }
}
