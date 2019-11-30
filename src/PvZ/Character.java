package PvZ;

import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Pair;
import java.io.FileNotFoundException;
import java.io.Serializable;

public abstract class Character implements Serializable {
    protected int Health;
    protected Pair<Integer,Integer> PresentTile;
    protected static GridPane gardenGrid;
    protected static Pane garden;
    transient protected ImageView img;

    public void TakeDamage(int damage){
        this.Health-=damage;
        if (Health<=0){this.remove();}
    }

    void Summon(int x, int y) {
        System.out.println(gardenGrid);
        gardenGrid.add(img,x,y);
    }

    protected void remove(){
        gardenGrid.getChildren().remove(this.img);
    }
}