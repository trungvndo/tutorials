package com.trungtiendo.resourceserverexample.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.opaqueToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest
@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerAuthorizationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getPropertiesWithReadScope() throws Exception {
        this.mockMvc
                .perform(get("/properties").with(getTokenWithScope("read")))
                .andExpect(status().isOk());
    }

    @Test
    public void getPropertiesWithUpdateScope() throws Exception {
        this.mockMvc
                .perform(get("/properties").with(getTokenWithScope("update")))
                .andExpect(status().isForbidden());
    }

    @Test
    public void getPropertiesWithNoTokenAuthentication() throws Exception {
        this.mockMvc
                .perform(get("/properties"))
                .andExpect(status().isUnauthorized());
    }

    private SecurityMockMvcRequestPostProcessors.OpaqueTokenRequestPostProcessor getTokenWithScope(String scope) {
        return opaqueToken()
                .attributes(a -> a.put("scope", scope));
    }
}
