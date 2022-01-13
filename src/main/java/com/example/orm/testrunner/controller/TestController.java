package com.example.orm.testrunner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;

@RestController
@RequestMapping("/test")
public class TestController {

    private ExecutorService executorService;


    public TestController(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @GetMapping(path = "/{testClassName}")
    public String executeTestRunner(@PathVariable String testClassName){
       return null;
    }
}
