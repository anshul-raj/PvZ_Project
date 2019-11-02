package PvZ;

import javafx.event.ActionEvent;
import javafx.scene.Node;

import java.io.IOException;

public class Levels {

    public void LoadLevel(ActionEvent actionEvent) throws IOException {
        Main.ChangeScreen((Node) actionEvent.getSource(),"resources/FxmlFiles/PvZ_Layout.fxml");
    }
}
