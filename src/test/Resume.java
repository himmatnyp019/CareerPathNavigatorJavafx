package test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Resume extends Application {

    @Override
    public void start(Stage primaryStage) {
        // ---------- Navbar ----------
        Image icon = new Image("file:src/resources/icon.png");
        ImageView iconView = new ImageView(icon);
        iconView.setFitWidth(40);
        iconView.setFitHeight(40);
        iconView.setPreserveRatio(true);

        Label title = new Label("My JavaFX Portfolio");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        title.setTextFill(Color.web("#2C3E50"));

        HBox navbar = new HBox(10);
        navbar.setPadding(new Insets(15, 30, 15, 30));
        navbar.setStyle("-fx-background-color: linear-gradient(to right, #E6F0FF, #FFFFFF);"
                + "-fx-border-color: #DCE6F5; -fx-border-width: 0 0 1 0;");
        navbar.setAlignment(Pos.CENTER_LEFT); 
        navbar.getChildren().addAll(iconView, title);

        // ---------- Hero Section ----------
        Image heroImage = new Image("file:src/resources/Boy fight.jpg");
        ImageView heroImageView = new ImageView(heroImage);
        heroImageView.setFitWidth(220);
        heroImageView.setPreserveRatio(true);
        heroImageView.setStyle("-fx-effect: dropshadow(two-pass-box, rgba(0,0,0,0.2), 10, 0, 4, 4);");

        Label name = new Label("Himmat Neupane");
        name.setFont(Font.font("Segoe UI", FontWeight.BOLD, 28));
        name.setTextFill(Color.web("#1A237E"));

        Label bio = new Label(
            "I’m a passionate Full Stack Developer skilled in building modern web "
          + "and mobile applications using React, Node.js, Express, MongoDB, and Firebase.\n\n"
          + "I love designing systems that look clean, perform fast, and scale efficiently."
        );
        bio.setFont(Font.font("Segoe UI", 14));
        bio.setWrapText(true);
        bio.setTextFill(Color.web("#34495E"));

        Button resumeBtn = new Button("View Resume");
        resumeBtn.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 14));
        resumeBtn.setStyle("-fx-background-color: #1E88E5; -fx-text-fill: white; "
                + "-fx-background-radius: 8; -fx-padding: 8 20 8 20;");
        resumeBtn.setOnAction(e -> System.out.println("Opening Resume..."));

        VBox heroText = new VBox(15);
        heroText.getChildren().addAll(name, bio, resumeBtn);
        heroText.setAlignment(Pos.CENTER_LEFT);

        HBox heroLayout = new HBox(40);
        heroLayout.setAlignment(Pos.CENTER);
        heroLayout.setPadding(new Insets(50, 40, 50, 40));
        heroLayout.getChildren().addAll(heroImageView, heroText);

        // ---------- Root Layout ----------
        BorderPane root = new BorderPane();
        root.setTop(navbar);
        root.setCenter(heroLayout);
        root.setStyle("-fx-background-color: #F7FAFF;");

        // ---------- Scene + Stage ----------
        Scene scene = new Scene(root, 900, 500);
        primaryStage.setTitle("My JavaFX Portfolio");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
