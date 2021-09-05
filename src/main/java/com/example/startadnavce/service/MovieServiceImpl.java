package com.example.startadnavce.service;

import com.example.startadnavce.dao.MovieDao;
import com.example.startadnavce.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
private  MovieDao movieDao;
    @Override
    public List<Movie> getAllMovies() {
        return movieDao.findAll();
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieDao.saveAndFlush(movie);
    }

    @Override
    public Movie updateMovie(int id, Movie movie) {
       movie.setId(id);
      if( !movieDao.existsById(id)) {
          throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no movie found");
      }
        return movieDao.saveAndFlush(movie);
    }

    @Override
    public void deleteMovie(int id) {
        if( !movieDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no movie found");
        }
        movieDao.deleteById(id);
    }
}
