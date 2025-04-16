package map;
import map.MapGenerator;
import map.ChunkGenerator;
import map.Chunk;

public class main {
    public static void main(String[] args) {
        MapGenerator MapG = new MapGenerator();
        ChunkGenerator ChunkG = new ChunkGenerator();
        System.out.println("Hello World");
        Chunk[][] newMap = MapG.generateMap(9,30,1, 9);
        //int[][] newChunk = ChunkG.GenerateChunk(5,true,true,false,false, .5f);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(newMap[i][j].getActive()){
                    for(int k = 0; k < 9; k++){
                        for(int l = 0; l < 9; l++){
                            System.out.print(newMap[i][j].getChunk()[k][l] + " ");
                        }
                        System.out.println();
                    }
                }
                else {
                    for (int k = 0; k < 9; k++) {
                        for (int l = 0; l < 9; l++) {
                            System.out.print("- ");
                        }
                        System.out.println();
                    }
                }
                System.out.println("-------------------");
            }
            System.out.println("-------------------");
        }
    }


}
