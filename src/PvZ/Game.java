package PvZ;

import javafx.scene.Node;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Serializable {
     private final Plants[][] PlantsPlanted = new Plants[8][5];
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
        if (PresentLevel.getZombiesList().size() > 0) {
            Random r = new Random();
            int width = 1111;
            int height = 714;
            int location_X = r.nextInt(width) + Main.ORIGIN_X;
            int location_Y = Main.ORIGIN_Y + height;
            try {
                Sun s = new FallingSun(location_X, location_Y);
            } catch (FileNotFoundException e) {
                System.out.println("Its night, no suns left!!");
            }
        }
    }

    public void load(Node n){
        try {
            Main.app.ChangeScreen(n,new Garden());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PlacePlant(Plants p){
        this.PlantsPlanted[p.PresentTile.getKey()][p.PresentTile.getValue()] = p;
    }

    public void RemovePlant(Plants p){
        this.PlantsPlanted[p.PresentTile.getKey()][p.PresentTile.getValue()] = null;
    }
}
