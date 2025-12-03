package test;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Start with splash screen
        SplashScreen splash = new SplashScreen(primaryStage);
        splash.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
