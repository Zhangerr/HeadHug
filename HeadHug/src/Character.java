import java.awt.*;

/**
 * Created by azhang on 1/30/15.
 */
public class Character {
    private double accel_y = .82 * 5;
    private double xVelocity, yVelocity,x,y,angle;
    private boolean dead = false;
    private boolean previousState = false;
    public Character(double xpos, double ypos, double xVel, double yVel) {
        xVelocity = xVel;
        yVelocity = yVel;
        x = xpos;
        y = ypos;
    }
    public void draw() {
        StdDraw.setPenColor(Color.green);
        StdDraw.text(x,y,"testing", angle);

    }
    public void kickUp() {
        yVelocity += 100;
    }
    public void die() {
        Game.gameOver();
        dead = true;
    }
    public void restart() {
        dead = false;
        Game.start();
    }
    public void update(double dt) {
        if(!StdDraw.mousePressed()) {
            previousState = false;
        }
        if(StdDraw.mousePressed() && !previousState ) {
            if(!dead) {
                if (yVelocity < 0) {
                    yVelocity = 0;
                }
                yVelocity += 150 * dt;
            } else {
                restart();
                y = 50;
            }
            previousState = true;
        }
        if (yVelocity > -15) {
            yVelocity -= accel_y * dt;
        }
        if (y > 100) {
            die();
            yVelocity = -2;

        }
        if (y < 0) {
            yVelocity = 0;
            y = 0;
            if(!dead) {
                die();
            }
        }
        if(dead) {
            StdDraw.text(50, 50, "you're dead :(");
        }
        y += yVelocity * dt;
        if (!dead) {
            angle = Math.toDegrees(Math.atan2(yVelocity, xVelocity));
        }
        else {
            angle = 0;
        }
    }
}
