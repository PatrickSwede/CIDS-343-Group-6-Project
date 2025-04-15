package map;
import map.MapGenerator;
import map.ChunkGenerator;

public class main {
    public static void main(String[] args) {
        MapGenerator MapG = new MapGenerator();
        ChunkGenerator ChunkG = new ChunkGenerator();
        System.out.println("Hello World");
        Chunk[][] newMap = MapG.generateMap(9,30,1, 9);
        //int[][] newChunk = ChunkG.GenerateChunk(5,true,true,false,false, .5f);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(newMap[i][j] + "");
            }
            System.out.println();
        }
    }


}
