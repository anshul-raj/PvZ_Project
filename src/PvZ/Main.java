package PvZ;
// Y = 109 , OY = -11 ( Inner Plane)
// X = 89 , OX = 74 ( Inner Plane)

// Lawnmower
// X = 8
// OY = 26
// Y = 109

// PeaX = 74
// PeaY = 19

import javafx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.text.html.ImageView;
import java.awt.*;

public class Main extends Application {
    public static final int ORIGIN_X = 74;
    public static final int ORIGIN_Y = -11;
    public static final int X = 100;
    public static final int Y = 115;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent MainMenuScene = FXMLLoader.load(getClass().getResource("Main-Menu.fxml"));
        primaryStage.setScene(new Scene(MainMenuScene));
        primaryStage.show();
        MainMenuScene.requestFocus();
//        c.ShowZombie();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
