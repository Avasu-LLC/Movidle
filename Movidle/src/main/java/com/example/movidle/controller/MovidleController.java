package com.example.movidle.controller;

import com.example.movidle.model.Movie;
import com.example.movidle.service.MovidleService;
import com.example.movidle.service.imp.MovieServiceImp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MovidleController {

    private MovieServiceImp movieServiceImp;

    private int rowHbox = 0;

    @FXML
    private VBox guessContainer;

    @FXML
    private TextField guessTextField;

    @FXML
    private void guessButtonAction() {
        HBox row = new HBox(10.0); // Yeni bir satır oluştur

        for (int i = 0; i < 5; i++) {
            Rectangle guessBox = new Rectangle(150, 150, Color.GREEN);
            Text text = new Text(Integer.toString(this.rowHbox));

            StackPane stackPane = new StackPane(guessBox,text);
            row.getChildren().add(stackPane);
            this.rowHbox= this.rowHbox + 1;
        }

        this.guessContainer.getChildren().add(0,row); // Yeni satırı guessContainer'a ekle
    }

    @FXML
    private void restartButtonAction() {

    }
}