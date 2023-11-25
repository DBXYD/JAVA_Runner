import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        GameScene gameScene = new GameScene(root);
        primaryStage.setTitle("Java Runner 2023 by N.P.");
        primaryStage.setWidth(600);
        primaryStage.setHeight(300);
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}