public class Camera {
    private int x;
    private int y;
    private double ax, ay;
    private double vx, vy;



    public Camera(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void incX(int x){
        this.x += x;
    }

    public void incY(int y){
        this.y += y;
    }

    public void update(long time, long deltaTime, Hero hero){
        if(deltaTime < 100) {
            ax = 5*((double)(hero.getX() - x) - 1.2 * vx);
            vx += (ax * (double)deltaTime) / 1000;
            x += (vx * (double)deltaTime) / 1000;
            System.out.println(deltaTime);
        }
    }
    @Override
    public String toString() {
        return "Camera{" + x + ", " + y +'}';
    }
}
