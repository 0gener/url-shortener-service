package com.ivansousa.urlshortenerservice.persistence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
// @Entity
// @Table(name = "url")
@RedisHash("url")
public class Url {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @EqualsAndHashCode.Include
    // @Column(name = "url", nullable = false, unique = false, columnDefinition =
    // "TEXT")
    private String url;

    // @Column(name = "shortened", nullable = false, unique = false)
    private long shortened = 0L;

    // @Column(name = "accessed", nullable = false, unique = false)
    private long accessed = 0L;
}
