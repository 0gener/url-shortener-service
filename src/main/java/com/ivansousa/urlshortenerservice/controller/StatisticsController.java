package com.ivansousa.urlshortenerservice.controller;

import java.net.URL;

import com.ivansousa.urlshortenerservice.controller.model.GetUrlStatisticsResponse;
import com.ivansousa.urlshortenerservice.persistence.model.Url;
import com.ivansousa.urlshortenerservice.service.UrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Statistics")
@RequestMapping(path = "/statistics")
public class StatisticsController {
    @Autowired
    public UrlService service;

    @Operation(summary = "Get statistics for a specific URL")
    @GetMapping(produces = "application/json")
    public ResponseEntity<GetUrlStatisticsResponse> getUrlStatistics(@RequestParam("url") URL str) {
        Url url = service.getUrl(str);

        GetUrlStatisticsResponse responseEntity;
        if (url == null) {
            responseEntity = new GetUrlStatisticsResponse(0L, 0L);
        } else {
            responseEntity = new GetUrlStatisticsResponse(url.getShortened(), url.getAccessed());
        }

        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }
}
