package map;
import map.MapGenerator;
import map.ChunkGenerator;
import map.Chunk;

public class main {
    public static void main(String[] args) {
        MapGenerator MapG = new MapGenerator();
        ChunkGenerator ChunkG = new ChunkGenerator();
        System.out.println("Hello World");
        Chunk[][] newMap = MapG.generateMap(5,12,1, 5, .5f);
        //int[][] newChunk = ChunkG.GenerateChunk(5,true,true,false,false, .5f);
        for(int i = 0; i < 5; i++) { //i,j is map ::: k,l is chunk
            for (int k = 0; k < 5; k++){
                for(int j = 0; j < 5; j++){
                    for(int l = 0; l < 5; l++){
                        if(newMap[i][j].getActive()) {
                            System.out.print(newMap[i][j].getChunk()[k][l] + " ");
                        }else{
                            System.out.print("- ");
                        }
                    }
                    System.out.print("|");
                }
                System.out.println();

            }
            System.out.println("----------+----------+----------+----------+----------");
        }
    }
}
