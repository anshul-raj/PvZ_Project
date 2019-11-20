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

    public void TakeDamage(int damage){
        this.Health-=damage;
        if (Health<=0){this.remove();}
    }

    public void Summon(int x,int y) throws FileNotFoundException {
        img.setFitHeight(Application_PvZ.ImageHeight);
        img.setFitWidth(Application_PvZ.ImageWidth);
        img.relocate(Application_PvZ.ORIGIN_X+(x* Application_PvZ.X), Application_PvZ.ORIGIN_Y+(y* Application_PvZ.Y));
        garden.getChildren().add(img);
    }

    private void remove(){
        garden.getChildren().remove(this.img);
    }
}