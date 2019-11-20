package PvZ;
// Y = 109 , OY = -11 ( Inner Plane)
// X = 89 , OX = 74 ( Inner Plane)

// Lawnmower
// X = 8
// OY = 26
// Y = 109

// PeaX = 74
// PeaY = 19

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


abstract class GameVariableCollection{
    Game CurrentGame;
}

public class Application_PvZ extends Application{
    private ArrayList<User> userlist = new ArrayList<>();
    private User CurrentUser;
    public static final int ORIGIN_X = 90;
    public static final int ORIGIN_Y = 24;
    public static final int X = 108;
    public static final int Y = 135;
    public static final int ImageWidth = 116;
    public static final int ImageHeight = 111;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent ChooseUserScene = FXMLLoader.load(getClass().getResource("resources/FxmlFiles/Choose-User.fxml"));
        primaryStage.setScene(new Scene(ChooseUserScene));
        primaryStage.show();
        ChooseUserScene.requestFocus();
    }

    public static void ChangeScreen(Node n,String s) throws IOException {
        Parent newScreen = FXMLLoader.load(Application_PvZ.class.getResource(s));
        Stage window = (Stage) (n.getScene().getWindow());
        window.setScene(new Scene((newScreen)));
        window.show();
    }

    public void newUser(String name){
        userlist.add(new User(name));
    }

    public void Startgame(){

    }

    public void LoadUser(int i){
        CurrentUser = userlist.get(i-1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
