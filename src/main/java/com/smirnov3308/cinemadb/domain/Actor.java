package com.smirnov3308.cinemadb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Actor {
    private Integer id;
    private String name;
    private Integer rating;
    @JsonIgnore
    private Timestamp timestamp;
    private Set<Movie> movies = new HashSet<>();

    public Actor() {
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Actor(Integer id, String name, Integer rating, Timestamp timestamp) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void incrementRating() {
        this.rating += 1;
    }
}
