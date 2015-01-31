import java.awt.*;

/**
 * Created by azhang on 1/30/15.
 * TODO: get rid of magic numbers
 */
public class MCharacter {
    private double yAccel = .82 * 7;
    public double xVelocity, yVelocity,x,y,angle;
    public boolean dead = false;
    private double deathVelocity = -2;
    private boolean previousState = false;
    public MCharacter(double xpos, double ypos, double xVel, double yVel) {
        xVelocity = xVel;
        yVelocity = yVel;
        x = xpos;
        y = ypos;
    }
    public void draw() {
        StdDraw.setPenColor(Color.green);
        StdDraw.picture(x,y,"../images/bird_sing.png", angle);
        if(dead) {
            StdDraw.text(50, 50, "you're dead :(");
        }
    }
    public void die() {
        Game.gameOver();
        dead = true;
    }
    public void restart() {
        dead = false;
        yVelocity = 0;
        Game.start();
    }

    private void checkBoundaries(double dt) {
        if (y > Game.SCALE_MAX) {
            die();
            yVelocity = deathVelocity;

        }
        if (y + yVelocity * dt < 22.5 + 2.8) {
            y = 22.5 + 2.80;
            if(!dead) {
                die();
            }
        }
    }
    private void updateAngle() {

            angle = Math.toDegrees(Math.atan2(yVelocity, xVelocity));
    }
    private void checkMouse(double dt) {
        if(!StdDraw.mousePressed()) {
            previousState = false;
        }
        if(StdDraw.mousePressed() && !previousState ) {
            if(!dead) {
                yVelocity = 0;
                yVelocity += 120 * dt;
            } else {
                restart();
                y = Game.SCALE_MAX / 2;
            }
            previousState = true;
        }
    }
    private void applyPhysics(double dt) {
        if(!dead || y >  22.5 + 2.80) {
            if (yVelocity > -15) {
                yVelocity -= yAccel * dt;
            }
            y += yVelocity * dt;
        }
    }

    public void update(double dt) {
        checkMouse(dt);
        applyPhysics(dt);
        checkBoundaries(dt);
        updateAngle();
    }
}
