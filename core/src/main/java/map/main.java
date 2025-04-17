package map;
import map.MapGenerator;
import map.ChunkGenerator;
import map.Chunk;

public class main {
    public static void main(String[] args) {
        MapGenerator MapG = new MapGenerator();
        int size = 9; //dimensions of the map as a whole
        int numRooms = 50; //how many chunks will be generated
        float spread = .25f; //roughly how spread out the chunks will be (0 - 1)
        int chunksize = 9; //dimensions of each chunk
        float obstacleDensity = .25f; //roughly how many obstacles will be in each chunk (0 - 1)
        ChunkGenerator ChunkG = new ChunkGenerator();
        System.out.println("Hello World");
        Chunk[][] newMap = MapG.generateMap(size,numRooms,spread, chunksize, obstacleDensity);
        //int[][] newChunk = ChunkG.GenerateChunk(5,true,true,false,false, .5f);
        for(int x = 0; x < size; x++) { //i,j is map ::: k,l is chunk
            for (int x1 = 0; x1 < chunksize; x1++){
                for(int y = 0; y < size; y++){
                    for(int y1 = 0; y1 < chunksize; y1++){
                        if(newMap[x][y].getActive() && newMap[x][y].getChunk()[x1][y1] != 0) {
                            System.out.print(newMap[x][y].getChunk()[x1][y1] + " ");
                        }else{
                            System.out.print("- ");
                        }
                    }
                    System.out.print("| ");
                }
                System.out.println();

            }
            for(int y = 0; y < size; y++){
                for(int y1 = 0; y1 < chunksize; y1++){
                    System.out.print("--");
                }
                System.out.print("+-");
            }
            System.out.println();
        }
    }
}
