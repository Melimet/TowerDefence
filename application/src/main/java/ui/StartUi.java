package ui;

import domain.Tower;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.animation.*;

import domain.Game;

import java.util.ArrayList;

public class StartUi extends Application {

    private Canvas mapCanvas = new Canvas(644, 670);
    private GraphicsContext graphicsContext = mapCanvas.getGraphicsContext2D();
    private BorderPane borderPane = new BorderPane(mapCanvas);
    private Scene gameScene = new Scene(borderPane);
    private Game game;
    private int selectedTurretId;


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

        Button startGameButton = new Button("Start game");
        startGameButton.setOnAction((event) -> {

            startGame(window, mapNameTxt.getText(), Integer.parseInt(invaderHpTxt.getText()));

        });

        startMenu.add(startGameButton, 1, 10);

        startMenu.setVgap(5);
        startMenu.setPadding(new Insets(10, 20, 20, 20));

        window.setTitle("Tower Defence");
        window.setScene(startScene);
        window.show();

    }

    public void startGame(Stage window, String mapName, Integer hpPct) {

        Button buildTower1 = new Button("Build turret id 0");
        buildTower1.setOnAction(event -> {
            this.selectedTurretId = 0;
        });
        Button buildTower2 = new Button("Build turret id 1");
        buildTower2.setOnAction(event -> {
            this.selectedTurretId = 1;
        });

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 20, 20, 20));
        hbox.getChildren().add(buildTower1);
        hbox.getChildren().add(buildTower2);
        borderPane.setBottom(hbox);

        game = new Game(mapName, hpPct);
        window.setScene(gameScene);

        new AnimationTimer() {
            long previous = 0;

            @Override
            public void handle(long now) {

                if (now - previous < 1000000000 / 10) {
                    return;
                }
                gameScene.setOnMouseClicked(event -> {
                    double xLocation = event.getX();
                    double yLocation = event.getY();
                    game.buildTower(selectedTurretId, xLocation, yLocation);
                });
                drawMap(window);
            }
        }.start();
    }

    public void drawMap(Stage window) {

        graphicsContext.clearRect(0, 0, 700, 700);

        graphicsContext.fillText("Lives left: " + Integer.toString(game.getCurrentHitPoints()), 10, 660);
        graphicsContext.fillText("Gold: " + Integer.toString(game.getGold()), 120, 660);
        graphicsContext.fillText("Currently selected turret id: " + Integer.toString(this.selectedTurretId), 200, 660);

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
        for(Tower tower: game.getTowers()){
            graphicsContext.fillText("TOWER HERE", tower.getPixelX(),tower.getPixelY());
        }
    }

    public static void main(String[] args) {
        launch(StartUi.class);
    }
}
