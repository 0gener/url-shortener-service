package com.ivansousa.urlshortenerservice.controller;

import java.net.URL;

import com.ivansousa.urlshortenerservice.controller.model.GetUrlStatisticsResponse;
import com.ivansousa.urlshortenerservice.persistence.model.Url;
import com.ivansousa.urlshortenerservice.service.UrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/statistics")
public class StatisticsController {
    @Autowired
    public UrlService service;

    @GetMapping(produces = "application/json")
    public GetUrlStatisticsResponse getUrlStatistics(@RequestParam("url") URL str) {
        Url url = service.getUrl(str);

        if (url == null) {
            return new GetUrlStatisticsResponse(0L, 0L);
        }

        return new GetUrlStatisticsResponse(url.getShortened(), url.getAccessed());
    }
}
