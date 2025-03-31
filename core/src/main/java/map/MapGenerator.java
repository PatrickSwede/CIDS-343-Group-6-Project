package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Ethan
 *
 */
public class MapGenerator {

    public int[][] generateMap(int size, int numRooms, float spread){
        Random rand = new Random();//Initialize the randomness
        int[][] map = new int[size][size];
        List<int[]> mapRooms = new ArrayList<>();
        //(X coord, Y coord)
        List<int[]> mapData = new ArrayList<>();
        //(Adjacent room value, Adjacent room number)
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                map[i][j] = 0;
            }
        }
        map[size/2][size/2] = 1;
        mapRooms.add(new int[]{size/2,size/2});
        mapData.add(new int[]{0,0});
        for(int i = 1; i < numRooms; i++){//Add the rooms
            boolean next = false;
            do {
                float spreadChance = rand.nextFloat(1);
                int roomPlace = rand.nextInt(i);  //Pick a random room that has already placed
                int[] temparray = mapData.get(i); //Take the adjacency values of the random room
                if(temparray[1] == 3 && (spreadChance > .5 * spread || spread == 1)){            //And check the 2nd item in that array
                    next = true;
                }else if(temparray[1] == 2 && (spreadChance >  spread || spread == 1)){
                    next = true;
                } else if(temparray[1] <= 1){
                    next = true;
                }
                if(next){
                    int adj = temparray[0];
                    if(adj >= 8){
                        adj -= 8;
                        int[] coords = mapRooms.get(i);
                        coords[1] -= 1;
                        int index = mapRooms.indexOf(coords);
                        if(index != -1){

                        }
                    }
                }
            }while(!next);
        }
    }//return before here
}
