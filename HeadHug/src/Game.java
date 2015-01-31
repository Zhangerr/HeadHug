/**
 * Created by azhang on 1/29/15.
 */
import java.util.Random;
public class Game  {
    public static final double SCALE_MAX = 100;
    public static final double SCALE_MIN = 0;
    public static final double dT = .1;
    static MCharacter c;
    static Background b;
    static Pipe pTop;
    static Pipe pBot;
    static Pipe pTop2;
    static Pipe pBot2;
    static Pipe pTop3;
    static Pipe pBot3;
    static String topPipeImg = "../images/tube1.png";
    static String bottomPipeImg = "../images/tube2.png";
    static Random randomGenerator = new Random();

    public static void main(String[] args) {
        StdDraw.setCanvasSize(350,450);
        b = new Background(48,-5, 40,"../images/ground.png");
        c = new MCharacter(10, 60, 6, 0);

        

        int randomInt = randomGenerator.nextInt(30);
        int randomInt2 = randomGenerator.nextInt(30);
        int randomInt3 = randomGenerator.nextInt(30);
        pTop = new Pipe(100, 95+randomInt, 5, 40,"../images/tube1.png");  //Top y Value should be n + 90. It should not exceed 120 or be below 80.
        pBot = new Pipe(100, 0+randomInt, 5, 40,"../images/tube2.png");   // Top y value should be n. It should not be lower than 0 or greater than 30.
        pTop2 = new Pipe(145, 95+randomInt2, 5, 40,"../images/tube1.png");
        pBot2 = new Pipe(145, 0+randomInt2, 5, 40,"../images/tube2.png");
        pTop3 = new Pipe(190, 95+randomInt3, 5, 40,"../images/tube1.png");
        pBot3 = new Pipe(190, 0+randomInt3, 5, 40,"../images/tube2.png");

        if (args.length >= 2) {
            StdDraw.setScale(Double.parseDouble(args[0]),Double.parseDouble(args[1]));
        } else {
            StdDraw.setScale(SCALE_MIN, SCALE_MAX);
        }
        while (true) {
            StdDraw.picture(50,50,"../images/background.png",100,100);

            b.update(dT);
            c.update(dT);

            if (pTop.xPosition == -5){
                randomInt = randomGenerator.nextInt(30);
                pTop.xPosition=135;
                pBot.xPosition=135; 
                pTop.yPosition=95 + randomInt;
                pBot.yPosition=0 + randomInt; 
            }

            if (pTop2.xPosition == -5){
                randomInt = randomGenerator.nextInt(30);
                pTop2.xPosition=135;
                pBot2.xPosition=135;
                pTop2.yPosition=95 + randomInt;
                pBot2.yPosition=0 + randomInt; 
            }


            if (pTop3.xPosition == -5){
                randomInt = randomGenerator.nextInt(30);
                pTop3.xPosition=135;
                pBot3.xPosition=135;
                pTop3.yPosition=95 + randomInt;
                pBot3.yPosition=0 + randomInt; 
            }


            pTop.update(dT);
            pBot.update(dT);
            
            pTop2.update(dT);
            pBot2.update(dT);

            pTop3.update(dT);
            pBot3.update(dT);



            pBot.draw();
            pTop.draw();

            pTop2.draw();
            pBot2.draw();

            pTop3.draw();
            pBot3.draw();


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
