package PvZ;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Serializable {
     private final Plants[][] PlantsPlanted = new Plants[9][5];
     private int SunsCollected = 0;
     private final Level PresentLevel;
     private final ArrayList<LawnMovers> LawnMoversActive = new ArrayList<>();
     private final ArrayList<Sun> UncollectedSun = new ArrayList<>();
     public String PlantSelected = null;

    public Game(int lvl) {
        PresentLevel = new Level(lvl);
    }
    // getters and setters --------------


    public Plants[][] getPlantsPlanted() {
        return PlantsPlanted;
    }

    public int getSunsCollected() {
        return SunsCollected;
    }

    //----------------------------------

    public void ProduceSun(){

    }

    public void RestartGame() {

    }

    public void collectedSun(){
        SunsCollected+=25;
        Main.app.gamecontroller.UpdateSuns();
    }

    private void SunGenerator() {
//        if (PresentLevel.getZombiesList().size() > 0) {
            Random r = new Random();
            int width = 1000;
            int height = 714;
            int location_X = 100 + r.nextInt(width-100);
            int location_Y = height - 3*Main.ORIGIN_Y;
            try {
                Sun s = new FallingSun(location_X, location_Y);
            } catch (FileNotFoundException e) {
                System.out.println("Its night, no suns left!!");
            }
//        }
    }

    public void load(Node n){
        try {
            Main.app.ChangeScreen(n,new Garden());
        } catch (IOException e) {
            e.printStackTrace();
        }
        PresentLevel.ZombieCreator();
        SunGenerator();
        Timeline t = new Timeline(new KeyFrame(Duration.seconds(1),e->{
            SunGenerator();
        }));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }

    public void PlacePlant(Plants p){
        this.PlantsPlanted[p.PresentTile.getKey()][p.PresentTile.getValue()] = p;
    }

    public void RemovePlant(Plants p){
        this.PlantsPlanted[p.PresentTile.getKey()][p.PresentTile.getValue()] = null;
    }

    public void RemoveZombie(Zombies z){}
}
