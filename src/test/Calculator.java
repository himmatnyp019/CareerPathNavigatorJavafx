package test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {
    
    private TextField display;
    private String currentInput = "";
    private double result = 0;
    private String lastOperation = "";
    
    @Override
    public void start(Stage primaryStage) {
        // Create display
        display = new TextField();
        display.setEditable(false);
        display.setStyle("-fx-font-size: 18; -fx-text-fill: black;");
        display.setPrefHeight(50);
        
        // Create buttons
        String[][] buttonLabels = {
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"0", "C", "=", "+"}
        };
        
        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(5);
        buttonGrid.setVgap(5);
        buttonGrid.setPadding(new Insets(10));
        
        // Add buttons to grid
        for (int row = 0; row < buttonLabels.length; row++) {
            for (int col = 0; col < buttonLabels[row].length; col++) {
                Button button = createButton(buttonLabels[row][col]);
                buttonGrid.add(button, col, row);
            }
        }
        
        // Create main layout
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(15));
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.getChildren().addAll(display, buttonGrid);
        
        // Create scene
        Scene scene = new Scene(mainLayout, 300, 400);
        
        // Set up stage
        primaryStage.setTitle("JavaFX Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(60, 60);
        button.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");
        
        button.setOnAction(e -> handleButtonClick(text));
        
        return button;
    }
    
    private void handleButtonClick(String text) {
        switch (text) {
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
                currentInput += text;
                display.setText(currentInput);
                break;
                
            case "+": case "-": case "*": case "/":
                if (!currentInput.isEmpty()) {
                    result = Double.parseDouble(currentInput);
                    lastOperation = text;
                    currentInput = "";
                }
                break;
                
            case "=":
                if (!currentInput.isEmpty() && !lastOperation.isEmpty()) {
                    double secondOperand = Double.parseDouble(currentInput);
                    switch (lastOperation) {
                        case "+": result += secondOperand; break;
                        case "-": result -= secondOperand; break;
                        case "*": result *= secondOperand; break;
                        case "/": 
                            if (secondOperand != 0) {
                                result /= secondOperand;
                            } else {
                                display.setText("Error");
                                return;
                            }
                            break;
                    }
                    display.setText(String.valueOf(result));
                    currentInput = "";
                    lastOperation = "";
                }
                break;
                
            case "C":
                currentInput = "";
                result = 0;
                lastOperation = "";
                display.setText("");
                break;
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}