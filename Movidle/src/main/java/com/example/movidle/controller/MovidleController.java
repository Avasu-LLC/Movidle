package com.example.movidle.controller;

import com.example.movidle.model.Movie;
import com.example.movidle.service.MovidleService;
import com.example.movidle.service.imp.MovieServiceImp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MovidleController {

    private MovidleService movidleService = new MovidleService();

    private MovieServiceImp movieServiceImp ;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        this.welcomeText.setText("Welcome to JavaFX Application!");
        
       // this.movidleService.readMovieDemo();
        this.movidleService.readMovies();
    }
}