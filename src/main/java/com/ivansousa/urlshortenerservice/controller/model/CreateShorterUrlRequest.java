package com.ivansousa.urlshortenerservice.controller.model;

import java.net.URL;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateShorterUrlRequest {
    @NotNull
    private URL url;
}
