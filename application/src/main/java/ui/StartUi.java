package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import domain.Game;

public class StartUi extends Application {

    private Canvas canvas = new Canvas(650, 650);
    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
    private BorderPane borderPane = new BorderPane(canvas);
    private Scene gameScene = new Scene(borderPane);
    private Game game;

    @Override
    public void start(Stage window) {

        GridPane startMenu = new GridPane();
        Scene startScene = new Scene(startMenu);


        Label mapName = new Label("File name for map");
        startMenu.add(mapName, 0, 0);
        TextField mapNameTxt = new TextField("hello_world2.txt");
        startMenu.add(mapNameTxt, 1, 0);

        Label invaderHp = new Label("Invader hp %");
        startMenu.add(invaderHp, 0, 1);
        TextField invaderHpTxt = new TextField("100");
        startMenu.add(invaderHpTxt, 1, 1);

        Button button = new Button("Start game");
        button.setOnAction((event) -> {

            //TODO: Call for game method and start the game
            game = new Game(mapNameTxt.getText(), Integer.parseInt(invaderHpTxt.getText()));
            window.setScene(gameScene);
            drawMap();

        });

        startMenu.add(button, 1, 10);

        startMenu.setVgap(5);
        startMenu.setPadding(new Insets(10, 20, 20, 20));

        window.setScene(startScene);
        window.show();

    }

    public void drawMap() {

        graphicsContext.clearRect(0, 0, 650, 650);
        int[][] mapRoute = game.getMapRoute();
        for (int i = 0; i < mapRoute.length; i++) {
            for (int j = 0; j < mapRoute[0].length; j++) {
                //Grass
                if (mapRoute[i][j] == 0) {
                    graphicsContext.setFill(Color.GREEN);
                    graphicsContext.fillRect(j * 92, i * 92, 92, 92);
                    //Road
                } else if (mapRoute[i][j] == 1) {
                    graphicsContext.setFill(Color.BEIGE);
                    graphicsContext.fillRect(j * 92, i * 92, 92, 92);
                    //Goal
                } else if (mapRoute[i][j] == 2) {
                    graphicsContext.setFill(Color.RED);
                    graphicsContext.fillRect(j * 92, i * 92, 92, 92);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(StartUi.class);
    }
}
