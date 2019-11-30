package PvZ;

import javafx.event.ActionEvent;
import javafx.scene.Node;

import java.io.IOException;

public class LevelsController {

    public void LoadLevel(ActionEvent actionEvent) throws IOException {
        Main.app.ChangeScreen((Node) actionEvent.getSource(),new Garden());
    }
}
