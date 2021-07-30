package com.ivansousa.urlshortenerservice.controller;

import static org.mockito.Mockito.when;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivansousa.urlshortenerservice.persistence.model.Url;
import com.ivansousa.urlshortenerservice.service.UrlService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(UrlController.class)
public class UrlControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UrlService service;

    @Test
    public void createShorterUrl_ValidBody_Created() throws Exception {
        Map<String, String> request = new HashMap<>();
        request.put("url", "https://google.com");

        when(service.createShorterUrl(new URL(request.get("url")))).thenReturn("1");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/url").content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void createShorterUrl_InvalidBody_BadRequest() throws Exception {
        Map<String, String> request = new HashMap<>();

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/url").content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void createShorterUrl_InvalidUrl_BadRequest() throws Exception {
        Map<String, String> request = new HashMap<>();
        request.put("url", "123456");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/url").content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void redirectUrl() throws Exception {
        String url = "https://google.com";

        when(service.getUrlById("1")).thenReturn(new Url(url));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/url/1")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.redirectedUrl(url));

    }
}
