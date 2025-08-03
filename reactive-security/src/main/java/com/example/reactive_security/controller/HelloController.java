package com.example.reactive_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("hello you!");
    }

    @GetMapping("/ciao")
    public Mono<String> ciao() {
        return Mono.just("ciao ciao");
    }
}
