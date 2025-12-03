package test;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TicTacToeGame {

    private final Stage stage;
    private final SplashScreen splashScreen;

    private Button[][] cells = new Button[3][3];
    private char currentPlayer = 'X';
    private Label statusLabel;

    public TicTacToeGame(Stage stage, SplashScreen splashScreen) {
        this.stage = stage;
        this.splashScreen = splashScreen;
    }

    public void show() {
        // Top: status
        statusLabel = new Label("Player X's turn");
        statusLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        HBox topBox = new HBox(statusLabel);
        topBox.setAlignment(Pos.CENTER);
        topBox.setPadding(new Insets(10));

        // Center: board
        GridPane board = new GridPane();
        board.setAlignment(Pos.CENTER);
        board.setHgap(5);
        board.setVgap(5);
        board.setPadding(new Insets(10));
        String url = "file:///C:/Users/dfss/Documents/JAVA/MyFirstJavaFX/src/resources/button-back.png";

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button cell = new Button("");
                cell.setPrefSize(100, 100);
                cell.setStyle(
                	    "-fx-font-size: 34px;" +
                	    "-fx-background-image: url()"+
                	    "-fx-background-image: url('" + url + "');" +
                	    "-fx-background-repeat: no-repeat;" +
                	    "-fx-background-position: center;"
                	);
                final int r = row;
                final int c = col;
                cell.setOnAction(e -> handleMove(r, c));
                cells[row][col] = cell;
                board.add(cell, col, row);
            }
        }

        // Bottom: buttons
        Button playAgainBtn = new Button("Play Again");
        Button exitBtn = new Button("Exit");

        playAgainBtn.setOnAction(e -> {
            // go back to splash
            splashScreen.show();
        });

        exitBtn.setOnAction(e -> stage.close());

        HBox bottomBox = new HBox(10, playAgainBtn, exitBtn);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(board);
        root.setBottom(bottomBox);

        Scene scene = new Scene(root, 400, 450);
        stage.setTitle("Tic Tac Toe - Game");
        stage.setScene(scene);
        stage.show();
    }

    private void handleMove(int row, int col) {
        Button cell = cells[row][col];
        // if already taken or game over, ignore
        if (!cell.getText().isEmpty() || isGameOver()) {
            return;
        }

        cell.setText(String.valueOf(currentPlayer));

        if (hasPlayerWon(currentPlayer)) {
            statusLabel.setText("Player " + currentPlayer + " wins!");
            disableBoard();
        } else if (isBoardFull()) {
            statusLabel.setText("It's a draw!");
            disableBoard();
        } else {
            // switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            statusLabel.setText("Player " + currentPlayer + "'s turn");
        }
    }

    private boolean hasPlayerWon(char player) {
        // rows
        for (int r = 0; r < 3; r++) {
            if (cells[r][0].getText().equals(String.valueOf(player)) &&
                cells[r][1].getText().equals(String.valueOf(player)) &&
                cells[r][2].getText().equals(String.valueOf(player))) {
                return true;
            }
        }
        // cols
        for (int c = 0; c < 3; c++) {
            if (cells[0][c].getText().equals(String.valueOf(player)) &&
                cells[1][c].getText().equals(String.valueOf(player)) &&
                cells[2][c].getText().equals(String.valueOf(player))) {
                return true;
            }
        }
        // diag
        if (cells[0][0].getText().equals(String.valueOf(player)) &&
            cells[1][1].getText().equals(String.valueOf(player)) &&
            cells[2][2].getText().equals(String.valueOf(player))) {
            return true;
        }
        // anti-diag
        if (cells[0][2].getText().equals(String.valueOf(player)) &&
            cells[1][1].getText().equals(String.valueOf(player)) &&
            cells[2][0].getText().equals(String.valueOf(player))) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (cells[r][c].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isGameOver() {
        return statusLabel.getText().contains("wins") || statusLabel.getText().contains("draw");
    }

    private void disableBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                cells[r][c].setDisable(true);
            }
        }
    }
}
