package com.smirnov3308.cinemadb.controller;

import com.smirnov3308.cinemadb.domain.Movie;
import com.smirnov3308.cinemadb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String movie(@RequestParam(required = false, defaultValue = "") String filter, Model model) {

        Iterable<Movie> movies = movieRepository.findAll();

        if (filter != null && !filter.isEmpty()) {
            movies = movieRepository.findByTitle(filter);
        } else {
            movies = movieRepository.findAll();
        }

        model.addAttribute("movies", movies);
        model.addAttribute("filter", filter);

        return "main";
    }
}