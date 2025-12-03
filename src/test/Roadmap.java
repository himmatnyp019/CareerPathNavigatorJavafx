package test;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Roadmap extends Application {

 // --- simple module data holder templete for an object var ModuleInfo ---
 static class ModuleInfo {
     String duration;
     String phase;
     String description;

     ModuleInfo(String duration, String phase, String description) {
         this.duration = duration;
         this.phase = phase;
         this.description = description;
     }
 }

 // pretend this is “Game Developer” roadmap
 private ModuleInfo[] modules = {
     new ModuleInfo("Weeks 1-6", "Core Logic", "C# or C++ Programming Fundamentals"),
     new ModuleInfo("Weeks 7-14", "Engine Basics", "Unity interface, game loop, prefabs, scenes"),
     new ModuleInfo("Weeks 15-20", "Math & Physics", "Vectors, collisions, rigidbodies, movement"),
     new ModuleInfo("Weeks 21-28", "Polish & UX", "UI systems, audio, effects, optimization")
 };

 private int currentIndex = 0;
 private Label progressLabel;
 private VBox contentBox;

 @Override
 public void start(Stage primaryStage) {

     BorderPane root = new BorderPane();
     root.setPadding(new Insets(20));
     root.setStyle("-fx-background-color: #f3f4ff;");

     // ---------------- NAVBAR (this is reusable style idea) ----------------
     HBox navbar = new HBox(10);
     navbar.setAlignment(Pos.CENTER_LEFT);
     navbar.setPadding(new Insets(10, 0, 20, 0));

     Label navIcon = new Label("⏹");
     navIcon.setStyle(
         "-fx-background-color: #2563eb;" +
         "-fx-text-fill: white;" +
         "-fx-font-size: 18px;" +
         "-fx-padding: 8;" +
         "-fx-background-radius: 12;"
     );

     Label navText1 = new Label("Careerpath");
     navText1.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: black;");

     Label navText2 = new Label("Navigator");
     navText2.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #2563eb;");

     navbar.getChildren().addAll(navIcon, navText1, navText2);
     root.setTop(navbar);

     // ---------------- HEADER CARD (career title and student and progress) ----------------
     VBox headerCard = new VBox(4);
     headerCard.setPadding(new Insets(16));
     headerCard.setStyle(
         "-fx-background-color: white;" +
         "-fx-background-radius: 18;" +
         "-fx-border-radius: 18;" +
         "-fx-border-color: #e5e7eb;"
     );

     HBox headerRow = new HBox(12);
     headerRow.setAlignment(Pos.CENTER_LEFT);

     Label pulseIcon = new Label("〰");
     pulseIcon.setStyle(
         "-fx-background-color: #ecfdf5;" +
         "-fx-text-fill: #22c55e;" +
         "-fx-font-size: 18px;" +
         "-fx-padding: 8;" +
         "-fx-background-radius: 14;"
     );

     VBox headerTextBox = new VBox(2);
     Label careerTitleLabel = new Label("Game Developer Roadmap");
     careerTitleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #111827;");

     Label studentLabel = new Label("Student: himmat");
     studentLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: #6b7280;");

     headerTextBox.getChildren().addAll(careerTitleLabel, studentLabel);

     Region headerSpacer = new Region();
     HBox.setHgrow(headerSpacer, javafx.scene.layout.Priority.ALWAYS);

     progressLabel = new Label("Progress: 0%");
     progressLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: #2563eb; -fx-font-weight: bold;");

     headerRow.getChildren().addAll(pulseIcon, headerTextBox, headerSpacer, progressLabel);
     headerCard.getChildren().add(headerRow);

     // ---------------- THE BODY: Education title and cards container ----------------
     VBox bodyBox = new VBox(16);
     bodyBox.setPadding(new Insets(20, 0, 0, 0));

     HBox eduTitleRow = new HBox(8);
     eduTitleRow.setAlignment(Pos.CENTER_LEFT);

     Label bookIcon = new Label("📘");
     bookIcon.setStyle("-fx-text-fill: #2563eb; -fx-font-size: 18px;");

     Label eduTitle = new Label("Educational Requirements");
     eduTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #111827;");

     eduTitleRow.getChildren().addAll(bookIcon, eduTitle);

     contentBox = new VBox(16);

     bodyBox.getChildren().addAll(eduTitleRow, contentBox);

     
     
  // ---------------- CENTER CONTENT (everything related to content is here) ----------------

     VBox centerBox = new VBox(20);
     centerBox.setPadding(new Insets(0, 10, 20, 10));
     centerBox.getChildren().addAll(headerCard, bodyBox);

     // ---- creating scroll pane to scroll and find the other elements ----
     ScrollPane scroll = new ScrollPane();
     scroll.setContent(centerBox);

     // makes scroll area width match window
     scroll.setFitToWidth(true);

     // always show vertical scrollbar
     scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

     // remove ugly background
     scroll.setStyle("-fx-background-color: transparent;");

     root.setCenter(scroll);

     // show first module card
     showNextModule();

     Scene scene = new Scene(root, 900, 600);
     primaryStage.setTitle("CareerpathNavigator - Roadmap");
     primaryStage.setScene(scene);
     primaryStage.show();
 }

 private void showNextModule() {
     if (currentIndex >= modules.length) {
         // all done: progress 100 and show internship button
         updateProgress();
         Button internshipButton = new Button("Proceed to Internship Stage");
         internshipButton.setStyle(
             "-fx-background-color: #2563eb;" +
             "-fx-text-fill: white;" +
             "-fx-font-size: 14px;" +
             "-fx-font-weight: bold;" +
             "-fx-padding: 10 16 10 16;" +
             "-fx-background-radius: 10;"
         );
         contentBox.getChildren().add(internshipButton);
         return;
     }

     ModuleInfo info = modules[currentIndex];

     RoadmapCardUI card = new RoadmapCardUI(
         info.duration,
         info.phase,
         info.description
     );

     // attach button action
     card.getActionButton().setOnAction(e -> {
         card.setCompleted();
         currentIndex++;
         updateProgress();
         showNextModule(); // show next card under this one
     });

     contentBox.getChildren().add(card);
 }

 private void updateProgress() {
     int total = modules.length;
     int completed = Math.min(currentIndex, total);
     int percent = (int) ((completed * 100.0) / total);
     progressLabel.setText("Progress: " + percent + "%");
 }

 public static void main(String[] args) {
     launch(args);
 }
}
