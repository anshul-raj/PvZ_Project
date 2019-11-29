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
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main extends Application{
    public static Game currentGame = null;
    public static User currentUser = null;
    public static Application_PvZ app = null;
    //------------------------------------
    static Image PeaShooterImage;
    static Image SunFlowerImage;
    static Image CherryBombImage;
    static Image WallNutImage;
    static Image PotatoMineImage;
    //------------------------------------------------------
    public static final int ORIGIN_X = 90;
    public static final int ORIGIN_Y = 24;
    public static final int X = 108;
    public static final int Y = 135;
    public static final int PlantImageWidth = 116;
    public static final int PlantImageHeight = 111;


    static {
        try {
            PeaShooterImage = new Image(new FileInputStream("src/PvZ/resources/img/PeaShooter.gif"));
            SunFlowerImage = new Image(new FileInputStream("src/PvZ/resources/img/Sunflower.gif"));
            CherryBombImage = new Image(new FileInputStream("src/PvZ/resources/img/Zombie1.png"));
            WallNutImage = new Image(new FileInputStream("src/PvZ/resources/img/Wall-nut1.png"));
            PotatoMineImage = new Image(new FileInputStream("src/PvZ/resources/img/Potatomine.gif"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            app = new Application_PvZ();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Main() throws FileNotFoundException {
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent ChooseUserScene = app.ChooseUserScene.load();
        Parent ChooseUserScene = app.GameScene.load();
        primaryStage.setScene(new Scene(ChooseUserScene));
        primaryStage.show();
        ChooseUserScene.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Application_PvZ{
    private ArrayList<User> userlist = new ArrayList<>();
    //-------------------------------------------------------
    public ChooseUserController chooseUserController = null;
    public MainMenuController mainMenuController = null;
    public LevelsController levelsController = null;
    public Controller gamecontroller = null;
    //--------------------------------------------------------
    public FXMLLoader ChooseUserScene = new FXMLLoader(getClass().getResource("resources/FxmlFiles/Choose-User.fxml"));
    public FXMLLoader MainMenuScene = new FXMLLoader(getClass().getResource("resources/FxmlFiles/Main-Menu.fxml"));
    public FXMLLoader ChooseLevelScene = new FXMLLoader(getClass().getResource("resources/FxmlFiles/Levels.fxml"));
    public FXMLLoader GameScene = new FXMLLoader(getClass().getResource("resources/FxmlFiles/PvZ_Layout_2.fxml"));
    //------------------------------------------------------
    static public String SelectedPlant = null; // This Will Change Eventually -> Game

    public Application_PvZ() throws IOException {
        chooseUserController = (ChooseUserController) ChooseUserScene.getController();
        mainMenuController = (MainMenuController) MainMenuScene.getController();
        levelsController = (LevelsController) ChooseLevelScene.getController();
        gamecontroller = (Controller) GameScene.getController();

        //----------
        try{
            File folder = new File("db/");
            if (folder.listFiles()!=null){
                for(File f : Objects.requireNonNull(folder.listFiles())){
                    User temp = User.LoadUser(f.getName());
                    userlist.add(temp);
                }
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getUserlist() {
        return userlist;
    }

    public static void ChangeScreen(Node n, String s) throws IOException {
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
}
