package PvZ;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChooseUserController implements Initializable {

    public Pane UserSlectionPopup;
    public Button Usr4;
    public Button Usr5;
    public Button Usr6;
    public Button Usr3;
    public Button Usr2;
    public Button Usr1;
    public Pane NewUserPopup;
    public TextField UsernameTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NewUserPopup.setOpacity(0);
        NewUserPopup.setDisable(true);
        RefreshBtns();
    }

    private void RefreshBtns(){
        Button[] btnList = {Usr1,Usr2,Usr3,Usr4,Usr5,Usr6};
        ArrayList<User> tempUsrArray = Main.app.getUserlist();
        int l = tempUsrArray.size();
        for(int i=0;i<l;i++){
            String name = Main.app.getUserlist().get(i).getUSERNAME();
            btnList[i].setText(name);
            btnList[i].setDisable(false);
        }
        for(int i=l;i<6;i++){
            btnList[i].setDisable(true);
        }
    }

    public void OpenMainMenu(ActionEvent actionEvent) throws IOException {
        String s = ((Control) actionEvent.getSource()).getId();
        System.out.println(s);
        Main.currentUser = Main.app.getUserlist().get(Integer.parseInt(s.substring(3))-1);
        Main.app.ChangeScreen((Node) actionEvent.getSource(),new MainMenu());
    }

    public void CreateUserBtn(ActionEvent actionEvent) {

        if (Main.app.getUserlist().size()==6){
            //POPUP
            return;
        }
        Timeline t = new Timeline(new KeyFrame(Duration.seconds(0.2),
                new KeyValue(UserSlectionPopup.visibleProperty(),false),
                new KeyValue(UserSlectionPopup.disableProperty(),true),
                new KeyValue(NewUserPopup.disableProperty(),false),
                new KeyValue(NewUserPopup.opacityProperty(),1)));
        t.play();
        NewUserPopup.requestFocus();
    }

    public void UserCreatedBtn(ActionEvent actionEvent) {
        String usrname = UsernameTextField.getText();
        if (usrname==null || usrname.equals("")){return;}
        Main.app.newUser(usrname);
        UsernameTextField.setText(null);
        RefreshBtns();
        Timeline t = new Timeline(new KeyFrame(Duration.seconds(0.2),
                new KeyValue(UserSlectionPopup.visibleProperty(),true),
                new KeyValue(UserSlectionPopup.disableProperty(),false),
                new KeyValue(NewUserPopup.disableProperty(),true),
                new KeyValue(NewUserPopup.opacityProperty(),0)));
        t.play();
    }
}
