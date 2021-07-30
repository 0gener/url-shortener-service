package com.ivansousa.urlshortenerservice.service.impl;

import java.net.URL;

import com.ivansousa.urlshortenerservice.persistence.model.Url;
import com.ivansousa.urlshortenerservice.persistence.repository.UrlRepository;
import com.ivansousa.urlshortenerservice.service.UrlService;
import com.ivansousa.urlshortenerservice.util.NumberUtils;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UrlServiceImpl implements UrlService {
    private UrlRepository urlRepository;

    @Override
    public String createShorterUrl(URL reqUrl) {
        Url url = urlRepository.findByUrl(reqUrl.toString()).orElse(null);

        if (url == null)
            url = new Url(reqUrl.toString());

        url.setShortened(url.getShortened() + 1);
        url = urlRepository.save(url);

        return NumberUtils.encodeToBase62(url.getId());
    }

    @Override
    public Url getUrlById(String id) {
        Url url = urlRepository.findById(NumberUtils.decodeFromBase62(id)).orElse(null);

        url.setAccessed((url.getAccessed() + 1));
        urlRepository.save(url);

        return url;
    }

    @Override
    public Url getUrl(URL url) {
        return urlRepository.findByUrl(url.toString()).orElse(null);
    }
}
