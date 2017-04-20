import java.awt.event.KeyEvent;

public class Player {
    public static double x = 100;
    public static double y = 100;
    public static double size = 7;
    
    public static double xVel = 0;
    public static double yVel = 0;
    public static double accel = 0.0025;
    public static double decel = 0.98;
    
    public static double speed = 0.5;
    public static double shotSpeed;
    public static double damage;
    
    public static void move() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
            if (xVel < speed) xVel+=accel;
        }
        
        if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
            if (xVel > -speed) xVel-=accel;
        }
        
        if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
            if (yVel < speed) yVel+=accel;
        }
        
        if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
            if (yVel > -speed) yVel-=accel;
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
    
    public static void draw() {
        StdDraw.setPenColor(245,160,120);
        StdDraw.filledCircle(x,y,size);
    }
    
    public static void update() {
        move();
        draw();
    }
}
