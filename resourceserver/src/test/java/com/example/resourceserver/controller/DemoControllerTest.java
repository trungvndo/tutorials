package com.example.resourceserver.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.opaqueToken;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DemoControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void request_to_hello_without_token() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void request_to_hello_with_token() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello")
                        .with(opaqueToken()))
                .andExpect(status().isOk());
    }
}
