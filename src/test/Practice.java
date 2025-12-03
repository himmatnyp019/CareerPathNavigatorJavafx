package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Practice extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        Label label = new Label("Hello, JavaFX!"); 
        Button button = new Button("Click Me!");
        Button button2 = new Button("New Button !");
        ImageView img1 = new ImageView();
        ImageView img2 = new ImageView();
        ImageView img3 = new ImageView();
        ImageView img4 = new ImageView();

        
        // image path
       Image imgPath1 = new Image("file:src/resources/flower.jpg",true);
        img1.setImage(imgPath1);
        Image imgPath2 = new Image("file:src/resources/flower.jpg", 100, 250, false, false);
        img2.setImage(imgPath2);
        Image imgPath3 = new Image("file:src/resources/flower.jpg",true);
        img3.setImage(imgPath3);
        Image imgPath4 = new Image("file:src/resources/flower.jpg", 300, 200, false, false);
        img4.setImage(imgPath4);
        
        
        // Set button action
        button.setOnAction(e -> {
            label.setText("Button Clicked!");
        });
        
        //button2 oClick action
        button2.setOnAction(e ->{
        	label.setText("Button2 is clicked");
        });

        // Create layout
        HBox layout = new HBox(10); // 10 pixels spacing,
        layout.getChildren().addAll(label, button, button2);
        
     
        
        HBox imageContainer = new HBox(10);
        layout.getChildren().addAll(img1, img2,img3,img4);

        
        VBox root = new VBox(10);
        root.getChildren().addAll(layout, imageContainer);
        
        // Create scene
        Scene scene = new Scene(root, 1200, 800);

        // Set up stage
        primaryStage.setTitle("My First JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
