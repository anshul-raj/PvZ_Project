package PvZ;

import javax.swing.text.html.ImageView;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Level implements Serializable {
    private ArrayList<String> AvaialablePlants = new ArrayList<>();
    private ArrayList[] ZombiesList = new ArrayList[5];
    private ImageView Prize;
    private final int NumberOfActivePlants;
    private int ThisLevel;

    public Level(int lvl) {
        ThisLevel = lvl;
        for (int i=0;i<5;i++){
            ZombiesList[i] = new ArrayList<Zombies>();
        }
        if (lvl == 1 || lvl == 2 || lvl == 3){
            NumberOfActivePlants = 3;
            AvaialablePlants.add("PeaShooter");
            AvaialablePlants.add("Sunflower");
            AvaialablePlants.add("WallNut");
        }
        else{
            NumberOfActivePlants = 5;
            AvaialablePlants.add("PeaShooter");
            AvaialablePlants.add("Sunflower");
            AvaialablePlants.add("WallNut");
            AvaialablePlants.add("CherryBomb");
            AvaialablePlants.add("PotatoMine");
        }
    }

    public ArrayList<String> getAvaialablePlants() {
        return AvaialablePlants;
    }

    public void setAvaialablePlants(ArrayList<String> avaialablePlants) {
        AvaialablePlants = avaialablePlants;
    }

    public void ZombieCreator(){
        int lvl = ThisLevel;
        Random r = new Random();
        int temp = ZombiesList[0].size() + ZombiesList[1].size() + ZombiesList[2].size()+
                ZombiesList[3].size() + ZombiesList[4].size();
        while(temp<(20*lvl)){
            int tempInt = r.nextInt(5);
            if(temp<10*lvl){
                ZombiesList[tempInt].add(new Normie(tempInt));
            }
            else if(temp<15*lvl){
                ZombiesList[tempInt].add(new ConeTop(tempInt));
            }
            else{
                ZombiesList[tempInt].add(new GangLeader(tempInt));
            }
        }
    }
}
