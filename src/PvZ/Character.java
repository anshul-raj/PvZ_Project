package PvZ;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Pair;

import java.io.FileNotFoundException;

public class Character {
    protected int Health;
    protected Pair<Integer,Integer> PresentTile;
    protected static Pane garden;
    protected ImageView img;

    public void TakeDamage(int damage){ }

    public void Summon(int x,int y) throws FileNotFoundException {
        img.setFitHeight(Main.ImageHeight);
        img.setFitWidth(Main.ImageWidth);
        img.relocate(Main.ORIGIN_X+(x*Main.X),Main.ORIGIN_Y+(y*Main.Y));
        garden.getChildren().add(img);
    }

    public void remove(){ }
}