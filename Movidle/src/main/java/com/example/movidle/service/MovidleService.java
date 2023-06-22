package com.example.movidle.service;

import java.util.HashMap;
import java.util.Map;

import com.example.movidle.model.Movie;

public interface MovidleService {
    
    public Movie selectRandomMovie();

    public int[] checkGuessingMovie(Movie guessedMovie, Movie selectedMovie);

    public Movie getMovieWithTitle(String title);

}
