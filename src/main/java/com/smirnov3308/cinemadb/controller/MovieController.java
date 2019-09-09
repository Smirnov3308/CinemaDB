package com.smirnov3308.cinemadb.controller;

import com.smirnov3308.cinemadb.domain.Director;
import com.smirnov3308.cinemadb.domain.Genre;
import com.smirnov3308.cinemadb.domain.Movie;
import com.smirnov3308.cinemadb.repository.DirectorRepository;
import com.smirnov3308.cinemadb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/movie")
@PreAuthorize("hasAuthority('ADMIN')")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping
    public String movie(@RequestParam(required = false, defaultValue = "") String filter, Model model) {

        Iterable<Movie> movies = movieRepository.findAll();

        if (filter != null && !filter.isEmpty()) {
            movies = movieRepository.findByTitle(filter);
        } else {
            movies = movieRepository.findAll();
        }

        model.addAttribute("movies", movies);
        model.addAttribute("filter", filter);

        return "movie";
    }


    @PostMapping
    public String add(
            @RequestParam String title, Map<String, Object> model,
            @RequestParam String directorName,
            @RequestParam Integer year,
            @RequestParam String genres,
            @RequestParam String description,
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        Director director = directorRepository.findByName(directorName);
        if (director == null) {
            director = new Director(directorName);
        }

        Movie movie = new Movie(title, director, year, description);
        directorRepository.save(director);

        Set<String> allGenres = Arrays.stream(Genre.values())
                .map(Genre::name)
                .collect(Collectors.toSet());

        for (String genre : allGenres) {
            if (genres.toLowerCase().contains(genre)) {
                movie.getGenres().add(Genre.valueOf(genre));
            }
        }

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            movie.setFilename(resultFilename);
        }

        directorRepository.save(director);
        movieRepository.save(movie);

        Iterable<Movie> movies = movieRepository.findAll();
        model.put("movies", movies);
        return "movie";
    }
}
