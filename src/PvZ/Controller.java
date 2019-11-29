package PvZ;

import com.sun.xml.internal.ws.message.MimeAttachmentSet;
import javafx.animation.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    @FXML
    public ImageView background_image;
    public ImageView LM1;
    public ImageView LM2;
    public ImageView LM3;
    public ImageView LM4;
    public ImageView LM5;
    public Pane BasePane;
    public Pane garden;
    public Pane LeftPanel;
    public ImageView SunflowerCard;
    public ImageView PeashooterCard;
    public ImageView CherrybombCard;
    public ImageView PotatomineCard;
    public ImageView WallnutCard;
    public Pane PausePane;
    public ImageView TestSun;
    public ImageView TestZombie;
    public Text SunsCollected;
    public GridPane GardenGrid;
    //--------------//
    int k = 0;
    int p = 0;
    //--------------//
    int EstPlantX = -1;
    int EstPlantY = -1;
    ImageView HoverImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PausePane.setDisable(true);
        PausePane.setOpacity(0);

        Character.gardenGrid = GardenGrid;
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
        Timeline t3 = new Timeline(new KeyFrame(Duration.seconds(0.2),LeftPanelVisible,new KeyValue(TestZombie.opacityProperty(),1)));

        Timeline t4 = new Timeline(new KeyFrame(Duration.seconds(5),new KeyValue(TestSun.layoutYProperty(),200)),
                      new KeyFrame(Duration.seconds(8),new KeyValue(TestZombie.layoutXProperty(),200)));

        t4.setCycleCount(Timeline.INDEFINITE);
//
//        SequentialTransition s = new SequentialTransition(t1,t2,t3,t4);
//        TestZombie.setOpacity(0);
//        testing
        SequentialTransition s = new SequentialTransition(t3);
        s.play();
    }

    @FXML
    public void OpenMainMenu(ActionEvent actionEvent) throws IOException {
        Application_PvZ.ChangeScreen((Node)actionEvent.getSource(),"resources/FxmlFiles/Main-Menu.fxml");
    }

    @FXML
    public void PlantChooser(MouseEvent mouseEvent) throws IOException {

        String name = ((Node) mouseEvent.getSource()).getId();
        switch (name) {
            case "SunflowerCard": {
                BasePane.setCursor(new ImageCursor(Main.SunFlowerImage));
                break;
            }
            case "PeashooterCard": {
                BasePane.setCursor(new ImageCursor(Main.PeaShooterImage));
                break;
            }
            case "CherrybombCard": {
                BasePane.setCursor(new ImageCursor(Main.CherryBombImage));
                break;
            }
            case "PotatomineCard": {
                BasePane.setCursor(new ImageCursor(Main.PotatoMineImage));
                break;
            }
            case "WallnutCard": {
                BasePane.setCursor(new ImageCursor(Main.WallNutImage));
                break;
            }
        }
        Application_PvZ.SelectedPlant = name;
    }

    public void ResumeGame(MouseEvent actionEvent){
        PausePane.setDisable(true);
        PausePane.setOpacity(0);
    }

    public void SaveGame(ActionEvent actionEvent) {

    }

    public void OpenSaveMenu(ActionEvent actionEvent) {
        PausePane.setDisable(false);
        PausePane.setOpacity(1);
    }

    public void ExitGame(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void UpdateSuns(){
        SunsCollected.setText(Integer.toString(Main.currentGame.getSunsCollected()));
    }

    public void SelectLocation(MouseEvent mouseDragEvent) {
        System.out.println("Mouse Drag Over");
    }

    public void PlantPlaced(MouseEvent mouseEvent) {
        String name = Application_PvZ.SelectedPlant;
        switch (name) {
            case "SunflowerCard": {
                Plants plant = new Sunflower(EstPlantX,EstPlantY);
                break;
            }
            case "PeashooterCard": {
                Plants plant = new PeaShooter(EstPlantX,EstPlantY);
                break;
            }
            case "CherrybombCard": {
                Plants plant = new Cherrybomb(EstPlantX,EstPlantY);
                break;
            }
            case "PotatomineCard": {
                Plants plant = new Potatomine(EstPlantX,EstPlantY);
                break;
            }
            case "WallnutCard": {
                Plants plant = new Walnut(EstPlantX,EstPlantY);
                break;
            }
            default:
                System.out.println("Plant Placed");
                break;
        }
        BasePane.setCursor(Cursor.DEFAULT);
        Application_PvZ.SelectedPlant = "";
    }

    @FXML
    public void HandleDragDetection(MouseEvent mouseEvent) {
//        Node source = (Node) mouseEvent.getSource();
//        Dragboard db = source.startDragAndDrop(TransferMode.ANY);
//        ClipboardContent cb = new ClipboardContent();
//        cb.putString("PeaShooter Incoming");
//        db.setContent(cb);
    }

    @FXML
    public void HandleDragOver(DragEvent dragEvent) {
//        if (dragEvent.getDragboard().hasString()){
//            dragEvent.acceptTransferModes(TransferMode.ANY);
//        }
    }

    @FXML
    public void HandleDataDropped(DragEvent dragEvent) {
//        String i = dragEvent.getDragboard().getString();
//        System.out.println(i);
//        System.out.println("Information Accepted");
    }

    public void ShowExpectedLocation(MouseEvent mouseEvent) {
        int CurrentLocationX = (int) mouseEvent.getX();
        int CurrentLocationY = (int) mouseEvent.getY();
        ObservableList<ColumnConstraints> cc = GardenGrid.getColumnConstraints();
        ObservableList<RowConstraints> rc = GardenGrid.getRowConstraints();
        int x = 0;
        int y = 0;
        for (ColumnConstraints k : cc){
            CurrentLocationX -= k.getPrefWidth();
            if (CurrentLocationX>0){x++;}
            else {break;}
        }
        for (RowConstraints k : rc){
            CurrentLocationY -= k.getPrefHeight();
            if (CurrentLocationY>0){y++;}
            else {break;}
        }

        if (!Application_PvZ.SelectedPlant.equals("")){
            if ( x != EstPlantX || y != EstPlantY){
                EstPlantX = x;
                EstPlantY = y;
                if (EstPlantX<0 || EstPlantY<0){return;}
                if (EstPlantX>8){ EstPlantX = 8; }
                if (EstPlantY>4){ EstPlantY = 4; }
                ImageView temp_i;
                switch (Application_PvZ.SelectedPlant){
                    case ("PeashooterCard"):
                        temp_i = new ImageView(Main.PeaShooterImage);
                        break;
                    case ("SunflowerCard"):
                        temp_i = new ImageView(Main.SunFlowerImage);
                        break;
                    case ("PotatomineCard"):
                        temp_i = new ImageView(Main.PotatoMineImage);
                        break;
                    case ("CherrybombCard"):
                        temp_i = new ImageView(Main.CherryBombImage);
                        break;
                    case ("WallnutCard"):
                        temp_i = new ImageView(Main.WallNutImage);
                        break;
                    default:
                        temp_i = new ImageView();
                        System.out.println("New Image");
                }
                temp_i.setFitHeight(Main.PlantImageHeight);
                temp_i.setFitWidth(Main.PlantImageWidth);
                temp_i.setOpacity(0.7);
                GardenGrid.getChildren().remove(HoverImage);
                GardenGrid.add(temp_i,EstPlantX,EstPlantY);
                HoverImage = temp_i;
            }
        }
        else {
            if (HoverImage!=null){
                GardenGrid.getChildren().remove(HoverImage);
                HoverImage = null;
            }
        }
    }
}
