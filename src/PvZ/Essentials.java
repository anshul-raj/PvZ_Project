package PvZ;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import javafx.util.Pair;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.Key;
import java.sql.Time;

class Sun {
    private int time;
    protected final Pair<Integer,Integer> position;
    private final ImageView Sunimg = new ImageView(new Image(new FileInputStream("src/PvZ/resources/img/Sun.PNG")));

    public Sun(int x,int y) throws FileNotFoundException {
        position = new Pair<>(x,y);
        Summon(x,y);
    }

    public void Dissapear(){
        Character.garden.getChildren().remove(Sunimg);
    }

    public void timeline(){
        Timeline t1 = new Timeline(new KeyFrame(Duration.seconds(10)));
        Timeline t2 = new Timeline(new KeyFrame(Duration.seconds(0.2),new KeyValue(Sunimg.opacityProperty(),0)));
        SequentialTransition sqt = new SequentialTransition(t1,t2);
        sqt.play();
        Dissapear();
    }

    public void Summon(int x, int y){
        Sunimg.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dissapear();
            }
        });
        Sunimg.setFitHeight(Application_PvZ.ImageHeight);
        Sunimg.setFitWidth(Application_PvZ.ImageWidth);
        Sunimg.relocate(Application_PvZ.ORIGIN_X+(x* Application_PvZ.X), Application_PvZ.ORIGIN_Y+(y* Application_PvZ.Y));
        Character.garden.getChildren().add(Sunimg);
    }
}

class FallingSun extends Sun{
    private final int SPEED = 10;

    FallingSun(int x,int y) throws FileNotFoundException {
        super(x,y);
    }

    public void Fall(){

    }
}

class LawnMovers {

}

class Showel{

}

class ZeroHealthException extends Exception{

}

class GameOverException extends Exception{

}

class SunCollectedException extends Exception{

}
