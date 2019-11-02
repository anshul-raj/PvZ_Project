package PvZ;

import javafx.animation.*;
import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.ActionEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.security.Key;
import java.sql.Time;
import java.util.*;

public class Controller implements Initializable {

    @FXML
    public ImageView background_image;
    public ImageView LM1;
    public ImageView LM2;
    public ImageView LM3;
    public ImageView LM4;
    public ImageView LM5;
    public Pane BasePane;
    public Pane garden;
    public Pane LeftPanel;
    public ImageView SunflowerCard;
    public ImageView PeashooterCard;
    public ImageView CherrybombCard;
    public ImageView PotatomineCard;
    public ImageView WallnutCard;
    public MenuButton PauseBtn;
    //--------------//
    int k = 0;
    int p = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        MenuItem i1 = new MenuItem("Exit");
        MenuItem i2 = new MenuItem("Save and Exit");
        MenuItem i3 = new MenuItem("Mute");

        PauseBtn.getItems().set(0,i1);
        PauseBtn.getItems().set(1,i2);
        PauseBtn.getItems().add(i3);

        Character.garden = garden;

        LeftPanel.setOpacity(0);

        KeyValue disappear = new KeyValue(garden.opacityProperty(), 0, Interpolator.EASE_OUT);
        KeyValue right = new KeyValue(BasePane.layoutXProperty(), -383, Interpolator.EASE_OUT);

        Timeline t1 = new Timeline(new KeyFrame(Duration.seconds(3), right, disappear));
        t1.setCycleCount(1);

        KeyValue reappear = new KeyValue(garden.opacityProperty(), 1, Interpolator.EASE_IN);
        KeyValue left = new KeyValue(BasePane.layoutXProperty(), 0, Interpolator.EASE_IN);
        Timeline t2 = new Timeline(new KeyFrame(Duration.seconds(1.8), left, reappear));
        t2.setDelay(Duration.seconds(1.5));
        t2.setCycleCount(1);

        KeyValue LeftPanelVisible = new KeyValue(LeftPanel.opacityProperty(),1);
        Timeline t3 = new Timeline(new KeyFrame(Duration.seconds(0.2),LeftPanelVisible));

        SequentialTransition s = new SequentialTransition(t1,t2,t3);

//        testing
//        SequentialTransition s = new SequentialTransition(t3);
        s.play();

    }

    @FXML
    public void OpenMainMenu(ActionEvent actionEvent) throws IOException {
        Main.ChangeScreen((Node)actionEvent.getSource(),"resources/FxmlFiles/Main-Menu.fxml");
    }

    @FXML
    public void PlantChooser(MouseEvent mouseEvent) throws IOException {

        System.out.println(mouseEvent.getSource().toString());

        if (k > 4) {
            k = 0;
            p++;
        }
        String name = ((Node) mouseEvent.getSource()).getId();
        if (p<9){
            switch (name) {
                case "SunflowerCard": {
                    Plants plant = new Sunflower(p, k++);
                    break;
                }
                case "PeashooterCard": {
                    Plants plant = new PeaShooter(p, k++);
                    break;
                }
                case "CherrybombCard": {
                    Plants plant = new Cherrybomb(p, k++);
                    break;
                }
                case "PotatomineCard": {
                    Plants plant = new Potatomine(p, k++);
                    break;
                }
                case "WallnutCard": {
                    Plants plant = new Walnut(p, k++);
                    break;
                }
                default:
                    System.out.println("ERROR---------------------");
                    break;
            }
        }
    }

    public void ResumeGame(MouseEvent actionEvent){

    }

    public void SaveGame(ActionEvent actionEvent) {
    }

    public void OpenSaveMenu(ActionEvent actionEvent) {

    }


    public void ExitGame(ActionEvent actionEvent) {
        System.exit(0);
    }
}
