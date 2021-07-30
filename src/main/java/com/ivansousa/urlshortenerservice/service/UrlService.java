package com.ivansousa.urlshortenerservice.service;

import java.net.URL;

import com.ivansousa.urlshortenerservice.persistence.model.Url;

public interface UrlService {
    public String createShorterUrl(URL reqUrl);

    public Url getUrlById(String id);

    public Url getUrl(URL url);
}
