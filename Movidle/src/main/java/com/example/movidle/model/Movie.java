package com.example.movidle.model;



public class Movie {
    private int no;
    private String title;
    private int year;
    private String genre;
    private String origin;
    private String director;
    private String star;

    
    public Movie(String title, int year, String genre, String origin, String director, String star, int no) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.origin = origin;
        this.director = director;
        this.star = star;
        this.no = no;
    }

    public Movie(){

    }
    public int getNo() {
        return this.no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getYear() {
        return this.year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getGenre() {
        return this.genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getOrigin() {
        return this.origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getDirector() {
        return this.director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getStar() {
        return this.star;
    }
    public void setStar(String star) {
        this.star = star;
    }

   
    
}
