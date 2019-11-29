package PvZ;

import javax.swing.text.html.ImageView;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Level implements Serializable {
    private ArrayList<Plants> AvaialablePlants = new ArrayList<>();
    private ArrayList<Zombies> ZombiesList = new ArrayList<>();
    private ImageView Prize;
    private final int NumberOfActivePlants;

    public Level(int lvl) {
        if (lvl == 1 || lvl == 2 || lvl == 3){
            NumberOfActivePlants = 3;
        }
        else{
            NumberOfActivePlants = 5;
        }
        ZombieCreator(lvl);
    }

    private void ZombieCreator(int lvl){
        while(ZombiesList.size()<(20*lvl)){
            if(ZombiesList.size()<10*lvl){
                ZombiesList.add(new Normie());
            }
            else if(ZombiesList.size()<15*lvl){
                ZombiesList.add(new ConeTop());
            }
            else{
                ZombiesList.add(new GangLeader());
            }
        }
    }

    public ArrayList<Zombies> getZombiesList() {
        return ZombiesList;
    }

    public void setZombiesList(ArrayList<Zombies> zombiesList) {
        ZombiesList = zombiesList;
    }
}
