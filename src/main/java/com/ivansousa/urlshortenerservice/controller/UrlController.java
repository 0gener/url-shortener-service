package com.ivansousa.urlshortenerservice.controller;

import javax.validation.Valid;

import com.ivansousa.urlshortenerservice.controller.model.CreateShorterUrlRequest;
import com.ivansousa.urlshortenerservice.controller.model.CreateShorterUrlResponse;
import com.ivansousa.urlshortenerservice.service.UrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping(path = "/url")
public class UrlController {
    @Autowired
    public UrlService service;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<CreateShorterUrlResponse> createShorterUrl(@Valid @RequestBody CreateShorterUrlRequest body) {
        String id = service.createShorterUrl(body.getUrl());

        return new ResponseEntity<CreateShorterUrlResponse>(new CreateShorterUrlResponse(id), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public RedirectView redirectUrl(@PathVariable("id") String id) {
        String originalUrl = service.getUrlById(id).getUrl();

        return new RedirectView(originalUrl);
    }
}
