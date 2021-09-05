package com.example.startadnavce.controller;

import com.example.startadnavce.dao.MovieDao;
import com.example.startadnavce.entity.Movie;
import com.example.startadnavce.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
  private  MovieService movieService ;
    @GetMapping(value = "/movie")
    public List<Movie> getMovies(){
        return  movieService.getAllMovies();
    }
    @PostMapping(value = "/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie insertMovie (@RequestBody Movie movie){
        return movieService.createMovie(movie);
    }
    @PutMapping(value = "/movie/{id}")
    @ResponseStatus (HttpStatus.ACCEPTED)
    public Movie updateMovie(@PathVariable int id , @RequestBody Movie movie){
        return movieService.updateMovie(id,movie);
    }
    @DeleteMapping(value = "movie/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
    }
}
