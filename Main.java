import java.util.*;

public class Main {
    
    public static ArrayList<Item> allItems = new ArrayList<Item>();

    public static void initialize() {
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(0,200);
        StdDraw.setPenColor(255,0,0);
    }
    
    public static void initializeItems(Player p) {
        allItems.add(new TheMark(p,100,100));
    }
   
    public static void main(String[] args) {
        initialize();
        Player player = new Player();
        initializeItems(player);
        
        while (true) {
            StdDraw.clear(StdDraw.BLACK);
            player.update();
            
            for (Item item : allItems) {
                if (!item.isPickedUp()) item.draw();
                item.pickup(player.x,player.y);
            }
            
            StdDraw.show();
        }
    }
}
