package com.ivansousa.urlshortenerservice.controller.model;

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
    private String id;
}
