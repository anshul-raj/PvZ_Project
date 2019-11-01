package PvZ;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public ImageView background_image;
    @FXML
    public ImageView LM1;
    @FXML
    public ImageView LM2;
    @FXML
    public ImageView LM3;
    @FXML
    public ImageView LM4;
    @FXML
    public ImageView LM5;
    @FXML
    public Pane BasePane;
    @FXML
    public Pane garden_road;
    @FXML
    public Button BackButton;
    int k = 0;
    int p = 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Character.garden = garden_road;
        KeyValue disappear = new KeyValue(garden_road.opacityProperty(), 0, Interpolator.EASE_OUT);
        KeyValue right = new KeyValue(BasePane.layoutXProperty(), -383, Interpolator.EASE_OUT);

        Timeline t1 = new Timeline(new KeyFrame(Duration.seconds(3), right, disappear));
        t1.setCycleCount(1);

        KeyValue reappear = new KeyValue(garden_road.opacityProperty(), 1, Interpolator.EASE_IN);
        KeyValue left = new KeyValue(BasePane.layoutXProperty(), 0, Interpolator.EASE_IN);
        Timeline t2 = new Timeline(new KeyFrame(Duration.seconds(1.8), left, reappear));
        t2.setDelay(Duration.seconds(1.5));
        t2.setCycleCount(1);

        SequentialTransition s = new SequentialTransition(t1, t2);
        s.play();

    }

    @FXML
    public void OpenMainMenu(ActionEvent actionEvent) throws IOException {
        if (k > 4) {
            k = 0;
            p++;
        }
        if (p<9){
            Plants plant = new PeaShooter(p,k++);
        }
        else {
            Parent GameScene = FXMLLoader.load(getClass().getResource("resources/FxmlFiles/Main-Menu.fxml"));
            Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(new Scene((GameScene)));
            window.show();
            GameScene.requestFocus();
        }
    }
}
