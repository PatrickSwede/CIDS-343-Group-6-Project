package map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * A simple class to generate chunks made of tiles which the environment will consist of
 * @author Patrick Swedenborg
 */
public class Chunk {
    private int numberRows;
    private int numberCols;
    private Tile[][] tiles;

    /**
     * The constructor to instantiate a simple chunk
     * @param numberRows an int specifying the number of rows
     * @param numberCols am int specifying the number of columns
     * @param tiles a two-dimensional array of tiles
     */
    public Chunk(int numberRows, int numberCols, Tile[][] tiles) {
        this.tiles = tiles;
        this.numberRows = numberRows;
        this.numberCols = numberCols;
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

    /**
     * A method to draw the chunk
     * @param batch the spritebatch used to visualize the chunk
     */
    public void draw(SpriteBatch batch) {
        for(int i = 0 ; i < numberRows; i++) {
            for(int j = 0; j < numberCols; j++) {
                batch.draw(tiles[i][j].getTexture(), tiles[i][j].getPos().x * tiles[i][j].getSize(),
                    tiles[i][j].getPos().y * tiles[i][j].getSize(), tiles[i][j].getSize(), tiles[i][j].getSize());
            }
        }
    }
}
