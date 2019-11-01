package PvZ;

import com.sun.org.apache.bcel.internal.generic.IADD;
import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Projectile {
    final int SPEED = 10;
    protected int x,y;

    public Projectile(int x, int y, Pane p){

    }

    public void dissapear(){

    }
}

class Pea extends  Projectile{
    private final int DAMAGE = 10;
    FileInputStream input;
    ImageView i;

    public Pea(int x, int y,Pane p){
        super(x, y, p);
        try{
            input = new FileInputStream("src/PvZ/resources/img/ProjectilePea.png");
            this.i = new ImageView(new Image(input));
            this.i.relocate(x,y);
            i.setOpacity(1);

            KeyValue k = new KeyValue(i.layoutXProperty(),930);
            KeyValue appear = new KeyValue(i.opacityProperty(),1);
            Timeline t1 = new Timeline(new KeyFrame(Duration.seconds(0.1),appear));
            Timeline t2 = new Timeline(new KeyFrame(Duration.seconds((930-i.getX())/300),k));
            
            SequentialTransition s = new SequentialTransition(t1,t2);
            s.setCycleCount(TranslateTransition.INDEFINITE);
            p.getChildren().add(this.i);
            s.play();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
