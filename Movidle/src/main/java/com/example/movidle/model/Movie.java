package com.example.movidle.model;



public class Movie {
    private String title;
    private String year;
    private String imdbID;
    private String type;

    public Movie(String title, String year, String imdbID, String type) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
    }
    
}
