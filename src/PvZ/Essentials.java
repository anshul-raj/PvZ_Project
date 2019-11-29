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
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class Sun {
    private int time;
    protected final Pair<Integer,Integer> position;
    private final ImageView Sunimg = new ImageView(new Image(new FileInputStream("src/PvZ/resources/img/Sun.PNG")));

    public Sun(int x,int y) throws FileNotFoundException {
        Sunimg.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Disappear();
                Main.currentGame.collectedSun();
            }
        });
        position = new Pair<>(x,y);
        Summon(x,y);
        timeline();
    }

    private void Disappear(){
        Character.gardenGrid.getChildren().remove(Sunimg);
    }

    private void timeline(){
        Timeline t1 = new Timeline(new KeyFrame(Duration.seconds(0.2),new KeyValue(Sunimg.opacityProperty(),0),
                                                                      new KeyValue(Sunimg.disableProperty(),true)));

        t1.setDelay(Duration.seconds(5));
        t1.play();
        Disappear();
    }

    private void Summon(int x, int y){
        Sunimg.setFitHeight((double) Main.PlantImageHeight/2);
        Sunimg.setFitWidth((double) Main.PlantImageWidth/2);
        Sunimg.relocate(Main.ORIGIN_X+(x* Main.X)+ 5, Main.ORIGIN_Y+(y* Main.Y)+5);
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
