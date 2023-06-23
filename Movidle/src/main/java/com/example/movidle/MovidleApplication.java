package com.example.movidle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.movidle.model.Movie;
import com.example.movidle.service.MovidleService;
import com.example.movidle.service.imp.MovidleServiceImp;

/**
 * @author Shamkhal Huseynzade
 * @author Ali Asim Bulut
 */

public class MovidleApplication extends Application {



    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MovidleApplication.class.getResource("view/index.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        //set disable resize
        stage.setResizable(false);
        stage.setTitle("Movidle");
        stage.setScene(scene);
        stage.show();
        

        
    }

    public static void main(String[] args) {
        launch();
        

        
    }
}