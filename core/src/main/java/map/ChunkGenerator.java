package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChunkGenerator {
    //protected int[][] Chunk;
    public int[][] GenerateChunk(int size, boolean up,boolean right,boolean down, boolean left, float spread, float obstacleDensity){

        Random rand = new Random();//Initialize the randomness
        int[][] chunk = new int[size][size];

        List<int[]> mapRooms = new ArrayList<>();//(X coord, Y coord)

        List<int[]> mapData = new ArrayList<>();//(Adjacent room value, Adjacent room number)

        for(int i = 0; i < size; i++){//Set all values in the map array to 0
            for(int j = 0; j < size; j++){
                chunk[i][j] = -1;
            }
        }

        chunk[size/2][size/2] = 0;//Set the center value of the map to 0, making it our starting point
        mapRooms.add(new int[]{size/2,size/2});//Place the coords of our first room into mapRooms

        mapData.add(new int[]{0,0});//Place the adjacent room values of our first room into mapData

        boolean willSpread = true; //if the spread hasn't reached the doors yet
        int i = 1;
        while(willSpread){//Add the rooms

            boolean next = false;//Precursor to the following do loop
            do {
                float spreadChance = rand.nextFloat(); //generate a float from 0 to 1
                int roomPlace = rand.nextInt(i);              //Pick a random room that has already placed
                int[] temparray = new int[]{mapData.get(roomPlace)[0],mapData.get(roomPlace)[1]};     //Take the adjacency values of the random room
                int[] coords = new int[]{mapRooms.get(roomPlace)[0],mapRooms.get(roomPlace)[1]};       //And check the 2nd item in that array (The number of adjacent rooms)

                if(temparray[1] == 3 && (spreadChance < .5 * spread || spread >= 1))
                { //If the room that we are checking is already adjacent to 3 rooms
                    next = true; //Then we will give it half the chance of spreading unless the chance is guarenteed
                }
                else if(temparray[1] == 2 && (spreadChance <  spread || spread >= 1)){
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
                            chunk[coords[0]][coords[1]] = i; //Here is our new room! Say hi!!
                            //Add the map data
                            mapData.add(new int[]{0,0});

                            if(coords[1] != 0) {//if not on the top value
                                if (chunk[coords[0]][coords[1] - 1] != -1) {//If there is a room up adjacent
                                    mapData.get(i)[0] += 8;//update the map data of the new room
                                    mapData.get(i)[1] += 1;
                                    int tempIndex = chunk[coords[0]][coords[1] - 1];
                                    mapData.get(tempIndex)[0] += 2;//update the map data of the adjacent room
                                    mapData.get(tempIndex)[1] += 1;
                                }
                            }else{//if bordering the edge, then count it as adjacent
                                mapData.get(i)[0] += 8;//update the map data of the new room
                                mapData.get(i)[1] += 1;
                            }
                            if(coords[0] != size-1) {
                                if (chunk[coords[0] + 1][coords[1]] != -1) {
                                    mapData.get(i)[0] += 4;
                                    mapData.get(i)[1] += 1;
                                    int tempIndex = chunk[coords[0] + 1][coords[1]];
                                    mapData.get(tempIndex)[0] += 1;//update the map data of the adjacent room
                                    mapData.get(tempIndex)[1] += 1;
                                }
                            }else{
                                mapData.get(i)[0] += 4;
                                mapData.get(i)[1] += 1;
                            }
                            if(coords[1] != size - 1) {
                                if (chunk[coords[0]][coords[1] + 1] != -1) {
                                    mapData.get(i)[0] += 2;
                                    mapData.get(i)[1] += 1;
                                    int tempIndex = chunk[coords[0]][coords[1] + 1];
                                    mapData.get(tempIndex)[0] += 8;//update the map data of the adjacent room
                                    mapData.get(tempIndex)[1] += 1;
                                }
                            }else{
                                mapData.get(i)[0] += 2;
                                mapData.get(i)[1] += 1;
                            }
                            if(coords[0] != 0) {
                                if (chunk[coords[0] - 1][coords[1]] != -1) {
                                    mapData.get(i)[0] += 1;
                                    mapData.get(i)[1] += 1;
                                    int tempIndex = chunk[coords[0] - 1][coords[1]];

                                    mapData.get(tempIndex)[0] += 4;//update the map data of the adjacent room
                                    mapData.get(tempIndex)[1] += 1;
                                }
                            }else{
                                mapData.get(i)[0] += 1;
                                mapData.get(i)[1] += 1;
                            }
                        }
                    }
                }
            }while(!next);
            i++;
            if((chunk[size/2][0] != -1 || !up) && (chunk[size-1][size/2] != -1 || !right) && (chunk[size/2][size-1] != -1 || !down) && (chunk[0][size/2] != -1 || !left)){
                willSpread = false;
            }
        }
        for(int k = 0; k < size; k++){
            for(int j = 0; j < size; j++){
                if(chunk[k][j] != -1){
                    chunk[k][j] = 1;
                }
            }
        }
        for(int k = 0; k < size; k++){
            for(int j = 0; j < size; j++){
                if(chunk[k][j] == -1){
                    chunk[k][j] = 0;
                }
            }
        }
        if(obstacleDensity >= 0){
            chunk = placeObstacles(chunk,size,obstacleDensity, up, right, down, left);
        }
        return chunk;
    }
    private int[][] placeObstacles(int[][] chunk, int size, float density, boolean up, boolean right, boolean down, boolean left){
        if(density <= 0){
            return chunk;
        }
        //Density: higher value means more obstacles
        Random rand = new Random();
        int tileCount = 0;
        List<int[]> obstacleQueue = new ArrayList<int[]>();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(chunk[i][j] == 1){
                    tileCount++;
                    obstacleQueue.add(new int[]{i,j});
                }
            }
        }
        int tilesLeft = tileCount;//the amount of walkable tiles that are left
        List<int[]> searchedTiles = new ArrayList<int[]>(); //The list of tiles that have been searched so far
        searchedTiles.add(new int[]{size/2,size/2});
        for(int i = 0; i < tileCount; i++){
            int roomToCheck = rand.nextInt(tileCount - i);//pick a random tile from the queue
            chunk[obstacleQueue.get(roomToCheck)[0]][obstacleQueue.get(roomToCheck)[1]] = 2;//2 in chunk designates obstacle
            int adjs = 0;
            if(obstacleQueue.get(roomToCheck)[0] != size - 1) {
                if (chunk[obstacleQueue.get(roomToCheck)[0] + 1][obstacleQueue.get(roomToCheck)[1]] != 0) {//right
                    adjs++;
                }
            }
            if(obstacleQueue.get(roomToCheck)[0] != 0) {
                if (chunk[obstacleQueue.get(roomToCheck)[0] - 1][obstacleQueue.get(roomToCheck)[1]] != 0) {//left
                    adjs++;
                }
            }
            if(obstacleQueue.get(roomToCheck)[1] != size-1) {
                if (chunk[obstacleQueue.get(roomToCheck)[0]][obstacleQueue.get(roomToCheck)[1] + 1] != 0) {//down
                    adjs++;
                }
            }
            if(obstacleQueue.get(roomToCheck)[1] != 0) {
                if (chunk[obstacleQueue.get(roomToCheck)[0]][obstacleQueue.get(roomToCheck)[1] - 1] != 0) {//up
                    adjs++;
                }
            }
            if(adjs == 1) {
                //if the new room only borders one other room, then do not place an obstacle
                chunk[obstacleQueue.get(roomToCheck)[0]][obstacleQueue.get(roomToCheck)[1]] = 1;
            }else if((obstacleQueue.get(roomToCheck)[0] == 0 && obstacleQueue.get(roomToCheck)[1] == size/2 && left)||//left
                (obstacleQueue.get(roomToCheck)[0] == size-1 && obstacleQueue.get(roomToCheck)[1] == size/2 && right)||//right
                (obstacleQueue.get(roomToCheck)[0] == size/2 && obstacleQueue.get(roomToCheck)[1] == 0 && up)||//top
                (obstacleQueue.get(roomToCheck)[0] == size/2 && obstacleQueue.get(roomToCheck)[1] == size-1 && down)||//bottom
                (obstacleQueue.get(roomToCheck)[0] == size/2 && obstacleQueue.get(roomToCheck)[1] == size/2)){//center
                //if it would block the door, do not place an obstacle
                chunk[obstacleQueue.get(roomToCheck)[0]][obstacleQueue.get(roomToCheck)[1]] = 1;
            }else if(search(chunk,obstacleQueue.get(roomToCheck)[0],obstacleQueue.get(roomToCheck)[1], size).size() == tilesLeft){
                //If adding an obstacle here does not disallow the player from reaching anywhere else
                float chance = rand.nextFloat();
                if(chance >= density){//adds variance for placing obstacles
                    chunk[obstacleQueue.get(roomToCheck)[0]][obstacleQueue.get(roomToCheck)[1]] = 1;
                }else{//if the obstacle actually gets placed
                    tilesLeft--;
                }
            }else{
                chunk[obstacleQueue.get(roomToCheck)[0]][obstacleQueue.get(roomToCheck)[1]] = 1;
            }
            obstacleQueue.remove(roomToCheck);
        }
        return chunk;
    }

    //Shorthand search program
    private List<int[]> search(int[][] room, int X, int Y, int size){
        List<int[]> tilesQueue = new ArrayList<int[]>();
        List<int[]> tilesChecked = new ArrayList<int[]>();
        tilesQueue.add(new int[]{X,Y});
        while(!tilesQueue.isEmpty()){
            //System.out.println(tilesQueue.size());
            if(tilesQueue.get(0)[1] != 0){//if not up
                if(room[tilesQueue.get(0)[0]][tilesQueue.get(0)[1]-1] == 1){//up
                    boolean tileLogged = false;
                    //if the resulting room is not in either of the existing lists, add it to tilesQueue
                    for(int i = 0; i < tilesQueue.size(); i++){
                        if(tilesQueue.get(i)[0] == tilesQueue.get(0)[0] && tilesQueue.get(i)[1] == tilesQueue.get(0)[1]-1){
                            tileLogged = true;
                        }
                    }
                    for(int i = 0; i < tilesChecked.size(); i++){
                        if(tilesChecked.get(i)[0] == tilesQueue.get(0)[0] && tilesChecked.get(i)[1] == tilesQueue.get(0)[1]-1){
                            tileLogged = true;
                        }
                    }
                    if(!tileLogged){
                        tilesQueue.add(new int[]{tilesQueue.get(0)[0],tilesQueue.get(0)[1]-1});
                    }
                }
            }
            if(tilesQueue.get(0)[0] != size - 1){//if not right
                if(room[tilesQueue.get(0)[0]+1][tilesQueue.get(0)[1]] == 1){//right
                    boolean tileLogged = false;
                    //if the resulting room is not in either of the existing lists, add it to tilesQueue
                    for(int i = 0; i < tilesQueue.size(); i++){
                        if(tilesQueue.get(i)[0] == tilesQueue.get(0)[0]+1 && tilesQueue.get(i)[1] == tilesQueue.get(0)[1]){
                            tileLogged = true;
                        }
                    }
                    for(int i = 0; i < tilesChecked.size(); i++){
                        if(tilesChecked.get(i)[0] == tilesQueue.get(0)[0]+1 && tilesChecked.get(i)[1] == tilesQueue.get(0)[1]){
                            tileLogged = true;
                        }
                    }
                    if(!tileLogged){
                        tilesQueue.add(new int[]{tilesQueue.get(0)[0]+1,tilesQueue.get(0)[1]});
                    }
                }
            }
            if(tilesQueue.get(0)[1] != size - 1){//if not down
                if(room[tilesQueue.get(0)[0]][tilesQueue.get(0)[1]+1] == 1){//down
                    boolean tileLogged = false;
                    //if the resulting room is not in either of the existing lists, add it to tilesQueue
                    for(int i = 0; i < tilesQueue.size(); i++){
                        if(tilesQueue.get(i)[0] == tilesQueue.get(0)[0] && tilesQueue.get(i)[1] == tilesQueue.get(0)[1]+1){
                            tileLogged = true;
                        }
                    }
                    for(int i = 0; i < tilesChecked.size(); i++){
                        if(tilesChecked.get(i)[0] == tilesQueue.get(0)[0] && tilesChecked.get(i)[1] == tilesQueue.get(0)[1]+1){
                            tileLogged = true;
                        }
                    }
                    if(!tileLogged){
                        tilesQueue.add(new int[]{tilesQueue.get(0)[0],tilesQueue.get(0)[1]+1});
                    }
                }
            }
            if(tilesQueue.get(0)[0] != 0){//if not left
                if(room[tilesQueue.get(0)[0]-1][tilesQueue.get(0)[1]] == 1){//left
                    boolean tileLogged = false;
                    //if the resulting room is not in either of the existing lists, add it to tilesQueue
                    for(int i = 0; i < tilesQueue.size(); i++){
                        if(tilesQueue.get(i)[0] == tilesQueue.get(0)[0]-1 && tilesQueue.get(i)[1] == tilesQueue.get(0)[1]){
                            tileLogged = true;
                        }
                    }
                    for(int i = 0; i < tilesChecked.size(); i++){
                        if(tilesChecked.get(i)[0] == tilesQueue.get(0)[0]-1 && tilesChecked.get(i)[1] == tilesQueue.get(0)[1]){
                            tileLogged = true;
                        }
                    }
                    if(!tileLogged){
                        tilesQueue.add(new int[]{tilesQueue.get(0)[0]-1,tilesQueue.get(0)[1]});
                    }
                }
            }
            tilesChecked.add(tilesQueue.get(0));
            tilesQueue.remove(0);
        }
        return tilesChecked;
    }
}
