package PvZ;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

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
    public Text UserNameTextField;
    public ImageView UserIcon;

    int i=0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UserNameTextField.setText(Main.currentUser.getUSERNAME());
        StartBtn.setFont(Font.loadFont("https://fonts.googleapis.com/css?family=Griffy&display=swap",10));
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
        Application_PvZ.ChangeScreen((Node) actionEvent.getSource(),"resources/FxmlFiles/PvZ_Layout.fxml");
    }

    @FXML
    public void ShowLevel(ActionEvent actionEvent) throws IOException {
        Application_PvZ.ChangeScreen((Node) actionEvent.getSource(), "resources/FxmlFiles/Levels.fxml");
    }

    @FXML
    public void ReturnToUserSelection(MouseEvent mouseEvent) throws IOException {
        Application_PvZ.ChangeScreen((Node) mouseEvent.getSource(),"resources/FxmlFiles/Choose-User.fxml");
    }
}
