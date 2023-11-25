import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameScene extends Scene {
    Camera camera;
    StaticThing backgroundLeft;
    StaticThing backgroundRight;


    public GameScene(Group root) {
        super(root);
        camera = new Camera(0,100);
        backgroundLeft = new StaticThing(800, 400, "img/desert.png");
        backgroundRight = new StaticThing(800,400, "img/desert.png");
        root.getChildren().add(backgroundLeft.getImageView());
        root.getChildren().add(backgroundRight.getImageView());


        AnimationTimer timer = new AnimationTimer(){
            public void handle(long time){
                camera.setX(time/1000000);
                render();
            }
        };

        timer.start();
    }

    public void render(){
        backgroundLeft.getImageView().setX(0);
        backgroundLeft.getImageView().setY(0);
        backgroundLeft.getImageView().setViewport(new Rectangle2D(camera.getX()%800, camera.getY(), 800-camera.getX()%800,300));
        backgroundRight.getImageView().setX(800-camera.getX());
        backgroundRight.getImageView().setY(0);
        backgroundRight.getImageView().setViewport(new Rectangle2D(0, camera.getY(), 800,300));

    }


}
