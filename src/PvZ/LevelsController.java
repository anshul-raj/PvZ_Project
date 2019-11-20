package PvZ;

import javafx.event.ActionEvent;
import javafx.scene.Node;

import java.io.IOException;

public class LevelsController {

    public void LoadLevel(ActionEvent actionEvent) throws IOException {
        Application_PvZ.ChangeScreen((Node) actionEvent.getSource(),"resources/FxmlFiles/PvZ_Layout.fxml");
    }
}
