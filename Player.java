import java.awt.event.KeyEvent;
import java.util.*;

public class Player {
    public static double x = 50;
    public static double y = 100;
    public static double size = 7;

    public static double xVel = 0;
    public static double yVel = 0;
    public static double accel = 0.0025;
    public static double decel = 0.98;

    public static double speed = 1.0;
    public static double shotSpeed = 0.2;
    public static double shotRate = 1.0;
    public static double range = 500;
    public static double damage = 3;
    
    public static final double initialDelay = shotRate * 200;
    public static double delay = initialDelay;
    
    public static ArrayList<String> items = new ArrayList<String>();

    public static List<List<Double>> tears = new ArrayList<List<Double>>(); //x,y,xvel,yvel,distance

    public static void move() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_W) && StdDraw.isKeyPressed(KeyEvent.VK_D)) {
            if (xVel < speed) xVel += accel * 0.707;
            if (yVel < speed) yVel += accel * 0.707;
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_W) && StdDraw.isKeyPressed(KeyEvent.VK_A)) {
            if (xVel < speed) xVel -= accel * 0.707;
            if (yVel < speed) yVel += accel * 0.707;
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_S) && StdDraw.isKeyPressed(KeyEvent.VK_D)) {
            if (xVel < speed) xVel += accel * 0.707;
            if (yVel < speed) yVel -= accel * 0.707;
            eyesDown();
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_S) && StdDraw.isKeyPressed(KeyEvent.VK_A)) {
            if (xVel < speed) xVel -= accel * 0.707;
            if (yVel < speed) yVel -= accel * 0.707;
            eyesDown();
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
            if (xVel < speed) xVel += accel;
            eyesRight();
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
            if (xVel > -speed) xVel -= accel;
            eyesLeft();
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
            if (yVel < speed) yVel += accel;
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
            if (yVel > -speed) yVel -= accel;
            eyesDown();
        } else {
            eyesDown();
        }

        xVel *= decel;
        x += xVel;

        yVel *= decel;
        y += yVel;

        if (-0.001 < xVel && xVel < 0.001) xVel = 0;
        if (-0.001 < yVel && yVel < 0.001) yVel = 0;

        if (x > 200 - size) x = 200 - size;
        if (x < size) x = size;
        if (y > 200 - size) y = 200 - size;
        if (y < size) y = size;
    }

    public static void shoot() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_UP) && delay < 0) {
            List<Double> temp = new ArrayList<Double>();
            temp.add(x);
            temp.add(y);
            temp.add(0.0);
            temp.add(shotSpeed + yVel);
            temp.add(0.0);
            tears.add(temp);
            delay = initialDelay;
        }
        
        if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && delay < 0) {
            List<Double> temp = new ArrayList<Double>();
            temp.add(x);
            temp.add(y);
            temp.add(0.0);
            temp.add(-shotSpeed + yVel);
            temp.add(0.0);
            tears.add(temp);
            delay = initialDelay;
        }
        
        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && delay < 0) {
            List<Double> temp = new ArrayList<Double>();
            temp.add(x);
            temp.add(y);
            temp.add(-shotSpeed + xVel);
            temp.add(0.0);
            temp.add(0.0);
            tears.add(temp);
            delay = initialDelay;
        }
        
        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && delay < 0) {
            List<Double> temp = new ArrayList<Double>();
            temp.add(x);
            temp.add(y);
            temp.add(shotSpeed + xVel);
            temp.add(0.0);
            temp.add(0.0);
            tears.add(temp);
            delay = initialDelay;
        }
    }

    public static void eyesDown() {
        StdDraw.setPenColor(120, 220, 255);
        StdDraw.filledRectangle(x - 3, y - 3, 1, 3);
        StdDraw.filledRectangle(x + 3, y - 3, 1, 3);

        StdDraw.setPenColor(0, 0, 0);
        StdDraw.filledCircle(x - 3, y, size - 5);
        StdDraw.filledCircle(x + 3, y, size - 5);

        StdDraw.setPenColor(255, 255, 255);
        StdDraw.filledCircle(x - 3.5, y + 0.5, size - 6.25);
        StdDraw.filledCircle(x + 2.5, y + 0.5, size - 6.25);
    }

    public static void eyesLeft() {
        StdDraw.setPenColor(120, 220, 255);
        StdDraw.filledRectangle(x - 3, y - 3, 1, 3);

        StdDraw.setPenColor(0, 0, 0);
        StdDraw.filledCircle(x - 3, y, size - 5);

        StdDraw.setPenColor(255, 255, 255);
        StdDraw.filledCircle(x - 3.5, y + 0.5, size - 6.25);
    }

    public static void eyesRight() {
        StdDraw.setPenColor(120, 220, 255);
        StdDraw.filledRectangle(x + 3, y - 3, 1, 3);

        StdDraw.setPenColor(0, 0, 0);
        StdDraw.filledCircle(x + 3, y, size - 5);

        StdDraw.setPenColor(255, 255, 255);
        StdDraw.filledCircle(x + 3.5, y + 0.5, size - 6.25);
    }

    public static void draw() {
        StdDraw.setPenColor(120,220,255);
        
        for (int i=0;i<tears.size();i++) {
            StdDraw.filledCircle(tears.get(i).get(0),tears.get(i).get(1),damage / 1.5);
            
            tears.get(i).set(0,tears.get(i).get(0) + tears.get(i).get(2));
            tears.get(i).set(1,tears.get(i).get(1) + tears.get(i).get(3));
            
            tears.get(i).set(4,tears.get(i).get(4) + 1);
            if (tears.get(i).get(4) >= range) tears.remove(i);
        }
        
        StdDraw.setPenColor(245, 160, 120);
        StdDraw.filledCircle(x, y, size);
    }

    public static void update() {
        draw();
        move();
        shoot();
        
        delay--;
    }
}
