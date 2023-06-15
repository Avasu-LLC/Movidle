package com.example.movidle.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MovidleController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        this.welcomeText.setText("Welcome to JavaFX Application!");
    }
}