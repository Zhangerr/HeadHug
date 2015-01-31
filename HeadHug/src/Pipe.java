import java.util.Random;
import java.awt.*;
public class Pipe {
    public double velocity;
    public double dt;
    public double xPosition;
    public double yPosition,origVel;
    public double yPosition2;
    public String file;
    public String file2;
    static Random randomGenerator = new Random();
    public int randomInt = randomGenerator.nextInt(30);
    public Pipe(double xPosition, double velocity, String file, String file2, int random) {
        this.file = file;
        this.file2 = file2;
        this.velocity = velocity;
        this.xPosition = xPosition;
        this.yPosition = 95 + random;
        this.yPosition2 = random;
        this.origVel = velocity;

    }

/*    public void randomPosition(Pipe[] pipes) {
        if (pTop.xPosition == -5){
            randomInt = randomGenerator.nextInt(30);
            pTop.xPosition=105;
            pBot.xPosition=105; 
            pTop.yPosition=95 + randomInt;
            pBot.yPosition=0 + randomInt; 
        }
    }*/
    public void update(Double dt) {
        xPosition -= dt * velocity;
        if(xPosition < -50) {
            xPosition = Game.SCALE_MAX + 50;
        }

    }
    public void start() {
        velocity = origVel;
    }
    public void stop() {
        velocity = 0;
    }
    public void draw() {
        StdDraw.picture(xPosition, yPosition, file);
        StdDraw.picture(xPosition, yPosition2, file2);

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
