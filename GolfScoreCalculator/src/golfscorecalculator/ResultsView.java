/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golfscorecalculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author CCannon
 */
public class ResultsView extends Stage{
    public ResultsView(ArrayList<Team> results) {
        Label titleLabel = new Label("Golf Score Results");
        VBox resultsVBox = new VBox();
        
        saveResults(results);
        
        for(Team result : results) {
            resultsVBox.getChildren().add(new Label("Team: " + result.getTeamNumber() + " Score: " + result.getScore()));
        }
        
        BorderPane root = new BorderPane();
        root.setTop(titleLabel);
        root.setCenter(resultsVBox);
        
        Scene scene = new Scene(root, 200, 600);
        
        this.setTitle("Golf Score Calculator");
        this.setScene(scene);
        this.show();
    }
    
    private void saveResults(ArrayList<Team> results) {
        FileChooser fileChooser = new FileChooser();
        
        File selectedFile = fileChooser.showSaveDialog(null);
        if(selectedFile != null) {
            try {
                PrintWriter printWriter = new PrintWriter(selectedFile);
                for(Team team : results) {
                    printWriter.println(team.getTeamNumber() + ": " + team.getScore());
                }
                printWriter.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GolfScoreCalculator.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.println("Save file selection cancelled");
        }
    }
}
