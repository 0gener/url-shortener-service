package com.ivansousa.urlshortenerservice.controller.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class CreateShorterUrlResponse {
    @NonNull
    @Schema(description = "id of shortened url")
    private String id;
}
