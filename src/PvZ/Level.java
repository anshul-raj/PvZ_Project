package PvZ;

import javax.swing.text.html.ImageView;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Level {
    private ArrayList<Plants> AvaialablePlants = new ArrayList<>();
    private ArrayList<Zombies> ZombiesList = new ArrayList<>();
    private ImageView Prize;
    private final int NumberOfActivePlants;

    public Level(int lvl) {
        if (lvl==1){
            NumberOfActivePlants = 3;
        }
        else {
            NumberOfActivePlants = 5;
        }
    }
}
