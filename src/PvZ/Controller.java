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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.ActionEvent;

import java.io.FileNotFoundException;
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
    public Pane garden;
    @FXML
    public Button BackButton;
    @FXML
    public Pane LeftPanel;
    public ImageView SunflowerCard;
    public ImageView PeashooterCard;
    public ImageView CherrybombCard;
    public ImageView PotatomineCard;
    public ImageView WallnutCard;
    int k = 0;
    int p = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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

//        SequentialTransition s = new SequentialTransition(t1,t2,t3);

//        testing
        SequentialTransition s = new SequentialTransition(t3);

        s.play();

    }

    @FXML
    public void OpenMainMenu(ActionEvent actionEvent) throws IOException {
        Parent GameScene = FXMLLoader.load(getClass().getResource("resources/FxmlFiles/Main-Menu.fxml"));
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene((GameScene)));
        window.show();
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
                    System.out.println("if name.equals( 1");
                    Plants plant = new Sunflower(p, k++);
                    break;
                }
                case "PeashooterCard": {
                    System.out.println("if name.equals( 2");
                    Plants plant = new PeaShooter(p, k++);
                    break;
                }
                case "CherrybombCard": {
                    System.out.println("if name.equals( 3");
                    Plants plant = new Cherrybomb(p, k++);
                    break;
                }
                case "PotatomineCard": {
                    System.out.println("if name.equals( 4");
                    Plants plant = new Potatomine(p, k++);
                    break;
                }
                case "WallnutCard": {
                    System.out.println("if name.equals( 5");
                    Plants plant = new Walnut(p, k++);
                    break;
                }
                default:
                    System.out.println("ERROR---------------------");
                    break;
            }
        }
    }
}
