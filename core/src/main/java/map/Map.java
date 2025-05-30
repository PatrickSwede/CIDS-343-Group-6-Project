package map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import io.github.CIDS_343_Group_6_Project.Enums;

/**
 * A simple class to generate chunks made of tiles which the environment will consist of
 * @author Patrick Swedenborg
 */
public class Map {
    private int numberRows;
    private int numberCols;
    private int chunkSize;
    private int size;
    private int tileSizeX;
    private int tileSizeY;
    private Tile[][] tiles;

    /**
     * The constructor to instantiate a simple chunk
     * @param numberRows an int specifying the number of rows
     * @param numberCols am int specifying the number of columns
     * @param tiles a two-dimensional array of tiles
     */
    public Map(int numberRows, int numberCols, int chunkSize, int size, Tile[][] tiles) {
        this.tiles = tiles;
        this.numberRows = numberRows;
        this.numberCols = numberCols;
        this.chunkSize = chunkSize;
        this.size = size;
        tileSizeX = Enums.SETTINGS.RESOLUTIONX.getValue() / (size * chunkSize);
        tileSizeY = Enums.SETTINGS.RESOLUTIONY.getValue() / (size * chunkSize);
    }

    public Tile getTile(Vector2 pos) {
        for(int i = 0; i < numberRows; i++) {
            for(int j = 0; j < numberCols; j++) {
                if (pos.x == tiles[i][j].getPos().x && pos.y == tiles[i][j].getPos().y) {
                    return tiles[i][j];
                }
            }
        }
        return null;
    }

    /**
     * Getter for numberRows attribute
     * @return numberRows
     */
    public int getNumberRows() {
        return numberRows;
    }

    /**
     * Getter for numberCols attribute
     * @return numberCols
     */
    public int getNumberCols() {
        return numberCols;
    }


    /**
     * Getter for tiles attribute
     * @return tiles
     */
    public Tile[][] getTiles() {
        return tiles;
    }

    public int getSize() { return size;}

    public int getChunkSize() {return chunkSize;}

    /**
     * Setter for numberRows attribute
     * @param numberRows an int representing the number of rows
     */
    public void setNumberRows(int numberRows) {
        this.numberRows = numberRows;
    }

    /**
     * Setter for numberCols attribute
     * @param numberCols an int representing the number of columns
     */
    public void setNumberCols(int numberCols) {
        this.numberCols = numberCols;
    }

    /**
     * Setter for tiles attribute
     * @param tiles a two-dimensional array consisting of tile objects which the chunk consists of
     */
    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    /**
     * A method to get the tile codes of the chunk which will be useful to help debug and check later
     * whether a tile is passable of not etc.
     * @param row the specified row of the tile being inquired represented as an int
     * @param col the specified column of the tile being inquired represented as an int
     * @return null if invalid parameters else the tile code (passable or not)
     */
    public String getTileCode(int row, int col) {
       return tiles[row][col].getCode();
    }

    /**
     * A method to retrieve a tile of the chunk
     * @param row the specified row the tile resides in represented as an int
     * @param col the specified column the tile resides in represented as an int
     * @return null if invalid parameters else the tile being inquired
     */
    public Tile getTile(int row, int col) {
        System.out.println("Row: " + row + " Col: " + col);
        return tiles[row][col];
    }

    public Tile getTileAtPos(Vector2 pos) {
        int x = (int) pos.x / 10;
        int y = (int) pos.y / 10;
        return tiles[x][y];
    }

    public float getRowAtPos(Vector2 pos) {
        return (float) Math.floor(pos.y / tileSizeY);
    }

    public float getColAtPos(Vector2 pos) {
        return (float) Math.floor(pos.x / tileSizeX);
    }

    /**
     * A method to draw the chunk
     * @param batch the spritebatch used to visualize the chunk
     */
    public void draw(SpriteBatch batch) {
        for(int i = 0 ; i < numberRows; i++) {
            for(int j = 0; j < numberCols; j++) {
                batch.draw(tiles[i][j].getTexture(), tiles[i][j].getPos().x,
                    tiles[i][j].getPos().y , tiles[i][j].getSize(), tiles[i][j].getSize());
            }
        }
    }

    public void printMap() {
        for (int i = 0; i < numberRows; i++) {
            System.out.println();
            for (int j = 0; j < numberCols; j++) {
                System.out.print(tiles[i][j].getPos());
            }
        }

    }
}
