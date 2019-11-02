package PvZ;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Pair;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class Plants extends Character{
    protected final int COST;
    protected final int COOLDOWNTIMER;

    Plants(int cost, int cooldowntimer) {
        COST = cost;
        COOLDOWNTIMER = cooldowntimer;
    }
}

class PeaShooter extends Plants{
    private final int LAUNCHINTEVAL = 5;

    PeaShooter(int x,int y){
        super(50,50);
        System.out.println("Planting Peashooter");
        PresentTile = new Pair<Integer, Integer>(x,y);
        try{
            FileInputStream input = new FileInputStream("src/PvZ/resources/img/PeaShooter.gif");
            Image i = new Image(input);
            this.img = new ImageView(i);
            Summon(x,y);
            Launch();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void Launch(){
        Projectile p = new Pea(Main.ORIGIN_X+(PresentTile.getKey()*Main.X)+78
                ,Main.ORIGIN_Y+(PresentTile.getValue()*Main.Y)+25,garden);
    }
}

class Sunflower extends Plants{
    Sunflower(int x,int y){
        super(50,50);
        System.out.println("Planting Sunflower");
        PresentTile = new Pair<Integer, Integer>(x,y);
        try{
            FileInputStream input = new FileInputStream("src/PvZ/resources/img/Sunflower.gif");
            Image i = new Image(input);
            img = new ImageView(i);
            Summon(x,y);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}

class Cherrybomb extends Plants{
    Cherrybomb(int x, int y){
        super(50,50);
        System.out.println("planting Cherrybomb");
        PresentTile = new Pair<Integer, Integer>(x,y);
        try{
            FileInputStream input = new FileInputStream("src/PvZ/resources/img/Zombie1.png");
            Image i = new Image(input);
            img = new ImageView(i);
            Summon(x,y);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}

class Potatomine extends Plants{
    Potatomine(int x, int y){
        super(50,50);
        System.out.println("planting potatomine");
        PresentTile = new Pair<Integer, Integer>(x,y);
        try{
            FileInputStream input = new FileInputStream("src/PvZ/resources/img/Potatomine.gif");
            Image i = new Image(input);
            img = new ImageView(i);
            Summon(x,y);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}

class Walnut extends Plants{
    Walnut(int x, int y){
        super(50,50);
        System.out.println("planting Walnut");
        PresentTile = new Pair<Integer, Integer>(x,y);
        try{
            FileInputStream input = new FileInputStream("src/PvZ/resources/img/Wall-nut1.png");
            Image i = new Image(input);
            img = new ImageView(i);
            Summon(x,y);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}

