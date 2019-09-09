package com.smirnov3308.cinemadb.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Movie> movies = new HashSet<>();

    public Director(String name) {
        this.name = name;
    }

    public Director() {}

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

    public Set<Movie> getMovies() {
        return movies;
    }

    public void addMovies(Movie movie) {
        this.movies.add(movie);
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
