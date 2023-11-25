import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    protected double x, y, vx = 0, vy = 0, ay;
    protected ImageView imageView;
    protected int attitude; // attitude value : 0, still // 1 : running // 2 : jumping up // 3 : jumping down
    protected int indexFrame;
    protected int maximumIndex;
    protected int windowSizeX;
    protected int windowSizeY;
    protected int pixelOffsetX;
    protected int pixelOffsetY;

    public AnimatedThing(double x, double y, int maximumIndex, int windowSizeX, int windowSizeY, int pixelOffsetX, int pixelOffsetY, String fileName) {
        attitude = 0;
        indexFrame = 0;
        this.x = x;
        this.y = y;
        this.maximumIndex = maximumIndex;
        this.windowSizeX = windowSizeX;
        this.windowSizeY = windowSizeY;
        this.pixelOffsetX = pixelOffsetX;
        this.pixelOffsetY = pixelOffsetY;
        this.imageView = new ImageView(new Image(fileName));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getWindowSizeX() {
        return windowSizeX;
    }

    public int getWindowSizeY() {
        return windowSizeY;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public ImageView getImageView() {
        return imageView;
    }
    public void update(long time) {
        indexFrame = ((int) (time/1e8))%maximumIndex;
        imageView.setViewport(new Rectangle2D(indexFrame*windowSizeX,0, windowSizeX, windowSizeY));
        x += vx * 0.016;
        ay = 500;
        vy += ay * 0.016;
        y += vy * 0.016;
        if(y > 250) y = 250;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }
}
