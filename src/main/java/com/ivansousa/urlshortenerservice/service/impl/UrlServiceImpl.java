package com.ivansousa.urlshortenerservice.service.impl;

import java.net.URL;

import com.ivansousa.urlshortenerservice.persistence.model.Url;
import com.ivansousa.urlshortenerservice.persistence.repository.UrlRepository;
import com.ivansousa.urlshortenerservice.service.UrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {
    @Autowired
    private UrlRepository urlRepository;

    @Override
    public String createShorterUrl(URL reqUrl) {
        return null;
    }

    @Override
    public Url getUrlById(String id) {
        return null;
    }

    @Override
    public Url getUrl(URL url) {
        return null;
    }
}
