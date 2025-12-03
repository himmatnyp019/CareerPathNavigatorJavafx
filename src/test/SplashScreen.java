package test;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SplashScreen {

    private final Stage stage;

    public SplashScreen(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        Label title = new Label("Tic Tac Toe");
        title.setFont(Font.font(32));

        Label rules = new Label(
                "Rules:\n" +
                "1. Player X starts.\n" +
                "2. Players take turns tapping a cell.\n" +
                "3. First to get 3 in a row wins.\n" +
                "4. If board is full, it's a draw."
        );
        rules.setWrapText(true);

        Button playBtn = new Button("Play Now");
        playBtn.setPrefWidth(150);

        // Go to game screen
        playBtn.setOnAction(e -> {
            TicTacToeGame game = new TicTacToeGame(stage, this);
            game.show();
        });

        VBox root = new VBox(15, title, rules, playBtn);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setMinWidth(400);
        root.setMinHeight(400);

        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Tic Tac Toe - Splash");
        stage.setScene(scene);
        stage.show();
    }
}
