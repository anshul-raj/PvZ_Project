package PvZ;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Zombies extends Character implements Attacker{
    protected final double MOVEMENTSPEED;
    protected final int DAMAGE;
    protected int row;

    public Zombies(double movementspeed, int damage) {
        MOVEMENTSPEED = movementspeed;
        DAMAGE = damage;
    }

    @Override
    public void Attack() {

    }

    void ResizeImage(){
        img.setFitWidth(Main.ZombieImageWidth);
        img.setFitHeight(Main.ZombieImageHeight);
    }

    @Override
    public void remove(){
        super.remove();
        Main.currentGame.RemoveZombie(this);
    }

    @Override
    public void Summon(int x,int y){
        ResizeImage();
        Character.garden.getChildren().add(img);
        img.relocate(x,Main.ORIGIN_Y + row*Main.Y);
    }
}

class Normie extends Zombies{
    public Normie(int row) {
        super(5, 5);
        img = new ImageView(Main.NormieImage);
        this.row = row;
        Summon(1111 , row);
    }
}

class ConeTop extends Zombies{
    public ConeTop(int row) {
        super(7, 7);
        img = new ImageView(Main.NormieImage);
        this.row = row;
        Summon(1111 , row);
    }
}

class GangLeader extends Zombies{
    public GangLeader(int row) {
        super(7, 7);
        img = new ImageView(Main.NormieImage);
        this.row = row;
        Summon(1111 , row);
    }
}
