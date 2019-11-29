package PvZ;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Pair;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class Character implements Serializable {
    protected int Health;
    protected Pair<Integer,Integer> PresentTile;
    protected static GridPane gardenGrid;
    protected ImageView img;

    public void TakeDamage(int damage){
        this.Health-=damage;
        if (Health<=0){this.remove();}
    }

    public void Summon(int x,int y) {
        System.out.println(gardenGrid);
        gardenGrid.add(img,x,y);
    }

    private void remove(){
        gardenGrid.getChildren().remove(this.img);
    }
}