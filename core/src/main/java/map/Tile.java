package map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import io.github.CIDS_343_Group_6_Project.Enums.TILETYPE;
import io.github.CIDS_343_Group_6_Project.Entity;
import com.badlogic.gdx.math.Vector2;

/**
 * A class for instantiating tiles which will be used in chunks to represent the environment
 * @author Patrick Swedenborg
 */
public class Tile extends Entity {
    private float size;
    private int row;
    private int col;
    private TextureRegion secondaryTexture;
    private TILETYPE type;
    private String code;
    private boolean isPassable;
    private Rectangle collisionHitbox;

    /**
     * A constructor to instantiate a new tile
     * @param x a float representing the x direction of the position vector
     * @param y a float representing the y direction of the position vector
     * @param size an int representing the size of the tile
     * @param type the type of tile with all possible types in the Enums class
     * @param texture the primary texture for the tile
     */
    public Tile(float x, float y, float size, TextureRegion texture, TILETYPE type, boolean isPassable) {
        super(new Vector2(x,y), texture, size, size);
        this.size = size;
        this.col = (int) x;
        this.row = (int) y;
        this.type = type;
        this.code = "";
        this.isPassable = isPassable;
        this.collisionHitbox = new Rectangle(x, y, size, size);

    }

    /**
     * Getter for size attribute
     * @return size
     */
    public float getSize(){
        return size;
    }

    /**
     * Getter for row attribute
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * Getter for col attribute
     * @return col
     */
    public int getCol() {
        return col;
    }

    /**
     * Getter for secondaryTexture attribute
     * @return secondaryTexture
     */
    public TextureRegion getSecondaryTexture() {
        return secondaryTexture;
    }

    /**
     * Getter for type attribute
     * @return type
     */
    public TILETYPE getType() {
        return type;
    }

    /**
     * Getter for code attribute
     * @return code
     */
    public String getCode() {
        return code;
    }

    public boolean getIsPassable() {return isPassable;}

    public Rectangle getCollisionHitbox() {
        return collisionHitbox;
    }

    /**
     * Setter for size attribute
     * @param size the new size represented as an int
     */
    public void setSize(float size) {
        this.size = size;
    }

    /**
     * Setter for row attribute
     * @param row the new row represented as an int
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Setter for col attribute
     * @param col the new col represented as an int
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Setter for secondaryTexture attribute
     * @param secondaryTexture the new secondary texture represented as a Texture
     */
    public void setSecondary_texture(TextureRegion secondaryTexture) {
        this.secondaryTexture = secondaryTexture;
    }

    /**
     * Setter for type attribute
     * @param type represented as a TILETYPE selection from the Enums class
     */
    public void setType(TILETYPE type) {
        this.type = type;
    }

    /**
     * Setter for the code attribute
     * @param code the new code represented as a string
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Setter for isPassable attribute
     * @param isPassable represented as a boolean
     */
    public void setIsPassable(boolean isPassable) {
        this.isPassable = isPassable;
    }

    /**
     * An overridden toString method to represent the tile as a string
     * @return the tile represented as a string
     */
    @Override
    public String toString() {
        return getPos().toString() + " row " +  row + " col: " + col + " type: " + type;
    }
}
