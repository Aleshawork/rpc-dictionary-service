package com.example.orm.controller;

import com.example.orm.model.Information;
import com.example.orm.service.utilities.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/information")
@RestController
public class InformationController {

    @Autowired
    private InformationService informationService;

    @GetMapping(value = "/all")
    public List<Information> getAllInformation(){
        return informationService.getAllInformation();
    }
}
