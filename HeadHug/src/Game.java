/**
 * Created by azhang on 1/29/15.
 */
public class Game  {
    public static final double SCALE_MAX = 100;
    public static final double SCALE_MIN = 0;
    public static final double dT = .1;
    static MCharacter c;
    static Background b;
    public static void main(String[] args) {
        StdDraw.setCanvasSize(350,450);
        b = new Background(48,-10, 40,"images/ground.png");
        c = new MCharacter(10, 60, 6, 0);
        if (args.length >= 2) {
            StdDraw.setScale(Double.parseDouble(args[0]),Double.parseDouble(args[1]));
        } else {
            StdDraw.setScale(SCALE_MIN, SCALE_MAX);
        }
        while (true) {
            StdDraw.picture(50,50,"images/background.png",100,100);
            b.update(dT);
            c.update(dT);
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
