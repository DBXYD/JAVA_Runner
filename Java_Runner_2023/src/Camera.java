public class Camera {
    private int x;
    private int y;

    private double x_pos = 0;
    private double y_pos = 0;
    private double ax = 0;
    private double ay = 0;
    private double vx = 0;
    private double vy = 0;



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
            double dt = (double) deltaTime;
            ax = ((hero.getX() - x_pos - 100) - 1.414 * (vx- hero.getVx()));
            vx += (ax * ((double)deltaTime)) / 1000.0;
            x_pos += (vx * ((double)deltaTime)) / 1000.0;
            x = (int) x_pos;
        }
    }
    @Override
    public String toString() {
        return "{x = " + x_pos + ", vx = " + vx +", ax = " + ax + "}";
    }
}
