package com.smirnov3308.cinemadb.controller;

import com.smirnov3308.cinemadb.domain.Actor;
import com.smirnov3308.cinemadb.exception.ActorNotFoundException;
import com.smirnov3308.cinemadb.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("permitAll()")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/actors")
    List<Actor> findAll() {
        return actorService.findAll();
    }

    @PostMapping("/actors")
    int newActor(@RequestBody Actor newActor) {
        return actorService.save(newActor);
    }

    @GetMapping("/actors/{id}")
    Actor one(@PathVariable Long id) throws ActorNotFoundException {
        return actorService.findById(id);
    }

    @PostMapping("/actors/{id}")
    int setMovie(@PathVariable Long id, @RequestParam(required = true) Long movieId) {
        return actorService.setMovie(id, movieId);
    }

    @GetMapping("/actors/delete/{id}")
    int delete(@PathVariable Long id) {
        return actorService.deleteById(id);
    }

    @GetMapping("/actors/")
    List<Actor> findByGenre(@RequestParam(required = true) String genre) {
        return actorService.findByGenre(genre);
    }
}
