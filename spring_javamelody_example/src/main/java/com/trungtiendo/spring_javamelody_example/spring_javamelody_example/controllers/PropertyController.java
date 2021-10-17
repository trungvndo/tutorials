package com.trungtiendo.spring_javamelody_example.spring_javamelody_example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyController {

    @GetMapping(path = "/names")
    public List<String> getPropertyNames() {
        return List.of("A","B","C");
    }
}
