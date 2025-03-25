package map;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ethan
 *
 */
public class MapGenerator {

    public int[][] generateMap(int size, int numRooms){
        int[][] map = new int[size][size];
        List<int[]> mapRooms = new ArrayList<>();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                map[i][j] = 0;
            }
        }
        map[size/2][size/2] = 1;
        mapRooms.add(new int[]{size/2,size/2});
        for(int i = 1; i < numRooms; i++){//Add the rooms

        }
    }
}
