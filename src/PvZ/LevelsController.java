package PvZ;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LevelsController implements Initializable {

    public void LoadLevel(ActionEvent actionEvent) throws IOException {
        Main.app.ChangeScreen((Node) actionEvent.getSource(),new Garden());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
