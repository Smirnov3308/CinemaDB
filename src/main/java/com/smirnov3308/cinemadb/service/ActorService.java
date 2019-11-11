package com.smirnov3308.cinemadb.service;

import com.smirnov3308.cinemadb.domain.Actor;
import com.smirnov3308.cinemadb.exception.ActorNotFoundException;
import com.smirnov3308.cinemadb.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    @Autowired
    public ActorRepository repository;

    @Value("${downgradeRate}")
    Long downgradeRate;

    public List<Actor> findAll() {
        List<Actor> allActors = repository.findAll();

        for (Actor actor : allActors) {
            updateRating(actor);
        }
        return allActors;
    }

    public int save(Actor newActor) {
        newActor.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return repository.save(newActor);
    }

    public int deleteById(Long id) {
        return repository.deleteById(id);
    }

    public Actor findById(Long id) throws ActorNotFoundException {
        Optional<Actor> optionalActor = repository.findById(id);
        Actor actor = optionalActor.orElseThrow(() -> new ActorNotFoundException(id));
        updateRating(actor);
        if (actor.getRating() < 10)
            actor.incrementRating();
        actor.setTimestamp(new Timestamp(System.currentTimeMillis()));
        repository.update(actor);
        return actor;
    }

    private Actor updateRating(Actor actor) {
        if (actor.getTimestamp() != null) {
            Long time = System.currentTimeMillis() - actor.getTimestamp().getTime();
            int numberOfDowngrades = (int) (time / (downgradeRate * 60 * 1000));
            int newRating = actor.getRating() - numberOfDowngrades;
            if (newRating < 0)
                newRating = 0;
            actor.setRating(newRating);
        } else
            actor.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return actor;
    }

    public int setMovie(Long actorId, Long movieId) {
        return repository.setMovie(actorId, movieId);
    }

    public List<Actor> findByGenre(String genre) {
        return repository.findByGenre(genre);
    }
}
