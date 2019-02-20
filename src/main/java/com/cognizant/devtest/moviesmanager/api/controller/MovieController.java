package com.cognizant.devtest.moviesmanager.api.controller;

//import com.cognizant.devtest.moviesmanager.domain.entity.Movie;
//import com.cognizant.devtest.moviesmanager.domain.repository.MovieRepository;
import com.cognizant.devtest.moviesmanager.domain.entity.Movie;
import com.cognizant.devtest.moviesmanager.domain.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

/*
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Void> deleteMovieById() throws Exception {

        //movieRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
*/
@Autowired

private MovieRepository movieRepository;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Movie addMovie(@RequestBody Movie movie) throws Exception {

        Movie newMovie = movieRepository.save(movie);

        return movieRepository.findById(newMovie.getId()).orElseThrow(() -> new Exception("movie not found"));
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public Movie modifyMovie(@RequestBody Movie movie) throws Exception {

        Movie modifiedMovie = movieRepository.save(movie);

        return movieRepository.findById(modifiedMovie.getId()).orElseThrow(() -> new Exception("movie not found"));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public Movie getMovieById(@PathVariable("id") final Long id) throws Exception {

        Movie movie = movieRepository.findById(id).orElseThrow(() -> new Exception("movie not found"));

        return movie;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Void> deleteMovieById(@PathVariable("id") final Long id) throws Exception {

        movieRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Movie> getAllMovies() {

        return movieRepository.findAll();

    }

}
