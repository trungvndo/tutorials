package com.example.resourceserver.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }

    @GetMapping("/auth")
    public Authentication getAuth(Authentication authentication) {
        return authentication;
    }
}
