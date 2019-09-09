package com.smirnov3308.cinemadb.repository;

import com.smirnov3308.cinemadb.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
        List<Movie> findByTitle(String title);
}