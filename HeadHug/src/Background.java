/**
 * Created by azhang on 1/29/15.
 */
public class Background {
    private double velocity;
    private double position;
    private double initpos;
    private String file;
    private double width;
    private double initvel;
    private double position2;
    public Background(double position, double vel, double w, String f) {
        velocity = vel;
        file = f;
        initvel = vel;
        this.initpos = position;
        this.position = position;
        this.position2 = position + 100;
        this.width = w / 2; //since this is actually the "half width"
    }
    public void update(Double dt) {
        position += dt * velocity;
        position2 += dt * velocity;
        if(position < -50) {
            position = Game.SCALE_MAX + 50;
        }
        if (position2 < -50) {
            position2 = Game.SCALE_MAX + 50;
        }
    }
    public void stop() {
        velocity = 0;
    }
    public void start() {
        velocity = initvel;
    }
    public void draw() {
        //336 x 112
        StdDraw.picture(position, 10, file, 101, 25);
        StdDraw.picture(position2, 10, file, 101, 25);
    }
}
