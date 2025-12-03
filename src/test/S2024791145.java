package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*; // * means it imports all within this library
import javafx.stage.Stage;

public class S2024791145 extends Application {
    @Override
    public void start(Stage stage) {
    	
        Circle circle = new Circle(50, 50, 30, Color.RED);

        
        Rectangle rect = new Rectangle(100, 30, 60, 40);
        rect.setFill(Color.BLUE);

        Pane root = new Pane(circle, rect);
        Scene scene = new Scene(root, 200, 150);
        stage.setScene(scene);
        stage.setTitle("Shapes Demo");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}