package PvZ;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Zombies extends Character implements Attacker{
    protected final double MOVEMENTSPEED;
    protected final int DAMAGE;

    public Zombies(double movementspeed, int damage) {
        MOVEMENTSPEED = movementspeed;
        DAMAGE = damage;
    }

    @Override
    public void Attack() {

    }
}

class Normie extends Zombies{
    public Normie() {
        super(5, 5);
        img = new ImageView(Main.NormieImage);
    }
}

class ConeTop extends Zombies{
    public ConeTop() {
        super(7, 7);
        img = new ImageView(Main.NormieImage);
    }
}

class GangLeader extends Zombies{
    public GangLeader() {
        super(7, 7);
        img = new ImageView(Main.NormieImage);
    }
}
