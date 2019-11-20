package PvZ;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Control;
import java.io.IOException;

public class ChooseUserController {
    public void OpenMainMenu(ActionEvent actionEvent) throws IOException {
        String s = ((Control) actionEvent.getSource()).getId();
        System.out.println(s.charAt(3));
        Application_PvZ.ChangeScreen((Node) actionEvent.getSource(),"resources/FxmlFiles/Main-Menu.fxml");
    }
}
