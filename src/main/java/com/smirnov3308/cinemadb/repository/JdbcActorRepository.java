package com.smirnov3308.cinemadb.repository;

import com.smirnov3308.cinemadb.domain.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcActorRepository implements ActorRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Actor actor) {
        return jdbcTemplate.update(
                "insert into actor (name, rating, timestamp) values(?,?,?)",
                actor.getName(), actor.getRating(), actor.getTimestamp());
    }

    @Override
    public int update(Actor actor) {
        return jdbcTemplate.update(
                "update actor set rating = ?, timestamp = ?  where id = ?",
                actor.getRating(), actor.getTimestamp(), actor.getId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete from actor where id = ?",
                id);
    }

    @Override
    public int setMovie(Long actorId, Long movieId) {
        return jdbcTemplate.update(
                "insert into actor_movie (actor_id, movie_id) values(?,?)",
                actorId, movieId);
    }

    @Override
    public List<Actor> findAll() {
        return jdbcTemplate.query(
                "select * from actor",
                (rs, rowNum) ->
                        new Actor(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("rating"),
                                rs.getTimestamp("timestamp")
                        )
        );
    }

    @Override
    public Optional<Actor> findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from actor where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Actor(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("rating"),
                                rs.getTimestamp("timestamp")
                        ))
        );
    }

    @Override
    public List<Actor> findByGenre(String genre) {
        return jdbcTemplate.query(
                "select id, name, rating, timestamp from actor " +
                        "inner join actor_movie on actor.id = actor_movie.actor_id " +
                        "inner join movie_genre on actor_movie.movie_id = movie_genre.movie_id where genres = ?",
                (rs, rowNum) ->
                        new Actor(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("rating"),
                                rs.getTimestamp("timestamp")
                        ),
                genre
        );
    }

    @Override
    public String getNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "select name from actor where id = ?",
                new Object[]{id},
                String.class
        );
    }
}
