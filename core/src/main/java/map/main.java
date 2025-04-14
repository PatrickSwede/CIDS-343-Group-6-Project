package map;
import map.MapGenerator;

public class main {
    public static void main(String[] args) {
        MapGenerator MapG = new MapGenerator();
        System.out.println("Hello World");
        int[][] newMap = MapG.generateMap(5,10,1);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(newMap[i][j]);
            }
            System.out.println();
        }
    }


}
