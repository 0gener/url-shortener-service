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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "URL")
@RequestMapping(path = "/url")
public class UrlController {
    @Autowired
    public UrlService service;

    @Operation(summary = "Create a shorter version of a URL")
    @ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = CreateShorterUrlResponse.class)))
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<CreateShorterUrlResponse> createShorterUrl(@Valid @RequestBody CreateShorterUrlRequest body) {
        String id = service.createShorterUrl(body.getUrl());

        return new ResponseEntity<CreateShorterUrlResponse>(new CreateShorterUrlResponse(id), HttpStatus.CREATED);
    }

    @Operation(summary = "Redirect to original URL")
    @ApiResponse(responseCode = "302", description = "Succesfully redirected to original URL", content = @Content)
    @GetMapping(path = "/{id}")
    public RedirectView redirectUrl(@PathVariable("id") String id) {
        String originalUrl = service.getUrlById(id).getUrl();

        return new RedirectView(originalUrl);
    }
}
