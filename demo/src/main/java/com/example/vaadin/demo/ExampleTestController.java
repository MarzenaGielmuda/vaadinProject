package com.example.vaadin.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleTestController {

    @RequestMapping("/rest")
    public String get(){return "Hello! :)";}
}
