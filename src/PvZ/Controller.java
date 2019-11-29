package PvZ;

import com.sun.org.glassfish.external.amx.AMX;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.util.Pair;

import javax.crypto.spec.PSource;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
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

        System.out.println(mouseEvent.getSource().toString());

        if (k > 4) {
            k = 0;
            p++;
        }
        String name = ((Node) mouseEvent.getSource()).getId();
        if (p<9){
            switch (name) {
                case "SunflowerCard": {
                    Plants plant = new Sunflower(p, k++);
                    break;
                }
                case "PeashooterCard": {
                    Plants plant = new PeaShooter(p, k++);
                    break;
                }
                case "CherrybombCard": {
                    Plants plant = new Cherrybomb(p, k++);
                    break;
                }
                case "PotatomineCard": {
                    Plants plant = new Potatomine(p, k++);
                    break;
                }
                case "WallnutCard": {
                    Plants plant = new Walnut(p, k++);
                    break;
                }
                default:
                    System.out.println("ERROR---------------------");
                    break;
            }
        }
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

    public void PlantSelected(MouseEvent mouseEvent) {
        String s = ((Node) mouseEvent.getSource()).getId();
        if (s.equals("SunflowerCard")){
            BasePane.setCursor(new ImageCursor(Main.SunFlowerImage));
        }
        else if (s.equals("PeashooterCard")){
            BasePane.setCursor(new ImageCursor(Main.PeaShooterImage));
        }
        else if (s.equals("CherrybombCard")){
            BasePane.setCursor(new ImageCursor(Main.CherryBombImage));
        }
        else if (s.equals("PotatomineCard")){
            BasePane.setCursor(new ImageCursor(Main.PotatoMineImage));
        }
        else if (s.equals("WallnutCard")){
            BasePane.setCursor(new ImageCursor(Main.WallNutImage));
        }
    }

    public void SelectLocation(MouseEvent mouseDragEvent) {
        System.out.println("Mouse Drag Over");
    }

    public void PlantPlaced(MouseEvent mouseEvent) {
        Node n = (Node) mouseEvent.getSource();
        double x_ = mouseEvent.getX();
        double y_ = mouseEvent.getY();
        if (x_>255 && x_<(255+1112) && y_>94 && y_<(94+714)){
            System.out.println("Inside Garden");
        }
        BasePane.setCursor(Cursor.DEFAULT);
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
        Node n =(Node) mouseEvent.getSource();
        Integer x = GridPane.getColumnIndex(n);
        Integer y = GridPane.getRowIndex(n);
//        ImageView temp_i = new ImageView(Main.PeaShooterImage);
//        temp_i.setFitHeight(Main.PlantImageHeight);
//        temp_i.setFitWidth(Main.PlantImageWidth);
//        temp_i.setOpacity(0.7);
//        if (HoverImage!=null){
//            GardenGrid.getChildren().remove(HoverImage);
//        }
//        GardenGrid.add(temp_i,x,y);
//        HoverImage = temp_i;
        if (Application_PvZ.SelectedPlant!=""){
            if ( x != EstPlantX || y != EstPlantY){
                EstPlantX = x;
                EstPlantY = y;
                if (EstPlantX<0 || EstPlantY<0){return;}
                if (EstPlantX>8){ EstPlantX = 8; }
                if (EstPlantY>4){ EstPlantY = 4; }
                System.out.println(x+","+y);
                System.out.println(EstPlantX+","+EstPlantY);
                ImageView temp_i = new ImageView(Main.PeaShooterImage);
                temp_i.setFitHeight(Main.PlantImageHeight);
                temp_i.setFitWidth(Main.PlantImageWidth);
                temp_i.setOpacity(0.7);
                GardenGrid.getChildren().remove(HoverImage);
                GardenGrid.add(temp_i,EstPlantX,EstPlantY);
                temp_i.relocate(Main.ORIGIN_X+(EstPlantX* Main.X), Main.ORIGIN_Y+(EstPlantY* Main.Y));
                HoverImage = temp_i;
            }
        }
        else {
            if (HoverImage!=null){
                garden.getChildren().remove(HoverImage);
                HoverImage = null;
            }
        }
    }
}
