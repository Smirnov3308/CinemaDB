package com.smirnov3308.cinemadb.repository;

import com.smirnov3308.cinemadb.domain.Actor;
import com.smirnov3308.cinemadb.domain.Genre;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ActorRepository {
    int save(Actor actor);

    int update(Actor actor);

    int deleteById(Long id);

    int setMovie(Long actorId, Long movieId);

    List<Actor> findAll();

    List<Actor> findByGenre(String genre);

    String getNameById(Long id);

    Optional<Actor> findById(Long id);
}
