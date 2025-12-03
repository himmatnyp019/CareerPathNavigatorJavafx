package test;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Intern extends Application {

    @Override
    public void start(Stage primaryStage) {

        // -------- ROOT LAYOUT --------
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f3f4ff;");  

        // -------- navbar   --------
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
        
        // -------- MAIN CARD (big box) --------
        VBox mainCard = new VBox(20);
        mainCard.setPadding(new Insets(30));
        mainCard.setStyle(
            "-fx-background-color: white;" +
            "-fx-background-radius: 20;" +
            "-fx-border-radius: 20;" +
            "-fx-border-color: #e5e7eb;"
        );

        // ======= HEADER TEXT =======
        Label title = new Label("Internship Opportunity");
        title.setStyle(
            "-fx-font-size: 28px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #111827;"
        );

        Label subtitle = new Label("You have completed your theoretical studies. Now apply them in the real world.");
        subtitle.setWrapText(true);
        subtitle.setStyle(
            "-fx-font-size: 13px;" +
            "-fx-text-fill: #e5e7eb;"     // light text on dark in original; here still soft
        );

        // we will keep text darker for readability on light background:
        subtitle.setStyle(
            "-fx-font-size: 13px;" +
            "-fx-text-fill: #6b7280;"
        );

        // container for title and subtitle
        VBox headerBox = new VBox(5);
        headerBox.getChildren().addAll(title, subtitle);

        // ======= INNER CARD (company + tasks) =======
        VBox innerCard = new VBox(16);
        innerCard.setPadding(new Insets(20));
        innerCard.setStyle(
            "-fx-background-color: #111827;" + // dark inner card like screenshot
            "-fx-background-radius: 18;" +
            "-fx-border-radius: 18;"
        );

        // --- top row: company logo + texts ---
        HBox companyRow = new HBox(12);
        companyRow.setAlignment(Pos.CENTER_LEFT);

        Label logoBox = new Label("P");
        logoBox.setPrefSize(48, 48);
        logoBox.setAlignment(Pos.CENTER);
        logoBox.setStyle(
            "-fx-background-color: white;" +
            "-fx-text-fill: #111827;" +
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 12;"
        );

        VBox companyTextBox = new VBox(3);

        Label roleLabel = new Label("Gameplay Scripter Intern");
        roleLabel.setStyle(
            "-fx-text-fill: white;" +
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;"
        );

        Label companyLabel = new Label("at PixelForge Games");
        companyLabel.setStyle(
            "-fx-text-fill: #9ca3af;" +
            "-fx-font-size: 12px;"
        );

        Label assignedTitle = new Label("ASSIGNED TASKS");
        assignedTitle.setStyle(
            "-fx-text-fill: #9ca3af;" +
            "-fx-font-size: 11px;" +
            "-fx-font-weight: bold;"
        );

        companyTextBox.getChildren().addAll(roleLabel, companyLabel, assignedTitle);

        companyRow.getChildren().addAll(logoBox, companyTextBox);

        // --- task list ---
        VBox taskList = new VBox(10);

        taskList.getChildren().add(createTaskRow("Implement character movement"));
        taskList.getChildren().add(createTaskRow("Create basic enemy AI"));
        taskList.getChildren().add(createTaskRow("Debug collision detection"));

        innerCard.getChildren().addAll(companyRow, taskList);

        // ======= BOTTOM BUTTON =======
        Button completeButton = new Button("Complete Internship & Generate Resume");
        completeButton.setMaxWidth(Double.MAX_VALUE);
        completeButton.setStyle(
            "-fx-background-color: white;" +
            "-fx-text-fill: #111827;" +
            "-fx-font-size: 14px;" +
            "-fx-font-weight: bold;" +
            "-fx-padding: 12 16 12 16;" +
            "-fx-background-radius: 20;" +
            "-fx-border-radius: 20;" +
            "-fx-border-color: #e5e7eb;"
        );

        // small wrapper for centering the button inside mainCard
        HBox buttonWrapper = new HBox();
        buttonWrapper.setAlignment(Pos.CENTER);
        buttonWrapper.setPadding(new Insets(10, 0, 0, 0));
        buttonWrapper.getChildren().add(completeButton);

        // add all to main card
        mainCard.getChildren().addAll(headerBox, innerCard, buttonWrapper);

        // center main card in the window
        HBox centerWrapper = new HBox();
        centerWrapper.setAlignment(Pos.CENTER);
        centerWrapper.getChildren().add(mainCard);

        root.setCenter(centerWrapper);

        // -------- SCENE & STAGE --------
        Scene scene = new Scene(root, 900, 550);
        primaryStage.setTitle("Internship Opportunity");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // helper to create one task row with a green check circle and text
    private HBox createTaskRow(String text) {
        HBox row = new HBox(10);
        row.setAlignment(Pos.CENTER_LEFT);

        Label checkCircle = new Label("✓");
        checkCircle.setPrefSize(24, 24);
        checkCircle.setAlignment(Pos.CENTER);
        checkCircle.setStyle(
            "-fx-background-color: #16a34a;" +  // green
            "-fx-text-fill: white;" +
            "-fx-background-radius: 12;" +
            "-fx-font-size: 12px;"
        );

        Label taskLabel = new Label(text);
        taskLabel.setStyle(
            "-fx-text-fill: #e5e7eb;" +
            "-fx-font-size: 13px;"
        );

        row.getChildren().addAll(checkCircle, taskLabel);
        return row;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
