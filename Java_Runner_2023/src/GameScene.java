import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class GameScene extends Scene {
    Camera camera;
    StaticThing backgroundLeft;
    StaticThing backgroundRight;
    Hero hero;


    public GameScene(Group root) {
        super(root);
        camera = new Camera(0,100);
        backgroundLeft = new StaticThing(800, 400, "img/desert.png");
        backgroundRight = new StaticThing(800,400, "img/desert.png");
        hero = new Hero(100, 250);

        AnimationTimer timer = new AnimationTimer(){
            long lastTime = 0;
            public void handle(long time){
                long delta_ms = (long) ((time-lastTime)/1e6);
                lastTime = time;
                hero.update(time);
                camera.update(time, delta_ms, hero);
                update(time);
            }
        };

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case D:
                        hero.setVx(hero.getVx()+10);
                        break;
                    case Q:
                        hero.setVx(hero.getVx()-10);
                        break;
                    case Z:
                        hero.setVy(-500);
                }

            }
        });

        render(root);
        timer.start();
    }

    public  void render(Group root){
        root.getChildren().add(backgroundLeft.getImageView());
        root.getChildren().add(backgroundRight.getImageView());
        root.getChildren().add(hero.getImageView());
    }
    public void update(long time){
        backgroundLeft.getImageView().setX(0);
        backgroundLeft.getImageView().setY(0);
        backgroundLeft.getImageView().setViewport(new Rectangle2D(camera.getX()%800, camera.getY(), 800-camera.getX()%800,300));
        backgroundRight.getImageView().setX(800-camera.getX()%800);
        backgroundRight.getImageView().setY(0);
        backgroundRight.getImageView().setViewport(new Rectangle2D(0, camera.getY(), 800,300));
        hero.getImageView().setX(hero.getX()-camera.getX());
        hero.getImageView().setY(hero.getY()-camera.getY());

    }
}
