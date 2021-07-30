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
public class GetUrlStatisticsResponse {
    @NonNull
    @Schema(description = "how many times the url was shortened")
    private Long shortened;

    @NonNull
    @Schema(description = "how many times the url was accessed")
    private Long accessed;
}
