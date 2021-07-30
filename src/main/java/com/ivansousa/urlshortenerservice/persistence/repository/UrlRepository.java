package com.ivansousa.urlshortenerservice.persistence.repository;

import com.ivansousa.urlshortenerservice.persistence.model.Url;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

}
