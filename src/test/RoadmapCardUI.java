package test;


import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RoadmapCardUI extends VBox {

 private Button actionButton;

 public RoadmapCardUI(String durationText,
                      String phaseTitle,
                      String descriptionText) {

     super(10); // spacing
     setPadding(new Insets(20));
     setStyle(
         "-fx-background-color: white;" +
         "-fx-background-radius: 18;" +
         "-fx-border-radius: 18;" +
         "-fx-border-color: #e5e7eb;"
     );
     setPrefWidth(500);

     // top: duration pill
     Label durationLabel = new Label(durationText);
     durationLabel.setStyle(
         "-fx-background-color: #eff6ff;" +
         "-fx-text-fill: #2563eb;" +
         "-fx-font-size: 12px;" +
         "-fx-font-weight: bold;" +
         "-fx-padding: 4 10 4 10;" +
         "-fx-background-radius: 999;"
     );

     // phase title
     Label phaseLabel = new Label(phaseTitle);
     phaseLabel.setStyle(
         "-fx-font-size: 18px;" +
         "-fx-font-weight: bold;" +
         "-fx-text-fill: #111827;"
     );

     // description
     Label descLabel = new Label(descriptionText);
     descLabel.setWrapText(true);
     descLabel.setStyle("-fx-text-fill: #4b5563; -fx-font-size: 13px;");

     // button
     actionButton = new Button("Mark as Learned");
     actionButton.setMaxWidth(Double.MAX_VALUE);
     actionButton.setStyle(
         "-fx-background-color: white;" +
         "-fx-border-color: #cbd5e1;" +
         "-fx-text-fill: #0f172a;" +
         "-fx-padding: 8 10 8 10;" +
         "-fx-background-radius: 10;" +
         "-fx-border-radius: 10;"
     );

     // spacer to give some margin between description and button
     Region spacer = new Region();
     spacer.setPrefHeight(10);

     getChildren().addAll(durationLabel, phaseLabel, descLabel, spacer, actionButton);
 }

 public Button getActionButton() {
     return actionButton;
 }

 // simple method to visually mark completion
 public void setCompleted() {
     actionButton.setText("Completed");
     actionButton.setDisable(true);
     actionButton.setStyle(
         "-fx-background-color: #e5e7eb;" +
         "-fx-border-color: #cbd5e1;" +
         "-fx-text-fill: #6b7280;" +
         "-fx-padding: 8 10 8 10;" +
         "-fx-background-radius: 10;" +
         "-fx-border-radius: 10;"
     );
 }
}
