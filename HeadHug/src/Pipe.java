import java.awt.*;
public class Pipe {
    private double velocity;
    private double dt;
    private double position;
    private double width;
    private final double MAXSIZE = 80;
    private String file;
    public Pipe(double position, double velocity, double width, String file) {
        this.file = file;
        this.velocity = velocity;
        this.position = position;
        this.width = width;
    }
    public void update(Double dt) {
        position -= dt * velocity;
    }
    public void stop() {
        velocity = 0;
    }
    public void draw() {
        StdDraw.picture(position, 0, file);

    }
}
