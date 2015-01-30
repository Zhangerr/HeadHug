/**
 * Created by azhang on 1/29/15.
 */
import java.awt.*;
public class Background {
    public double velocity;
    public double position;
    public String file;
    public Background(double position, double vel, String f) {
        velocity = vel;
        file = f;
        this.position = position;
    }
    public void update(Double dt) {
        position += dt * velocity;
    }
    public void draw() {
        StdDraw.setPenColor(Color.black);
        StdDraw.filledRectangle(position, 50, 20, 20);
    }
}
