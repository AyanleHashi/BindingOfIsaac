public class TheMark implements Item {
    
    private Player player;
    private boolean pickedUp;
    private double x;
    private double y;
    
    public TheMark(Player p, double ecks, double why) {
        player = p;
        pickedUp = false;
        x = ecks;
        y = why;
    }
    
    public String toString() {
        return "The Mark";
    }
    
    public boolean isPickedUp() {
        return pickedUp;
    }
    
    public void modifier() {
        player.damage += 1;
    }
    
    public void draw() {
        StdDraw.setPenColor(230,0,0);
        StdDraw.filledCircle(x,y,4);
    }
    
    public void pickup(double playerx, double playery) {
        if ((playerx - 7 < x && x < playerx + 7) && (playery - 7 < y && y < playery + 7) && !pickedUp) {
            pickedUp = true;
            modifier();
        }
    }
}