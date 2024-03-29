package com.example.startadnavce.service;

import com.example.startadnavce.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie createMovie(Movie movie);

    Movie updateMovie(int id, Movie movie);

    void deleteMovie(int id);

}
