package com.ivansousa.urlshortenerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class UrlShortenerServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerServiceApplication.class, args);
	}
}
