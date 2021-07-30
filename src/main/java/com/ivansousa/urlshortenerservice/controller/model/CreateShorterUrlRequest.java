package com.ivansousa.urlshortenerservice.controller.model;

import java.net.URL;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateShorterUrlRequest {
    @NotNull
    @Schema(description = "url to be shortened")
    private URL url;
}
