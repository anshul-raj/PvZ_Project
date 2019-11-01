package PvZ;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.awt.event.MouseEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    public Pane BackgroundPane;
    public ImageView BkgImgMM;
    public Pane menuPane;
    public Button StartBtn;
    public Button test_button;

    int i=0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void HandleButtonAction(ActionEvent actionEvent) {
        System.out.println("Button Pressed "+i++);
    }

    @FXML
    public void ExitGame(ActionEvent actionEvent){
        System.exit(0);
    }

    @FXML
    public void StartGame(ActionEvent actionEvent) throws IOException {

        Parent GameScene = FXMLLoader.load(getClass().getResource("PvZ_Layout.fxml"));
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene((GameScene)));
        window.show();
        window.requestFocus();
    }

}