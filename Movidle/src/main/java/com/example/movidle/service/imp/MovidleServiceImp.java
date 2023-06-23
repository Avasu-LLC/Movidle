package com.example.movidle.service.imp;

import java.util.List;
import com.example.movidle.model.Movie;
import com.example.movidle.service.MovidleService;
import com.example.movidle.util.MovidleUtil;

public class MovidleServiceImp implements MovidleService {

    private List<Movie> movies;

    private Movie selectedMovie = null;

    private int heart = 5;

    // when user guess the movie and if it is wrong, heart will be decrease by 1
    @Override
    public int decreaseHeart() {
        --this.heart;
        System.out.println("heart: " + this.heart);
        return this.heart;
    }

    @Override
    public Movie getMovieWithTitle(String title) {
        for (Movie movie : movies) {
            System.out.println(movie.getTitle());
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie selectRandomMovie() {
        movies = MovidleUtil.readMovies();

        int random = (int) (Math.random() * this.movies.size());
        selectedMovie = this.movies.get(random);

        return selectedMovie;
    }

    @Override
    public int[] checkGuessingMovie(Movie guessedMovie, Movie selectedMovie) {

        int[] equelOrNotList = new int[6];
        // compare guessed movie with selected movie
        if (guessedMovie != null) {
            if (guessedMovie.getTitle().equals(selectedMovie.getTitle())) {
                equelOrNotList[0] = 1;
            } else {
                equelOrNotList[0] = 0;
            }
            if (guessedMovie.getYear() == selectedMovie.getYear()) {
                equelOrNotList[1] = 1;
            } else {
                equelOrNotList[1] = 0;
            }
            if (guessedMovie.getGenre().equals(selectedMovie.getGenre())) {
                equelOrNotList[2] = 1;
            } else {
                equelOrNotList[2] = 0;
            }
            if (guessedMovie.getOrigin().equals(selectedMovie.getOrigin())) {
                equelOrNotList[3] = 1;
            } else {
                equelOrNotList[3] = 0;
            }
            if (guessedMovie.getDirector().equals(selectedMovie.getDirector())) {
                equelOrNotList[4] = 1;
            } else {
                equelOrNotList[4] = 0;
            }
            if (guessedMovie.getStar().equals(selectedMovie.getStar())) {
                equelOrNotList[5] = 1;
            } else {
                equelOrNotList[5] = 0;
            }
            // set equelOrNotList to guessedMovie

            return equelOrNotList;
        }

        return null;
    }

}
