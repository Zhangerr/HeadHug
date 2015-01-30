/**
 * Created by azhang on 1/29/15.
 */
import java.awt.*;
public class Background {
    private double velocity;
    private double position;
    private double initpos;
    private String file;
    private double width;
    private double initvel;
    public Background(double position, double vel, double w, String f) {
        velocity = vel;
        file = f;
        initvel = vel;
        this.initpos = position;
        this.position = position;
        this.width = w / 2; //since this is actually the "half width"
    }
    public void update(Double dt) {
        position += dt * velocity;
        if(position < -width) {
            position = initpos + width;
        }
    }
    public void stop() {
        velocity = 0;
    }
    public void start() {
        velocity = initvel;
    }
    public void draw() {
        StdDraw.setPenColor(Color.red);
        StdDraw.filledRectangle(50, 0, 50, 20);
        StdDraw.setPenColor(Color.black);
        StdDraw.filledRectangle(position, 0, width, 30);
        StdDraw.filledRectangle(position, 30, 25, 5);

    }
}
