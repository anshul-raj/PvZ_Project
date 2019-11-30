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
    static Image NormieImage;
    static Image GangleaderImage;
    static Image ConeTopImage;
    //------------------------------------------------------
    public static final int ORIGIN_X = 90;
    public static final int ORIGIN_Y = 24;
    public static final int X = 108;
    public static final int Y = 135;
    public static final int PlantImageWidth = 116;
    public static final int PlantImageHeight = 111;
    public static final int ZombieImageWidth = 107;
    public static final int ZombieImageHeight = 170;
    public static final int sunImagewidth = (int) ((int) Main.PlantImageWidth/1.5);
    public static final int sunImageHeight = (int) ((int) Main.PlantImageHeight/1.5);
    //------------------------------------------------------


    static {
        try {
            PeaShooterImage = new Image(new FileInputStream("src/PvZ/resources/img/PeaShooter.gif"));
            SunFlowerImage = new Image(new FileInputStream("src/PvZ/resources/img/Sunflower.gif"));
            CherryBombImage = new Image(new FileInputStream("src/PvZ/resources/img/CherryBomb.png"));
            WallNutImage = new Image(new FileInputStream("src/PvZ/resources/img/Wall-nut1.png"));
            PotatoMineImage = new Image(new FileInputStream("src/PvZ/resources/img/Potatomine.gif"));
            NormieImage = new Image(new FileInputStream("src/PvZ/resources/img/Zombie1.png"));
            ConeTopImage = new Image(new FileInputStream("src/PvZ/resources/img/BucketheadZombie.gif"));
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
        Parent UC = app.ChooseUserScene.load();
        app.chooseUserController = (ChooseUserController) app.ChooseUserScene.getController();
        System.out.println(app.chooseUserController);
        primaryStage.setScene(new Scene(UC));
        primaryStage.show();
        UC.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Application_PvZ{
    private ArrayList<User> userlist = new ArrayList<>();
    //-------------------------------------------------------
    transient public ChooseUserController chooseUserController = null;
    transient public MainMenuController mainMenuController = null;
    transient public LevelsController levelsController = null;
    transient public Controller gamecontroller = null;
    //--------------------------------------------------------
    public FXMLLoader ChooseUserScene = new FXMLLoader(getClass().getResource("resources/FxmlFiles/Choose-User.fxml"));
    public FXMLLoader MainMenuScene = new FXMLLoader(getClass().getResource("resources/FxmlFiles/Main-Menu.fxml"));
    public FXMLLoader ChooseLevelScene = new FXMLLoader(getClass().getResource("resources/FxmlFiles/Levels.fxml"));
    public FXMLLoader GameScene = new FXMLLoader(getClass().getResource("resources/FxmlFiles/PvZ_Layout_2.fxml"));
    //------------------------------------------------------

    static public String SelectedPlant = ""; // This Will Change Eventually -> Game

    public Application_PvZ() throws IOException {
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

    public void ChangeScreen(Node n, MyScene s) throws IOException {
        Parent newScreen = null;
        if (ChooseUser.class == s.getClass()) {
            newScreen = ChooseUserScene.load();
            chooseUserController = ChooseUserScene.getController();
        } else if (MainMenu.class==s.getClass()) {
            newScreen = MainMenuScene.load();
            mainMenuController = MainMenuScene.getController();
        } else if (ChooseLevel.class==s.getClass()) {
            newScreen = ChooseLevelScene.load();
            chooseUserController = ChooseUserScene.getController();
        } else if (Garden.class == s.getClass()){
            newScreen = GameScene.load();
            gamecontroller = GameScene.getController();
        }
        Stage window = (Stage) (n.getScene().getWindow());
        assert newScreen != null;
        window.setScene(new Scene((newScreen)));
        window.show();
    }

    public void newUser(String name){
        userlist.add(new User(name));
    }

    public void Startgame(){

    }
}
