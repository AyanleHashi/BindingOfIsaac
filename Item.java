public interface Item {
    String toString();
    boolean isPickedUp();
    void modifier();
    void draw();
    void pickup(double playerx, double playery);
}