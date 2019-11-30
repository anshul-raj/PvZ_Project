package PvZ;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import javafx.util.Pair;
import javafx.scene.image.Image;

import javax.naming.TimeLimitExceededException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.time.Year;

class Sun {
    private int time;
    protected final Pair<Integer,Integer> position;
    protected final ImageView Sunimg = new ImageView(new Image(new FileInputStream("src/PvZ/resources/img/Sun.PNG")));

    public Sun(int x,int y) throws FileNotFoundException {
        Sunimg.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Sun Collected");
                Disappear();
                Main.currentGame.collectedSun();
            }
        });
        position = new Pair<>(x,y);
        Summon(x,y);
        timeline();
    }

    void Disappear(){
        Character.garden.getChildren().remove(Sunimg);
    }

    protected void timeline(){
        Timeline t1 = new Timeline(new KeyFrame(Duration.seconds(0.2),new KeyValue(Sunimg.opacityProperty(),0),
                                                                      new KeyValue(Sunimg.disableProperty(),true)));
        Timeline t2 = new Timeline(new KeyFrame(Duration.seconds(0),e->{
           Disappear();
        }));
        t1.setDelay(Duration.seconds(5));
        SequentialTransition s = new SequentialTransition(t1,t2);
        s.play();
    }

    protected void Summon(int x, int y){
        Sunimg.setFitHeight(Main.sunImageHeight);
        Sunimg.setFitWidth(Main.sunImagewidth);
        Sunimg.relocate(Main.ORIGIN_X+(x* Main.X)+ 50, Main.ORIGIN_Y+(y* Main.Y)+50);
        Character.garden.getChildren().add(Sunimg);
    }
}

class FallingSun extends Sun{
    private final int SPEED = 10;

    FallingSun(int x,int y) throws FileNotFoundException {
        super(x,y);
    }

    @Override
    protected void timeline(){
        Timeline t1 = new Timeline(new KeyFrame(Duration.seconds(((double) position.getValue())/50),
                new KeyValue(Sunimg.layoutYProperty(), position.getValue())));
        Timeline t2 = new Timeline(new KeyFrame(Duration.seconds(3),e->{
            Disappear();
        }));
        SequentialTransition s = new SequentialTransition(t1,t2);
        s.play();
    }

    @Override
    protected void Summon(int x,int y){
        Sunimg.setFitHeight(Main.sunImageHeight);
        Sunimg.setFitWidth(Main.sunImagewidth);
        Sunimg.relocate(x, -3* Main.ORIGIN_Y);
        Character.garden.getChildren().add(Sunimg);
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

interface MyScene{}
class MainMenu implements MyScene{}
class ChooseUser implements MyScene{}
class ChooseLevel implements MyScene{}
class Garden implements MyScene{}
