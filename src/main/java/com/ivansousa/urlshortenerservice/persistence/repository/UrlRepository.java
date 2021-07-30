package com.ivansousa.urlshortenerservice.persistence.repository;

import java.util.Optional;

import com.ivansousa.urlshortenerservice.persistence.model.Url;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    public Optional<Url> findByUrl(String url);
}
