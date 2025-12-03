
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Mockup extends Application {
    
    // Temporary database using ObservableList
    private ObservableList<String> temporaryDatabase = FXCollections.observableArrayList();
    private ListView<String> displayList = new ListView<>();
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Text Saver");
        
        // Create UI components
        Label titleLabel = new Label("Enter text to save:");
        TextField textField = new TextField();
        textField.setPromptText("Type something here...");
        
        Button saveButton = new Button("Save Text");
        Button clearButton = new Button("Clear All");
        
        // Style the buttons
        saveButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        clearButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
        
        // Set up the display list
        displayList.setItems(temporaryDatabase);
        displayList.setPrefHeight(200);
        
        // Button actions
        saveButton.setOnAction(e -> saveText(textField.getText()));
        clearButton.setOnAction(e -> clearDatabase());
        
        // Allow saving by pressing Enter in text field
        textField.setOnAction(e -> saveText(textField.getText()));
        
        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(
            titleLabel, textField, saveButton, displayList, clearButton
        );
        
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void saveText(String text) {
        if (text != null && !text.trim().isEmpty()) {
            temporaryDatabase.add(text.trim());
            // Clear the text field after saving
            ((TextField)((VBox)displayList.getParent()).getChildren().get(1)).clear();
            showAlert("Success", "Text saved successfully!");
        } else {
            showAlert("Error", "Please enter some text!");
        }
    }
    
    private void clearDatabase() {
        temporaryDatabase.clear();
        showAlert("Cleared", "All data has been cleared!");
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}