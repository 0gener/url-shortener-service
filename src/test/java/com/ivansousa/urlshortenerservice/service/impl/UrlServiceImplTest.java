package com.ivansousa.urlshortenerservice.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URL;
import java.util.Optional;

import com.ivansousa.urlshortenerservice.persistence.model.Url;
import com.ivansousa.urlshortenerservice.persistence.repository.UrlRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class UrlServiceImplTest {
    private UrlServiceImpl service;

    @MockBean
    private UrlRepository urlRepository;

    @BeforeEach
    public void setUp() {
        service = new UrlServiceImpl(urlRepository);

        Url urlExists = new Url("https://google.com");
        urlExists.setId(1L);

        Url urlDoesntExist = new Url("https://stackoverflow.com");
        urlDoesntExist.setId(1L);

        Mockito.when(urlRepository.findByUrl(urlExists.getUrl())).thenReturn(Optional.of(urlExists));
        Mockito.when(urlRepository.findById(urlExists.getId())).thenReturn(Optional.of(urlExists));
        Mockito.when(urlRepository.save(urlExists)).thenReturn(urlDoesntExist);

        Mockito.when(urlRepository.findByUrl("https://stackoverflow.com")).thenReturn(Optional.empty());
        Mockito.when(urlRepository.findById(999L)).thenReturn(Optional.empty());
        Mockito.when(urlRepository.save(urlDoesntExist)).thenReturn(urlDoesntExist);
    }

    @Test
    public void createShorterUrl_UrlExists_ReturnsId() throws Exception {
        URL url = new URL("https://google.com");
        String id = service.createShorterUrl(url);

        assertEquals("1", id);
    }

    @Test
    public void createShorterUrl_UrlDoenstExist_ReturnsId() throws Exception {
        URL url = new URL("https://stackoverflow.com");
        String id = service.createShorterUrl(url);

        assertEquals("1", id);
    }

    @Test
    public void getUrlById_IdExists_ReturnsValidUrl() throws Exception {
        Url url = service.getUrlById("1");

        assertNotNull(url);
        assertEquals(1L, url.getId());
        assertEquals("https://google.com", url.getUrl());
    }

    @Test
    public void getUrlById_IdDoesntExist_ThrowsNullPointerException() throws Exception {
        assertThrows(NullPointerException.class, () -> service.getUrlById("999"));
    }

    @Test
    public void getUrl_UrlExists_ReturnsValidUrl() throws Exception {
        URL url = new URL("https://google.com");
        Url dbUrl = service.getUrl(url);

        assertNotNull(dbUrl);
        assertEquals(1L, dbUrl.getId());
        assertEquals(url.toString(), dbUrl.getUrl());
    }

    @Test
    public void getUrl_UrlDoesntExist_ReturnsNull() throws Exception {
        URL url = new URL("https://stackoverflow.com");
        Url dbUrl = service.getUrl(url);

        assertEquals(null, dbUrl);
    }
}
