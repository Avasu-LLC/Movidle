package com.example.movidle.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.movidle.model.Movie;

import javafx.scene.control.TextField;

public interface MovidleService {
    
    public Movie selectRandomMovie();

    public int[] checkGuessingMovie(Movie guessedMovie, Movie selectedMovie);

    public Movie getMovieWithTitle(String title);

    public int decreaseHeart();

    public List<String> autoComplete(TextField guessTextField);

}
