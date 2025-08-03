package com.security.demo.controller;

import com.security.demo.annotation.WithCustomUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithCustomUser(username = "Jedi")
    public void testHelloEndpoint() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/hello")
                        .header("Request-Id", "abc")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Hello spring security: Jedi"));
    }
}
