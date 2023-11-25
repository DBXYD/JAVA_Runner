import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing{

    public Hero(double x, double y) {
        super(x, y, 6, 84, 98, 84, 163,"img/heros.png");
    }

    public Hero() {
        super(0,0, 6, 84, 98, 84, 163,"img/heros.png");
    }
}
