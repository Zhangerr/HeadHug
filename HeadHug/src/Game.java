/**
 * Created by azhang on 1/29/15.
 */
import java.util.Random;
public class Game  {
    public static final double SCALE_MAX = 100;
    public static final double SCALE_MIN = 0;
    public static final double dT = .1;
    static int velocity = 5;
    static MCharacter c;
    static Background b;
    static Pipe [] allPipes = new Pipe[3];
    static String topPipeImg = "../images/tube1.png";
    static String bottomPipeImg = "../images/tube2.png";
    static Random randomGenerator = new Random();

    public static void main(String[] args) {
        StdDraw.setCanvasSize(350,450);
        b = new Background(48,-velocity, 40,"../images/ground.png");
        c = new MCharacter(10, 60, 6, 0);

        

        int randomInt = randomGenerator.nextInt(30);
        for (int i = 0; i<allPipes.length; i+=1){
            randomInt = randomGenerator.nextInt(30);
            allPipes[i] = new Pipe(100+i*45, velocity, topPipeImg, bottomPipeImg, randomInt);

        } 


        if (args.length >= 2) {
            StdDraw.setScale(Double.parseDouble(args[0]),Double.parseDouble(args[1]));
        } else {
            StdDraw.setScale(SCALE_MIN, SCALE_MAX);
        }
        while (true) {
            StdDraw.picture(50,50,"../images/background.png",100,100);

            b.update(dT);
            c.update(dT);

            for (int i = 0; i<allPipes.length; i+=1){
                if (allPipes[i].xPosition == -5){
                    randomInt = randomGenerator.nextInt(30);
                    allPipes[i].xPosition=135;
                    allPipes[i].yPosition=95 + randomInt;
                    allPipes[i].yPosition2=0 + randomInt;
                }
                if (Math.round(allPipes[i].xPosition - 7.4) == c.x){
                    System.out.println("0collision");
                    if (allPipes[i].yPosition > c.y+50 || allPipes[i].yPosition2<c.y-57){
                        c.die();
                        for (int b = 0; b<allPipes.length; b+=1){
                            allPipes[b].stop();
                        }
                    }
                }
                allPipes[i].update(dT);
                allPipes[i].draw();
            } 


            b.draw();
            c.draw();
            StdDraw.show(10);


        }
    }
    public static void gameOver() {
        b.stop();
        for(int i = 0; i<allPipes.length; i+=1) {
            allPipes[i].stop();
        }
    }
    public static void start() {
        b.start();
        for(int i = 0; i<allPipes.length; i+=1) {
            allPipes[i].start();
        }
    }

}
