package test;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class CardUI extends VBox {

 public CardUI(String title,
               String salary,
               String description,
               String[] skills,
               String icon,
               String iconBg,
               String iconColor) {

     super(10); //this is  vertical spacing betn hbox vbox
     setPadding(new Insets(20)); //this set the padding inside the container
     setPrefWidth(420);
     setStyle(
         "-fx-background-color: white;" +
         "-fx-background-radius: 18;" +
         "-fx-border-radius: 18;" +
         "-fx-border-color: #e5e7eb;" +
         "-fx-effect: dropshadow(gaussian, rgba(15,23,42,0.06), 12, 0, 0, 4);"
     );

     // -------- top row (icon and salary pill) --------
     HBox top = new HBox(10);
     top.setAlignment(Pos.CENTER_LEFT);

     Label iconLabel = new Label(icon);
     iconLabel.setStyle(
         "-fx-background-color: " + iconBg + ";" +
         "-fx-text-fill: " + iconColor + ";" +
         "-fx-font-size: 20px;" +
         "-fx-padding: 10;" +
         "-fx-background-radius: 16;"
     );

     Region spacer = new Region();
     HBox.setHgrow(spacer, javafx.scene.layout.Priority.ALWAYS);

     Label salaryLabel = new Label(salary);
     salaryLabel.setStyle(
         "-fx-background-color: #dcfce7;" +
         "-fx-text-fill: #16a34a;" +
         "-fx-font-weight: bold;" +
         "-fx-font-size: 12px;" +
         "-fx-padding: 6 12 6 12;" +
         "-fx-background-radius: 999;"
     );

     top.getChildren().addAll(iconLabel, spacer, salaryLabel);

     // -------- text content --------
     Label titleLabel = new Label(title);
     titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #111827;");

     Label descLabel = new Label(description);
     descLabel.setWrapText(true);
     descLabel.setStyle("-fx-text-fill: #6b7280; -fx-font-size: 13px;");

     // divider line
     Region line = new Region();
     line.setPrefHeight(1);
     line.setStyle("-fx-background-color: #e5e7eb;");

     Label ksLabel = new Label("KEY SKILLS");
     ksLabel.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #9ca3af;");

     // this is skills row
     HBox skillBox = new HBox(8);
     skillBox.setPadding(new Insets(4, 0, 0, 0));

     for (String s : skills) {
         Label tag = new Label(s);
         if (s.startsWith("+")) {
             tag.setStyle("-fx-text-fill: #9ca3af; -fx-font-size: 11px;");
         } else {
             tag.setStyle(
                 "-fx-background-color: #f3f4f6;" +
                 "-fx-text-fill: #4b5563;" +
                 "-fx-font-size: 11px;" +
                 "-fx-padding: 5 8 5 8;" +
                 "-fx-background-radius: 8;"
             );
         }
         skillBox.getChildren().add(tag);
     }

     // adding everything in main container
     getChildren().addAll(top, titleLabel, descLabel, line, ksLabel, skillBox);
 }
}
