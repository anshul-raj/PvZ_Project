package PvZ;

import java.util.ArrayList;

public class Game {
     private final ArrayList<Plants> PlantsPlanted = new ArrayList<>();
     private int SunsCollected = 0;
     private final Level PresentLevel;
     private final ArrayList<LawnMovers> LawnMoversActive = new ArrayList<LawnMovers>();
     private final ArrayList<Sun> UncollectedSun = new ArrayList<Sun>();

    public Game(int lvl) {
        PresentLevel = new Level(lvl);
    }

    public void ProduceSun(){

    }

    public void RestartGame() {

    }
}
