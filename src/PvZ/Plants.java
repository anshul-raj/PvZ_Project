package PvZ;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.util.Pair;

import javax.naming.TimeLimitExceededException;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

class Plants extends Character{
    protected final int COST;
    protected final int COOLDOWNTIMER;

    Plants(int cost, int cooldowntimer) {
        COST = cost;
        COOLDOWNTIMER = cooldowntimer;
    }

    void ResizeImage(){
        img.setFitWidth(Main.PlantImageWidth);
        img.setFitHeight(Main.PlantImageHeight);
        Main.currentGame.PlacePlant(this);
    }

    @Override
    public void remove(){
        super.remove();
        Main.currentGame.RemovePlant(this);
    }
}

class PeaShooter extends Plants implements Attacker{
    private final int LAUNCHINTEVAL = 5;

    PeaShooter(int x,int y){
        super(50,50);
        System.out.println("Planting Peashooter");
        PresentTile = new Pair<Integer, Integer>(x,y);
        this.img = new ImageView(Main.PeaShooterImage);
        ResizeImage();
        Summon(x,y);
    }

    public void Launch(){
        Projectile p = new Pea(Main.ORIGIN_X+(PresentTile.getKey()* Main.X)+78
                , Main.ORIGIN_Y+(PresentTile.getValue()* Main.Y)+25,gardenGrid);
    }

    @Override
    public void Attack() {
        // Check if Zombie in lane
        Launch();
    }
}

class Sunflower extends Plants{
    Sun s;

    Sunflower(int x,int y){
        super(50,50);
        System.out.println("Planting Sunflower");
        PresentTile = new Pair<Integer, Integer>(x,y);
        img = new ImageView(Main.SunFlowerImage);
        ResizeImage();
        Summon(x,y);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(8), ev -> {
            ProduceSun();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    private void ProduceSun(){
        try {
            s = new Sun(PresentTile.getKey(),PresentTile.getValue());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Cherrybomb extends Plants implements Attacker {
    Cherrybomb(int x, int y) {
        super(50, 50);
        System.out.println("planting Cherrybomb");
        PresentTile = new Pair<Integer, Integer>(x, y);
        img = new ImageView(Main.CherryBombImage);
        ResizeImage();
        Summon(x, y);
    }

    @Override
    public void Attack() {
        ArrayList<Zombies> victims = new ArrayList<>();
        Blast(victims);
    }

    private void Blast(ArrayList<Zombies> victims) {
        //Implement Blast
    }
}

class Potatomine extends Plants implements Attacker{
    Potatomine(int x, int y){
        super(50,50);
        System.out.println("planting potatomine");
        PresentTile = new Pair<Integer, Integer>(x,y);
        img = new ImageView(Main.PotatoMineImage);
        ResizeImage();
        Summon(x,y);
    }

    @Override
    public void Attack() {

    }
}

class Walnut extends Plants{
    Walnut(int x, int y){
        super(50,50);
        System.out.println("planting Walnut");
        PresentTile = new Pair<Integer, Integer>(x,y);
        img = new ImageView(Main.WallNutImage);
        ResizeImage();
        Summon(x,y);
    }
}

