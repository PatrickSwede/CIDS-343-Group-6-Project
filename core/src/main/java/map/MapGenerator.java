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

        if(numRooms > size * size){//If the rooms exceeds the maximum amount possible in the array
            numRooms = size * size;
        }

        if(spread <= 0){//
            spread = 1;
        }

        Random rand = new Random();//Initialize the randomness
        int[][] map = new int[size][size];

        List<int[]> mapRooms = new ArrayList<>();//(X coord, Y coord)

        List<int[]> mapData = new ArrayList<>();//(Adjacent room value, Adjacent room number)

        for(int i = 0; i < size; i++){//Set all values in the map array to 0
            for(int j = 0; j < size; j++){
                map[i][j] = -1;
            }
        }

        map[size/2][size/2] = 0;//Set the center value of the map to 0, making it our starting point
        mapRooms.add(new int[]{size/2,size/2});//Place the coords of our first room into mapRooms

        mapData.add(new int[]{0,0});//Place the adjacent room values of our first room into mapData

        for(int i = 1; i < numRooms; i++){//Add the rooms
            //System.out.println(i + ": "); //Debug statement to show what loop we are on

            boolean next = false;//Precursor to the following do loop
            do {
                float spreadChance = rand.nextFloat(1); //generate a float from 0 to 1
                int roomPlace = rand.nextInt(i);              //Pick a random room that has already placed
                int[] temparray = new int[]{mapData.get(roomPlace)[0],mapData.get(roomPlace)[1]};     //Take the adjacency values of the random room
                int[] coords = new int[]{mapRooms.get(roomPlace)[0],mapRooms.get(roomPlace)[1]};       //And check the 2nd item in that array (The number of adjacent rooms)
                if(temparray[1] == 3 && (spreadChance > .5 * spread || spread >= 1))
                { //If the room that we are checking is already adjacent to 3 rooms
                    next = true; //Then we will give it half the chance of spreading unless the chance is guarenteed
                }
                else if(temparray[1] == 2 && (spreadChance >  spread || spread >= 1)){
                    //If the room we are checking is already adjacent to 2 rooms
                    next = true; //Then we will check if our spread chance goes through
                } else if(temparray[1] <= 1)
                { //If the room we are checking is already adjacent to 1 or fewer rooms
                    next = true; //Then spread it regardless of chance
                }

                //At the end of the loop
                if(next){//Pick where the new room goes by checking where existing adjacent rooms are of our selected room
                    boolean[] adjacent = new boolean[4];//up,right,down,left
                    int adj = temparray[0];

                    if(adj >= 8){//up
                        adj -= 8;
                        adjacent[0] = true;
                    }else if(coords[1] == 0){//if top room
                        adjacent[0] = true;
                    }
                    if(adj >= 4) {//right
                        adj -= 4;
                        adjacent[1] = true;
                    } else if(coords[0] == size - 1){//if rightmost room
                        adjacent[1] = true;
                    }
                    if(adj >= 2) {//down
                        adj -= 2;
                        adjacent[2] = true;
                    }else if(coords[1] == size - 1){//if bottom room
                        adjacent[2] = true;
                    }
                    if(adj >= 1){//left
                        adj -= 1;
                        adjacent[3] = true;
                    }else if(coords[0] == 0){//if leftmost room
                        adjacent[3] = true;
                    }
                    //System.out.print("Testerthing: " + mapData.get(roomPlace)[0] + "=?=" + adj + "\n");
                    boolean place = true;
                    while(place){
                        int r = rand.nextInt(4);
                        if(!adjacent[r]){
                            //int[] coords = mapRooms.get(roomPlace);

                            switch(r){//updates the coords value to the new room we will be generating, before placing it in the map array
                                case 0://up
                                    coords[1] -= 1;
                                    mapRooms.add(coords);
                                    place = false;
                                    break;
                                case 1://right
                                    coords[0] += 1;
                                    mapRooms.add(coords);
                                    place = false;
                                    break;
                                case 2://down
                                    coords[1] += 1;
                                    mapRooms.add(coords);
                                    place = false;
                                    break;
                                case 3://left
                                    coords[0] -= 1;
                                    mapRooms.add(coords);
                                    place = false;
                                    break;
                            }
                            map[coords[0]][coords[1]] = i; //Here is our new room! Say hi!!
                            //Add the map data
                            mapData.add(new int[]{0,0});
                            //System.out.print("(" + coords[0] + "," + coords[1] + ") ::" + r + "\n");

                            if(coords[1] != 0) {//if not on the top value
                                if (map[coords[0]][coords[1] - 1] != -1) {//If there is a room up adjacent
                                    mapData.get(i)[0] += 8;//update the map data of the new room
                                    mapData.get(i)[1] += 1;
                                    int tempIndex = map[coords[0]][coords[1] - 1];
                                    //System.out.print("weirdTest{" +mapRooms.get(s)[0] + "," + mapRooms.get(s)[1] + "}\n" );
                                    mapData.get(tempIndex)[0] += 2;//update the map data of the adjacent room
                                    mapData.get(tempIndex)[1] += 1;
                                }
                            }else{//if bordering the edge, then count it as adjacent
                                mapData.get(i)[0] += 8;//update the map data of the new room
                                mapData.get(i)[1] += 1;
                            }
                            if(coords[0] != size-1) {
                                if (map[coords[0] + 1][coords[1]] != -1) {
                                    mapData.get(i)[0] += 4;
                                    mapData.get(i)[1] += 1;
                                    int tempIndex = map[coords[0] + 1][coords[1]];
                                    mapData.get(tempIndex)[0] += 1;//update the map data of the adjacent room
                                    mapData.get(tempIndex)[1] += 1;
                                }
                            }else{
                                mapData.get(i)[0] += 4;
                                mapData.get(i)[1] += 1;
                            }
                            if(coords[1] != size - 1) {
                                if (map[coords[0]][coords[1] + 1] != -1) {
                                    mapData.get(i)[0] += 2;
                                    mapData.get(i)[1] += 1;
                                    int tempIndex = map[coords[0]][coords[1] + 1];
                                    mapData.get(tempIndex)[0] += 8;//update the map data of the adjacent room
                                    mapData.get(tempIndex)[1] += 1;
                                }
                            }else{
                                mapData.get(i)[0] += 2;
                                mapData.get(i)[1] += 1;
                            }
                            if(coords[0] != 0) {
                                if (map[coords[0] - 1][coords[1]] != -1) {
                                    mapData.get(i)[0] += 1;
                                    mapData.get(i)[1] += 1;
                                    int tempIndex = map[coords[0] - 1][coords[1]];

                                    mapData.get(tempIndex)[0] += 4;//update the map data of the adjacent room
                                    mapData.get(tempIndex)[1] += 1;
                                }
                            }else{
                                mapData.get(i)[0] += 1;
                                mapData.get(i)[1] += 1;
                            }
                            //System.out.print("[" + mapData.get(i)[0] + "]}");
                            for(int a = 0; a <= i; a++){
                                //System.out.print("{" + mapRooms.get(a)[0] + "," + mapRooms.get(a)[1] + "} :: {" + mapData.get(a)[0] + "," + mapData.get(a)[1] + "} //");
                            }
                        }
                    }
                }
            }while(!next);
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(map[i][j] != -1){
                    map[i][j] = 1;
                }
            }
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(map[i][j] == -1){
                    map[i][j] = 0;
                }
            }
        }
        return map;
    }//return before here
}
