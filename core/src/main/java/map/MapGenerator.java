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
        if(numrooms > size * size){//If the rooms exceeds the maximum amount possible in the array
            numRooms = size*size;
        }
        if(spread <= 0){//
            spread = 1;
        }
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
                int roomPlace = rand.nextInt(i);                                      //Pick a random room that has already placed
                int[] temparray = mapData.get(i);                                     //Take the adjacency values of the random room
                if(temparray[1] == 3 && (spreadChance > .5 * spread || spread == 1)){ //And check the 2nd item in that array
                    next = true;
                }else if(temparray[1] == 2 && (spreadChance >  spread || spread == 1)){
                    next = true;
                } else if(temparray[1] <= 1){
                    next = true;
                }
                if(next){//Pick where the new room goes by checking where existing adjacent rooms are
                    boolean[] adjacent = new boolean[4];//up,right,down,left
                    int adj = temparray[0];
                    if(adj >= 8){//up
                        adj -= 8;
                        int[] coords = mapRooms.get(i);
                        coords[1] += 1;
                        int index = mapRooms.indexOf(coords);
                        if(index != -1){
                            adjacent[0] = true;
                        }
                    }
                    if(adj >= 4){//right
                        adj -= 4;
                        int[] coords = mapRooms.get(i);
                        coords[0] += 1;
                        int index = mapRooms.indexOf(coords);
                        if(index != -1){
                            adjacent[1] = true;
                        }
                    }
                    if(adj >= 2){//down
                        adj -= 2;
                        int[] coords = mapRooms.get(i);
                        coords[1] -= 1;
                        int index = mapRooms.indexOf(coords);
                        if(index != -1){
                            adjacent[2] = true;
                        }
                    }
                    if(adj >= 1){//left
                        adj -= 1;
                        int[] coords = mapRooms.get(i);
                        coords[0] -= 1;
                        int index = mapRooms.indexOf(coords);
                        if(index != -1){
                            adjacent[3] = true;
                        }
                    }
                    while(true){
                        r = rand.nextInt(4);
                        if(adjacent[r]){

                            switch(r){
                                case 0:
                                    mapRooms.add(new int[]{,});
                            }
                            break;
                        }
                    }
                }
            }while(!next);
        }
        return map;
    }//return before here
}
