package com.example.reactive_security.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
public class HelloControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void testCallUnauthorised() {
        webTestClient.get()
                .uri("/hello")
                .exchange()
                .expectStatus().isUnauthorized();
    }

    @Test
    @WithMockUser
    void testCallWithMockUser() {
        webTestClient.get()
                .uri("/hello")
                .exchange()
                .expectStatus().isOk();
    }
}
