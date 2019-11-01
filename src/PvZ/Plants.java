package PvZ;

import com.sun.javafx.runtime.SystemProperties;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Pair;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class Plants extends Character{
    protected final int COST;
    protected final int COOLDOWNTIMER;

    Plants(int cost, int cooldowntimer) {
        COST = cost;
        COOLDOWNTIMER = cooldowntimer;
    }
}
class PeaShooter extends Plants{
    private final int LAUNCHINTEVAL = 5;
    ImageView img;

    PeaShooter(int x,int y) throws FileNotFoundException {
        super(50,50);

        PresentTile = new Pair<Integer, Integer>(x,y);
        FileInputStream input = new FileInputStream("src/PvZ/resources/img/PeaShooter.gif");
        Image i = new Image(input);
        img = new ImageView(i);
        img.setFitHeight(102);
        img.setFitWidth(107);
        img.relocate(Main.ORIGIN_X+x*Main.X,Main.ORIGIN_Y+y*Main.Y);
        garden.getChildren().add(img);
        Launch();
    }

    public void Launch(){
        Projectile p = new Pea(Main.ORIGIN_X+PresentTile.getKey()*Main.X+74
                ,Main.ORIGIN_Y+PresentTile.getValue()*Main.Y+19,garden);
    }
}
