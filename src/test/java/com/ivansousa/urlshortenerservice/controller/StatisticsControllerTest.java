package com.ivansousa.urlshortenerservice.controller;

import com.ivansousa.urlshortenerservice.service.UrlService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(StatisticsController.class)
public class StatisticsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UrlService service;

    @Test
    public void getUrlStatistics_ValidUrl_Ok() throws Exception {
        String url = "https://google.com";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/statistics").param("url", url))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getUrlStatistics_InvalidUrl_BadRequest() throws Exception {
        String url = "123456";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/statistics").param("url", url))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void getUrlStatistics_NoUrl_BadRequest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/statistics")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
