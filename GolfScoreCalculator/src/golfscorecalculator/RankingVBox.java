/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golfscorecalculator;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author CCannon
 */
public class RankingVBox extends VBox {
    private static final int NUM_STARTING_TEAMS = 10;
    
    private Label rankingCategoryLabel;
    private GridPane teamGridPane;
    private Button addTeamButton;
    private Button removeTeamButton;
    
    private ArrayList<String> teams;
    private int numTeamFields;
    
    public RankingVBox(String category) {
        teams = new ArrayList<>();
        numTeamFields = 0;
        
        this.rankingCategoryLabel = new Label(category);
        this.getChildren().add(rankingCategoryLabel);
        
        teamGridPane = new GridPane();
        for(int i = 0; i < NUM_STARTING_TEAMS; i ++) {
            TextField newTextField = new TextField();
            teamGridPane.add(newTextField, 0, i);
            numTeamFields++;
        }
        teamGridPane.setVgap(10.0);
        this.getChildren().add(teamGridPane);
        
        addTeamButton = new Button("Add Team");
        removeTeamButton = new Button("Remove Team");
        this.getChildren().add(addTeamButton);
        this.getChildren().add(removeTeamButton);
        
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setSpacing(10.0);
    }
}
