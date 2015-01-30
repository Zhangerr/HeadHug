import java.awt.*;


/**
 * Created by azhang on 1/29/15.
 */
public class Game  {
    public static final double SCALE_MAX = 100;
    public static final double SCALE_MIN = 0;
    static Character c;
    static Background b;
    public static void main(String[] args) {
        b = new Background(100,-10, 40,"");
        c = new Character(10, 60, 2, 0);
        if (args.length >= 2) {
            StdDraw.setScale(Double.parseDouble(args[0]),Double.parseDouble(args[1]));
        } else {
            StdDraw.setScale(SCALE_MIN, SCALE_MAX);
        }
        for(double i = 0; i < 10000000; i+=1) {
            StdDraw.clear();
            b.update(.1);
            c.update(.1);

            b.draw();
            c.draw();
            StdDraw.show(10);
        }
    }
    public static void gameOver() {
        b.stop();
    }
    public static void start() {
        b.start();
    }

}
