package com.ivansousa.urlshortenerservice.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "url")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @EqualsAndHashCode.Include
    @Column(name = "url", nullable = false, unique = false, columnDefinition = "TEXT")
    private String url;

    @Column(name = "shortened", nullable = false, unique = false)
    private long shortened = 0L;

    @Column(name = "accessed", nullable = false, unique = false)
    private long accessed = 0L;
}
