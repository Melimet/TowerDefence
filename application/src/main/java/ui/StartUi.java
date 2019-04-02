package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import domain.Game;

public class StartUi extends Application{

    private Canvas canvas = new Canvas(650,650);
    private BorderPane borderPane = new BorderPane(canvas);
    private Scene scene = new Scene(borderPane);


    @Override
    public void start(Stage window){

        GridPane startMenu = new GridPane();
        Scene startScene = new Scene(startMenu);


        Label mapName = new Label("Map");
        startMenu.add(mapName,0,0);
        TextField mapNameTxt = new TextField("Hello_World2");
        startMenu.add(mapNameTxt,1,0);

        Label invaderHp = new Label("Invader hp %");
        startMenu.add(invaderHp,0,1);
        TextField invaderHpTxt = new TextField("100");
        startMenu.add(invaderHpTxt,1,1);

        Button button = new Button("Start game");
        button.setOnAction((event) ->{

            //TODO: Call for game method and start the game
            Game game = new Game(mapNameTxt.getText(), Integer.parseInt(invaderHpTxt.getText()));

            System.out.println("It works!");
        });

        startMenu.add(button,1,10);

        startMenu.setVgap(5);
        startMenu.setPadding(new Insets(10,20,20,20));

        window.setScene(startScene);
        window.show();

    }
    public static void main(String[] args) {
        launch(StartUi.class);
    }
}
