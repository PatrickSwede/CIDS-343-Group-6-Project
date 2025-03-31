package map;

import java.util.ArrayList;

/**
 * A simple class to generate chunks made of tiles which the environment will consist of
 * @author Patrick Swedenborg
 */
public class Chunk {
    private int numberRows;
    private int numberCols;
    private int tileSize;
    private ArrayList<ArrayList<Tile>> tiles;

    /**
     * The constructor to instantiate a simple chunk
     * @param numberRows an int specifying the number of rows
     * @param numberCols am int specifying the number of columns
     * @param tileSize an int representing the size
     */
    public Chunk(int numberRows, int numberCols, int tileSize) {
        tiles = new ArrayList<ArrayList<Tile>>();
        this.numberRows = numberRows;
        this.numberCols = numberCols;
        this.tileSize = tileSize;
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
     * Getter for tileSize attribute
     * @return tileSize
     */
    public int getTileSize() {
        return tileSize;
    }

    /**
     * Getter for tiles attribute
     * @return tiles
     */
    public ArrayList<ArrayList<Tile>> getTiles() {
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
     * Setter for tileSize attribute
     * @param tileSize an int representing the size of the tiles in the chunk
     */
    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }

    /**
     * Setter for tiles attribute
     * @param tiles a two-dimensional arraylist consisting of tile objects which the chunk consists of
     */
    public void setTiles(ArrayList<ArrayList<Tile>> tiles) {
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
        Tile tile;

        ArrayList<Tile> chunkRow;
        if (tiles.size() > row && row >= 0) {
            chunkRow = tiles.get(row);

            if(chunkRow != null && chunkRow.size() > col && col >= 0) {
                tile = chunkRow.get(col);
                return tile.isPassable() ? "1" : "0";
            }
        }
        return null;
    }

    /**
     * A method to retrieve a tile of the chunk
     * @param row the specified row the tile resides in represented as an int
     * @param col the specified column the tile resides in represented as an int
     * @return null if invalid parameters else the tile being inquired
     */
    public Tile getTile(int row, int col) {
        System.out.println("Row: " + row + " Col: " + col);
        ArrayList<Tile> chunkRow;
        if(tiles.size() > row && row >= 0) {
            chunkRow = tiles.get(row);

            if(chunkRow != null && chunkRow.size() > col && col >= 0) {
                return chunkRow.get(col);
            }
        }
        return null;
    }
}
