package com.smirnov3308.cinemadb.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "director_id")
    private Director director;

    private Integer year;

    @ElementCollection(targetClass = Genre.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movie_id"))
    @Enumerated(EnumType.STRING)
    private Set<Genre> genres = new HashSet<>();

    @Column(columnDefinition="LONGTEXT")
    private String description;

    private String filename;

    public Movie(String title, Director director, Integer year, String description) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.description = description;
    }

    public String getDirectorName() {
        return director.getName();
    }

    public Movie() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
