package map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import io.github.CIDS_343_Group_6_Project.Enums;

public class MapMethods {

    public static Map initializeLevel(int size, int numRooms, float spread, int chunkSize, float obstacleDensity) {

        MapGenerator mapGen = new MapGenerator();
        int[][] mapCode = new int[size * chunkSize][size * chunkSize];
        Chunk[][] chunks = mapGen.generateMap(size, numRooms, spread, chunkSize, obstacleDensity);
        Tile[][] tiles = new Tile[size * chunkSize][size * chunkSize];
        int numRowsCols = size * chunkSize;
        Map map;
        int tileSizeX = Enums.SETTINGS.RESOLUTIONX.getValue() / (chunkSize * size);
        int tileSizeY = Enums.SETTINGS.RESOLUTIONY.getValue() / (chunkSize * size);

        TextureRegion tempText;
        Enums.TILETYPE tempType;
        boolean isPassable;


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int[][] currentChunk;
                if (chunks[i][j].getActive()) {
                    currentChunk = chunks[i][j].getChunk();
                } else {
                    currentChunk = new int[chunkSize][chunkSize];
                    for (int x = 0; x < chunkSize; x++) {
                        for (int y = 0; y < chunkSize; y++) {
                            currentChunk[x][y] = 0;
                        }
                    }
                }
                for (int k = 0; k < chunkSize; k++) {
                    for (int l = 0; l < chunkSize; l++) {
                        mapCode[(i * chunkSize) + k][(j * chunkSize) + l] =  currentChunk[k][l];
                    }
                }

            }
        }

        for (int y = (size * chunkSize) - 1; y >= 0  ; y--) {
            System.out.println();
            for (int x = 0; x < (size * chunkSize) ; x++) {
                if (mapCode[x][y] == 0) {
                    tempText = Enums.TILETYPE.WATER.getValue();
                    tempType = Enums.TILETYPE.WATER;
                    isPassable = false;
                } else if (mapCode[x][y] == 1) {
                    tempText = Enums.TILETYPE.GRASS.getValue();
                    tempType = Enums.TILETYPE.GRASS;
                    isPassable = true;
                } else if (mapCode[x][y] == 2) {
                    tempText = Enums.TILETYPE.TREES.getValue();
                    tempType = Enums.TILETYPE.TREES;
                    isPassable = false;
                } else {
                    tempText = Enums.TILETYPE.GRASS.getValue();
                    tempType = Enums.TILETYPE.GRASS;
                    isPassable = true;
                }
                tiles[x][y] = new Tile((x * tileSizeX), (y * tileSizeY), Enums.SETTINGS.RESOLUTIONX.getValue()/ (float) (size * chunkSize), tempText, tempType, isPassable);
                tiles[x][y].setCode(Integer.toString(mapCode[x][y]));
            }
        }
        map = new Map(numRowsCols, numRowsCols, chunkSize, size, tiles);
        return map;
    }
}
