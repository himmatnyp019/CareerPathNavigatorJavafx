package test;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Home extends Application {

 // simple holder for card data (like JS object) this is templete for an arrey object
 static class CardInfo {
     String title;
     String salary;
     String description;
     String[] skills;
     String icon;
     String iconBg;
     String iconColor;

     CardInfo(String title, String salary, String description,
              String[] skills, String icon, String iconBg, String iconColor) {
         this.title = title;
         this.salary = salary;
         this.description = description;
         this.skills = skills;
         this.icon = icon;
         this.iconBg = iconBg;
         this.iconColor = iconColor;
     }
 }

 // array of cards
 private CardInfo[] cards = {
     new CardInfo(
         "Frontend Developer",
         "$70k - $120k",
         "Build beautiful, interactive user interfaces for the web.",
         new String[] { "HTML/CSS", "JavaScript (ES6+)", "React.js", "+3 more" },
         "🌐",
         "#eff6ff",
         "#2563eb"
     ),
     new CardInfo(
         "Game Developer",
         "$65k - $110k",
         "Create immersive 3D worlds and gameplay mechanics.",
         new String[] { "C++ / C#", "Unity or Unreal Engine", "3D Math", "+2 more" },
         "🎮",
         "#f5f3ff",
         "#7c3aed"
     ),
     new CardInfo(
         "Backend Engineer",
         "$80k - $130k",
         "Architect backend systems, APIs and databases.",
         new String[] { "Node.js", "SQL / NoSQL", "APIs", "+3 more" },
         "🗄️",
         "#eef2ff",
         "#4f46e5"
     ),
     new CardInfo(
         "Cyber Security Analyst",
         "$85k - $140k",
         "Protect systems and networks from cyber attacks.",
         new String[] { "Linux", "Networking", "Ethical Hacking", "+2 more" },
         "🛡️",
         "#f0fdf4",
         "#16a34a"
     )
 };

 @Override
 public void start(Stage primaryStage) {

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

     // -------- cards grid (2 columns) --------
     GridPane grid = new GridPane();
     grid.setHgap(20);
     grid.setVgap(20);

     int col = 0;
     int row = 0;

     for (int i = 0; i < cards.length; i++) {
         CardInfo info = cards[i];

         CardUI cardNode = new CardUI(
             info.title,
             info.salary,
             info.description,
             info.skills,
             info.icon,
             info.iconBg,
             info.iconColor
         );

         grid.add(cardNode, col, row);

         col++;
         if (col == 2) {
             col = 0;
             row++;
         }
     }

     root.setCenter(grid);

     Scene scene = new Scene(root, 980, 600);
     primaryStage.setTitle("CareerpathNavigator");
     primaryStage.setScene(scene);
     primaryStage.show();
 }

 public static void main(String[] args) {
     launch(args);
 }
}
