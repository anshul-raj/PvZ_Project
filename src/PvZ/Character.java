package PvZ;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Pair;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class Character implements Serializable {
    protected int Health;
    protected Pair<Integer,Integer> PresentTile;
    protected static Pane garden;
    protected ImageView img;

    public void TakeDamage(int damage){
        this.Health-=damage;
        if (Health<=0){this.remove();}
    }

    public void Summon(int x,int y) {
        img.setFitHeight(Main.PlantImageHeight);
        img.setFitWidth(Main.PlantImageWidth);
        img.relocate(Main.ORIGIN_X+(x* Main.X), Main.ORIGIN_Y+(y* Main.Y));
        garden.getChildren().add(img);
    }

    private void remove(){
        garden.getChildren().remove(this.img);
    }
}