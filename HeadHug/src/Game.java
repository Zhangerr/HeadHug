import java.awt.*;


/**
 * Created by azhang on 1/29/15.
 */
public class Game  {
    public static final double SCALE_MAX = 100;
    public static final double SCALE_MIN = 0;
    public static final double dT = .1;
    static Character c;
    static Background b;
    static Pipe p;
    public static void main(String[] args) {
        StdDraw.setCanvasSize(350,450);
        b = new Background(48,-10, 40,"../images/ground.png");
        c = new Character(10, 60, 6, 0);
        pTop = new Pipe(10,5, 40,"tube2.png");
        pBot = new Pipe(10,5, 40,"tube1.png");
        if (args.length >= 2) {
            StdDraw.setScale(Double.parseDouble(args[0]),Double.parseDouble(args[1]));
        } else {
            StdDraw.setScale(SCALE_MIN, SCALE_MAX);
        }
        while (true) {
            StdDraw.picture(50,50,"../images/background.png",100,100);
            b.update(dT);
            c.update(dT);
            p.update(dT);


            p.draw();
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
