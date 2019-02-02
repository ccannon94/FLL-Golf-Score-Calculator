/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golfscorecalculator;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    
    private ArrayList<TextField> teamFields;
    
    public RankingVBox(String category) {
        teamFields = new ArrayList<>();
        
        this.rankingCategoryLabel = new Label(category);
        this.getChildren().add(rankingCategoryLabel);
        
        teamGridPane = new GridPane();
        for(int i = 0; i < NUM_STARTING_TEAMS; i ++) {
            TextField newTextField = new TextField();
            teamGridPane.add(newTextField, 0, i);
            teamFields.add(newTextField);
        }
        teamGridPane.setVgap(10.0);
        this.getChildren().add(teamGridPane);
        
        addTeamButton = new Button("Add Team");
        removeTeamButton = new Button("Remove Team");
        ButtonHandler buttonHandler = new ButtonHandler();
        addTeamButton.setOnAction(buttonHandler);
        removeTeamButton.setOnAction(buttonHandler);
        this.getChildren().add(addTeamButton);
        this.getChildren().add(removeTeamButton);
        
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setSpacing(10.0);
    }
    
    public int getNumTeamFields() {
        return teamFields.size();
    }
    
    public TextField getTeamField(int index) {
        return teamFields.get(index);
    }
    
    public void setNumTeamFields(int numFields) {
        teamFields.clear();
        teamGridPane.getChildren().clear();
        for(int i = 0; i < numFields; i ++) {
            TextField newTextField = new TextField();
            teamGridPane.add(newTextField, 0, i);
            teamFields.add(newTextField);
        }
    }
    
    public String toString() {
        String outputString = "";
        
        for(int i = 0; i < teamFields.size(); i++) {
            if(i < teamFields.size() - 1) {
                outputString += teamFields.get(i).getText() + ",";
            } else {
                outputString += teamFields.get(i).getText();
            }
        }
        
        return outputString;
    }
    
    private class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Button pressed = (Button) event.getSource();
            if(pressed.getText().equals("Add Team")) {
                TextField newTextField = new TextField();
                teamGridPane.add(newTextField, 0, teamFields.size());
                teamFields.add(newTextField);
            }else if(pressed.getText().equals("Remove Team")) {
                teamGridPane.getChildren().remove(teamFields.size() - 1);
                teamFields.remove(teamFields.size() - 1);
            }
        }
        
    }
}
