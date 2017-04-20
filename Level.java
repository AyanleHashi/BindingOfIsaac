import java.util.*;
import java.awt.event.KeyEvent;

public class Level {
    int[][] map;
    
    public Level (int a){
        int size = 3+(a*2);
        int floorsize = 6 + (a*2);
        int rooms = 1;
        
        map = new int[size][size];
        Random rand = new Random();
        map[(size/2)+1][(size/2)+1] = 2+rand.nextInt(2);
        while (rooms < floorsize){
            for (int i=0; i<size; i++){
                for (int j=0; j<size;j++){
                    if (map[i][j]>1) 
        
    
    }
    
    public int[][] Get (){
        return map;
    }
}
