/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golfscorecalculator;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author CCannon
 */
public class GolfScoreCalculator extends Application {
    
    private GridPane robotDesignGridPane;
    private RankingVBox robotDesignVBox;
    private RankingVBox mechanicalDesignVBox;
    private RankingVBox softwareVBox;
    private RankingVBox strategyAndInnovationVBox;
    private Label robotDesignLabel;
    private HBox robotDesignRadioButtonHBox;
    private ToggleGroup robotDesignToggleGroup;
    private RadioButton robotDesignOverallRadioButton;
    private RadioButton robotDesignCategoryRadioButton;
    
    private GridPane projectGridPane;
    private RankingVBox projectVBox;
    private RankingVBox researchVBox;
    private RankingVBox innovativeSolutionVBox;
    private RankingVBox presentationVBox;
    private Label projectLabel;
    private HBox projectRadioButtonHBox;
    private ToggleGroup projectToggleGroup;
    private RadioButton projectOverallRadioButton;
    private RadioButton projectCategoryRadioButton;
    
    private GridPane coreValuesGridPane;
    private RankingVBox coreValuesVBox;
    private RankingVBox inspirationVBox;
    private RankingVBox teamworkVBox;
    private RankingVBox graciousProfessionalismVBox;
    private Label coreValuesLabel;
    private HBox coreValuesRadioButtonHBox;
    private ToggleGroup coreValuesToggleGroup;
    private RadioButton coreValuesOverallRadioButton;
    private RadioButton coreValuesCategoryRadioButton;
    
    @Override
    public void start(Stage primaryStage) {
        ToggleHandler toggleHandler = new ToggleHandler();
        
        robotDesignGridPane = new GridPane();
        robotDesignVBox = new RankingVBox("");
        mechanicalDesignVBox = new RankingVBox("Mechanical Deign");
        softwareVBox = new RankingVBox("Software");
        strategyAndInnovationVBox = new RankingVBox("Strategy & Innovation");
        robotDesignLabel = new Label("Robot Design");
        robotDesignRadioButtonHBox = new HBox();
        robotDesignToggleGroup = new ToggleGroup();
        robotDesignToggleGroup.selectedToggleProperty().addListener(toggleHandler);
        robotDesignOverallRadioButton = new RadioButton("Overall");
        robotDesignOverallRadioButton.setToggleGroup(robotDesignToggleGroup);
        robotDesignCategoryRadioButton = new RadioButton("Categories");
        robotDesignCategoryRadioButton.setSelected(true);
        robotDesignCategoryRadioButton.setToggleGroup(robotDesignToggleGroup);
        robotDesignRadioButtonHBox.getChildren().addAll(robotDesignOverallRadioButton, robotDesignCategoryRadioButton);
        GridPane.setColumnSpan(robotDesignRadioButtonHBox, 4);
        robotDesignGridPane.add(robotDesignLabel, 0, 0);
        robotDesignGridPane.add(robotDesignRadioButtonHBox, 0, 1);
        robotDesignGridPane.add(robotDesignVBox, 0, 2);
        robotDesignGridPane.add(mechanicalDesignVBox, 1, 2);
        robotDesignGridPane.add(softwareVBox, 2, 2);
        robotDesignGridPane.add(strategyAndInnovationVBox, 3, 2);
        
        projectGridPane = new GridPane();
        projectVBox = new RankingVBox("");
        researchVBox = new RankingVBox("Research");
        innovativeSolutionVBox = new RankingVBox("Innovative Solution");
        presentationVBox = new RankingVBox("Presentation");
        projectLabel = new Label("Project");
        projectRadioButtonHBox = new HBox();
        projectToggleGroup = new ToggleGroup();
        projectToggleGroup.selectedToggleProperty().addListener(toggleHandler);
        projectOverallRadioButton = new RadioButton("Overall");
        projectOverallRadioButton.setToggleGroup(projectToggleGroup);
        projectCategoryRadioButton = new RadioButton("Categories");
        projectCategoryRadioButton.setSelected(true);
        projectCategoryRadioButton.setToggleGroup(projectToggleGroup);
        projectRadioButtonHBox.getChildren().addAll(projectOverallRadioButton, projectCategoryRadioButton);
        GridPane.setColumnSpan(projectRadioButtonHBox, 4);
        projectGridPane.add(projectLabel, 0, 0);
        projectGridPane.add(projectRadioButtonHBox, 0, 1);
        projectGridPane.add(projectVBox, 0, 2);
        projectGridPane.add(researchVBox, 1, 2);
        projectGridPane.add(innovativeSolutionVBox, 2, 2);
        projectGridPane.add(presentationVBox, 3, 2);       
        
        coreValuesGridPane = new GridPane();
        coreValuesVBox = new RankingVBox("");
        inspirationVBox = new RankingVBox("Inspiration");
        teamworkVBox = new RankingVBox("Teamwork");
        graciousProfessionalismVBox = new RankingVBox("Gracious Professionalism");
        coreValuesLabel = new Label("Project");
        coreValuesRadioButtonHBox = new HBox();
        coreValuesToggleGroup = new ToggleGroup();
        coreValuesToggleGroup.selectedToggleProperty().addListener(toggleHandler);
        coreValuesOverallRadioButton = new RadioButton("Overall");
        coreValuesOverallRadioButton.setToggleGroup(coreValuesToggleGroup);
        coreValuesCategoryRadioButton = new RadioButton("Categories");
        coreValuesCategoryRadioButton.setSelected(true);
        coreValuesCategoryRadioButton.setToggleGroup(coreValuesToggleGroup);
        coreValuesRadioButtonHBox.getChildren().addAll(coreValuesOverallRadioButton, coreValuesCategoryRadioButton);
        GridPane.setColumnSpan(coreValuesRadioButtonHBox, 4);
        coreValuesGridPane.add(coreValuesLabel, 0, 0);
        coreValuesGridPane.add(coreValuesRadioButtonHBox, 0, 1);
        coreValuesGridPane.add(coreValuesVBox, 0, 2);
        coreValuesGridPane.add(inspirationVBox, 1, 2);
        coreValuesGridPane.add(teamworkVBox, 2, 2);
        coreValuesGridPane.add(graciousProfessionalismVBox, 3, 2);
        
        updateRankingVBoxVisibility();
        
        HBox rankingHBox = new HBox();
        rankingHBox.getChildren().addAll(robotDesignGridPane, projectGridPane, coreValuesGridPane);
        
        HBox commandHBox = new HBox();
        Button calculateButton = new Button("Calculate");
        Button exitButton = new Button("Exit");
        commandHBox.getChildren().addAll(calculateButton, exitButton);
        
        BorderPane root = new BorderPane();
        root.setCenter(rankingHBox);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void updateRankingVBoxVisibility() {
        if(robotDesignOverallRadioButton.isSelected()) {
            robotDesignVBox.setVisible(true);
            mechanicalDesignVBox.setVisible(false);
            softwareVBox.setVisible(false);
            strategyAndInnovationVBox.setVisible(false);
        }else {
            robotDesignVBox.setVisible(false);
            mechanicalDesignVBox.setVisible(true);
            softwareVBox.setVisible(true);
            strategyAndInnovationVBox.setVisible(true);
        }
        
        if(projectOverallRadioButton.isSelected()) {
            projectVBox.setVisible(true);
            researchVBox.setVisible(false);
            innovativeSolutionVBox.setVisible(false);
            presentationVBox.setVisible(false);
        } else {
            projectVBox.setVisible(false);
            researchVBox.setVisible(true);
            innovativeSolutionVBox.setVisible(true);
            presentationVBox.setVisible(true);
        }
        
        if(coreValuesOverallRadioButton.isSelected()) {
            coreValuesVBox.setVisible(true);
            inspirationVBox.setVisible(false);
            teamworkVBox.setVisible(false);
            graciousProfessionalismVBox.setVisible(false);
        } else {
            coreValuesVBox.setVisible(false);
            inspirationVBox.setVisible(true);
            teamworkVBox.setVisible(true);
            graciousProfessionalismVBox.setVisible(true);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private class ToggleHandler implements ChangeListener<Toggle> {
        
        @Override
        public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
            updateRankingVBoxVisibility();
        }
        
    }
    
    private class CommandButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Button pressed = (Button) event.getSource();
            if(pressed.getText().equals("Calculate")) {
                //TODO: Make the magic happen
            } else if(pressed.getText().equals("Exit")) {
                System.exit(0);
            }
        }
        
    }
}
