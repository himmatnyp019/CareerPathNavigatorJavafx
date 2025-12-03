package test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Resume extends Application {

    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));
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
        
        // ===== success banner =====
        HBox banner = new HBox();
        banner.setAlignment(Pos.CENTER);
        banner.setPadding(new Insets(20));
        banner.setStyle(
            "-fx-background-color: #22c55e;" +
            "-fx-background-radius: 14;"
        );
        Label bannerText = new Label("You are ready for your career!");
        bannerText.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: white;"
        );
        banner.getChildren().add(bannerText);

        // ===== main resume card =====
        VBox resumeCard = new VBox(20);
        resumeCard.setPadding(new Insets(30));
        resumeCard.setStyle(
            "-fx-background-color: white;" +
            "-fx-background-radius: 10;" +
            "-fx-border-radius: 10;" +
            "-fx-border-color: #e5e7eb;"
        );

        // header row
        HBox headerRow = new HBox();
        headerRow.setAlignment(Pos.CENTER_LEFT);

        Label title = new Label("User name");
        title.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #111827;");

        Region space = new Region();
        HBox.setHgrow(space, Priority.ALWAYS);

        Button printBtn = new Button("Print / PDF");
        printBtn.setStyle(
            "-fx-background-color: #e5e7eb;" +
            "-fx-text-fill: #111827;" +
            "-fx-padding: 6 12 6 12;" +
            "-fx-background-radius: 6;" +
            "-fx-border-radius: 6;"
        );

        headerRow.getChildren().addAll(title, space, printBtn);

        // small info row
        HBox smallInfo = new HBox(20);
        smallInfo.setAlignment(Pos.CENTER_LEFT);

        Label role = new Label("Game Developer");
        role.setStyle("-fx-text-fill: #6b7280;");

        Label email = new Label("candidate@email.com");
        email.setStyle("-fx-text-fill: #6b7280;");

        Label link = new Label("linkedin.com/in/career");
        link.setStyle("-fx-text-fill: #6b7280;");

        smallInfo.getChildren().addAll(role, email, link);

        // divider
        Region line1 = new Region();
        line1.setPrefHeight(1);
        line1.setStyle("-fx-background-color: #111827;");

        // ===== PROFESSIONAL SUMMARY =====
        VBox summaryBox = new VBox(10);
        Label summaryTitle = new Label("PROFESSIONAL SUMMARY");
        summaryTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #111827;");
        Label summaryText = new Label(
            "Highly motivated and trained Game Developer with a strong foundation in C++ / C# "
          + "and Unity / Unreal. Recently completed a rigorous educational track and a "
          + "practical internship at PixelForge Games. Passionate about creating immersive 3D "
          + "worlds and gameplay mechanics."
        );
        summaryText.setWrapText(true);
        summaryText.setStyle("-fx-text-fill: #4b5563;");
        summaryBox.getChildren().addAll(summaryTitle, summaryText);

        // ===== EXPERIENCE =====
        VBox expBox = new VBox(10);
        Label expTitle = new Label("EXPERIENCE");
        expTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #111827;");
        Label expRole = new Label("Gameplay Scripter Intern");
        expRole.setStyle("-fx-font-weight: bold; -fx-text-fill: #111827;");
        Label expCompany = new Label("PixelForge Games");
        expCompany.setStyle("-fx-font-style: italic; -fx-text-fill: #6b7280;");

        VBox taskList = new VBox(5);
        taskList.getChildren().add(buildBullet("Implement character movement"));
        taskList.getChildren().add(buildBullet("Create basic enemy AI"));
        taskList.getChildren().add(buildBullet("Debug collision detection"));

        expBox.getChildren().addAll(expTitle, expRole, expCompany, taskList);

        // ===== EDUCATION =====
        VBox eduBox = new VBox(10);
        Label eduTitle = new Label("EDUCATION");
        eduTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #111827;");
        Label eduInst = new Label("CareerArchitect Intensive Track");
        eduInst.setStyle("-fx-font-weight: bold; -fx-text-fill: #111827;");
        Label eduSpec = new Label("Specialization: Game Developer");
        eduSpec.setStyle("-fx-text-fill: #6b7280;");

        HBox tagRow = new HBox(8);
        tagRow.getChildren().add(makeTag("Core Logic"));
        tagRow.getChildren().add(makeTag("Engine Basics"));
        tagRow.getChildren().add(makeTag("Math & Physics"));
        tagRow.getChildren().add(makeTag("Polish"));

        eduBox.getChildren().addAll(eduTitle, eduInst, eduSpec, tagRow);

        // ===== RIGHT COLUMN: skills + tools =====
        VBox sideBox = new VBox(20);
        sideBox.setPrefWidth(220);                // fixed, narrow right column

        Label skillTitle = new Label("TECHNICAL SKILLS");
        skillTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #111827;");

        VBox skillTags = new VBox(6);
        skillTags.getChildren().add(makeTag("C++ / C#"));
        skillTags.getChildren().add(makeTag("Unity / Unreal"));
        skillTags.getChildren().add(makeTag("3D Math"));
        skillTags.getChildren().add(makeTag("Physics"));
        skillTags.getChildren().add(makeTag("Shaders"));

        Label toolsTitle = new Label("TOOLS");
        toolsTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #111827;");

        VBox toolsList = new VBox(4);
        toolsList.getChildren().add(makePlain("VS Code"));
        toolsList.getChildren().add(makePlain("Git & GitHub"));
        toolsList.getChildren().add(makePlain("Jira"));
        toolsList.getChildren().add(makePlain("Figma"));

        sideBox.getChildren().addAll(skillTitle, skillTags, toolsTitle, toolsList);

        // ===== LEFT COLUMN (gets most of the width) =====
        VBox leftColumn = new VBox(20);
        leftColumn.getChildren().addAll(headerRow, smallInfo, line1, summaryBox, expBox, eduBox);
        leftColumn.setPrefWidth(600);              // give it a good base width
        HBox.setHgrow(leftColumn, Priority.ALWAYS); // let it expand when window grows

        // ===== BOTH COLUMNS TOGETHER =====
        HBox mainContent = new HBox(40);
        mainContent.getChildren().addAll(leftColumn, sideBox);

        resumeCard.getChildren().add(mainContent);

        VBox fullLayout = new VBox(20);
        fullLayout.getChildren().addAll(banner, resumeCard);

        root.setCenter(fullLayout);

        Scene scene = new Scene(root, 1100, 700);  // a bit wider to breathe
        stage.setTitle("Resume Screen");
        stage.setScene(scene);
        stage.show();
    }

    private HBox buildBullet(String text) {
        HBox row = new HBox(8);
        Label bullet = new Label("\u2022");
        Label label = new Label(text);
        label.setStyle("-fx-text-fill: #4b5563;");
        row.getChildren().addAll(bullet, label);
        return row;
    }

    private Label makeTag(String text) {
        Label tag = new Label(text);
        tag.setStyle(
            "-fx-background-color: #e5e7eb;" +
            "-fx-text-fill: #374151;" +
            "-fx-padding: 4 8 4 8;" +
            "-fx-background-radius: 6;"
        );
        return tag;
    }

    private Label makePlain(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-text-fill: #4b5563;");
        return label;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
