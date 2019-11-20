package PvZ;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {
     private final ArrayList<Plants> PlantsPlanted = new ArrayList<>();
     private int SunsCollected = 0;
     private final Level PresentLevel;
     private final ArrayList<LawnMovers> LawnMoversActive = new ArrayList<>();
     private final ArrayList<Sun> UncollectedSun = new ArrayList<>();

    public Game(int lvl) {
        PresentLevel = new Level(lvl);
    }
    // getters and setters --------------

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
}
