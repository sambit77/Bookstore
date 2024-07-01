package com.ms.order.web.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ms.order.AbstractIntegrationTest;
import com.ms.order.WithMockOAuth2User;
import org.junit.jupiter.api.Test;

class GetOrdersTests extends AbstractIntegrationTest {

    @Test
    @WithMockOAuth2User(username = "user")
    void shouldGetOrdersSuccessfully() throws Exception {
        mockMvc.perform(get("/api/orders")).andExpect(status().isOk());
    }
}
