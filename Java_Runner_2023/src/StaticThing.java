import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {
    private double sizeX;
    private double sizeY;
    ImageView imageView;

    public StaticThing(double sizeX, double sizeY, String fileName) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.imageView = new ImageView(new Image(fileName));
    }

    public double getSizeX() {
        return sizeX;
    }

    public double getSizeY() {
        return sizeY;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
