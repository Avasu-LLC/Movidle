package com.example.movidle.controller;

import com.example.movidle.model.Movie;
import com.example.movidle.service.MovidleService;
import com.example.movidle.service.imp.MovidleServiceImp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class MovidleController {

    private MovidleService movidleService ;

    private Movie selectedMovie;

    private int rowHbox = 0;


    @FXML
    private VBox guessContainer;

    @FXML
    private TextField guessTextField;

    //constructor
    public MovidleController() {
     startGame();

    }

    @FXML
    private void guessButtonAction() {
        String guess = this.guessTextField.getText();
        this.guessTextField.setText("");
        Movie guessedMovie = movidleService.getMovieWithTitle(guess);
        if(guessedMovie == null){
            System.out.println("guessedMovie is null");
            return;
        }
        int[] equelOrNotList = movidleService.checkGuessingMovie(guessedMovie,selectedMovie);
        
        //check equelOrNotList is null or not null
        if(equelOrNotList == null){
            System.out.println("equelOrNotList is null");
            return;
        }
        System.out.println(equelOrNotList[0] + " " + equelOrNotList[1] + " " + equelOrNotList[2] + " " + equelOrNotList[3] + " " + equelOrNotList[4] + " " + equelOrNotList[5] );
        

        HBox row = new HBox(10.0); // Yeni bir satır oluştur

        for (int i = 0; i < 6; i++) {
            Rectangle guessBox = new Rectangle(150, 150,equelOrNotList[i] == 1 ? Color.GREEN : Color.RED );
            Text text = null;
            switch(i){
                case 0:
                    text = new Text(guessedMovie.getTitle());
                    break;
                case 1:
                    text = new Text(Integer.toString(guessedMovie.getYear()));
                    break;
                case 2:
                    text = new Text(guessedMovie.getGenre());
                    break;
                case 3:
                    text = new Text(guessedMovie.getOrigin());
                    break;
                case 4:
                    text = new Text(guessedMovie.getDirector());
                    break;
                case 5:
                    text = new Text(guessedMovie.getStar());
                    break;
                
                
            }
           

            StackPane stackPane = new StackPane(guessBox,text);
            row.getChildren().add(stackPane);
            this.rowHbox= this.rowHbox + 1;
        }

        this.guessContainer.getChildren().add(0,row); // New row is added to the top of the container

        //if all guess is true then show the selected movie
        for(int i = 0; i < equelOrNotList.length; i++){
            if(equelOrNotList[i] == 0){
                if(movidleService.decreaseHeart()==0){
                        restartButtonAction("Your haven't any heart!");
                }
                break;
            }
            if(i == equelOrNotList.length - 1){
                restartButtonAction("Congralition, You Win!");
            }
        }
        //if heart is 0 then show the selected movie 
        

    }

   

    public void restartButtonAction(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("INFO");
        alert.setContentText(message);

        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        ButtonType restartButton = new ButtonType("Restart");

        alert.getButtonTypes().setAll(restartButton);

        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == restartButton) {
                // Restart the game
                guessContainer.getChildren().clear();
                startGame();
            }
        });
    }

    //start or restart the game
    public void startGame(){
        movidleService = new MovidleServiceImp();
        this.selectedMovie = movidleService.selectRandomMovie();
        
        System.out.println("movie: " + selectedMovie.getTitle());
    }







    

 
    
}