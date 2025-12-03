package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;

public class S2024891252 extends Application {
    @Override
    public void start(Stage stage) {
        PieChart pieChart = new PieChart();
        pieChart.getData().addAll(
            new PieChart.Data("Java", 40),  
            new PieChart.Data("Python", 30), 
            new PieChart.Data("C++", 20)      
        );

        Scene scene = new Scene(pieChart, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Pie Chart Demo");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}