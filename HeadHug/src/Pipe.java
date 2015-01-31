import java.util.Random;
import java.awt.*;
public class Pipe {
    private double velocity;
    private double dt;
    public double xPosition;
    public double yPosition;
    private double width;
    private Pipe pTop;
    private Pipe pBot;
    static Random randomGenerator = new Random();
    private int randomInt = randomGenerator.nextInt(30);
    private String file;
    public Pipe(double xPosition, double yPosition, double velocity, double width, String file) {
        this.file = file;
        this.velocity = velocity;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
    }

    public void randomPosition(Pipe[] pipes) {
        if (pTop.xPosition == -5){
            randomInt = randomGenerator.nextInt(30);
            pTop.xPosition=105;
            pBot.xPosition=105; 
            pTop.yPosition=95 + randomInt;
            pBot.yPosition=0 + randomInt; 
        }
    }
    public void update(Double dt) {
        xPosition -= dt * velocity;
        if(xPosition < -50) {
            xPosition = Game.SCALE_MAX + 50;
        }

    }
    public void stop() {
        velocity = 0;
    }
    public void draw() {
        StdDraw.picture(xPosition, yPosition, file);

    }


/*    private void checkBoundaries(double dt) {
        if (y > Game.SCALE_MAX) {
            MCharacter.die;
            yVelocity = deathVelocity;

        }
        if (y + yVelocity * dt < 22.5 + 2.8) {
            y = 22.5 + 2.80;
            if(!MCharacter.dead {
                die();
            }
        }*/
    
}
