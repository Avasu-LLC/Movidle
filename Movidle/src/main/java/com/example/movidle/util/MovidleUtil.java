package com.example.movidle.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.movidle.model.Movie;

public class MovidleUtil {
    
    public static List<Movie> readMovies() {
        String path = "Movidle\\src\\main\\resources\\com\\example\\movidle\\files\\imdb_top_250_3.csv";
        String line = "";
        String[] values;
        List<Movie> movies = new ArrayList<>();
        

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                if(line.startsWith("No")){
                    continue;
                }
                values = line.split(";");

                int no = Integer.parseInt(values[0]);
                String title = values[1];
                int year = Integer.parseInt(values[2]);
                String genre = values[3];
                String origin = values[4];
                String director = values[5];
                String star = values[6];
                
                movies.add(new Movie(title, year, genre, origin, director, star,no));
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;

    }
}
