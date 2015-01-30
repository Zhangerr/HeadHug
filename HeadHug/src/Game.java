import java.awt.*;

/**
 * Created by azhang on 1/29/15.
 */
public class Game {
    public static void main(String[] args) {
        Background b = new Background(100,-2,"");
        StdDraw.setScale(0,100);

        for(double i = 0; i < 1000; i+=.01) {
//            StdDraw.setPenColor(Color.white);
//            StdDraw.filledRectangle(0,0,50,50);
            StdDraw.clear();

            b.update(.1);
            b.draw();
            StdDraw.show(10);
        }
    }
}
