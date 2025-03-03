package map;

import io.github.CIDS_343_Group_6_Project.Enums.TILETYPE;
import com.badlogic.gdx.graphics.Texture;
import io.github.CIDS_343_Group_6_Project.Entity;

public class Tile extends Entity {
    public int size;
    public int row;
    public int col;
    public Texture secondary_texture;
    public Texture texture;
    public TILETYPE type;
    public String code;

    public Tile(float x, float y, int size, TILETYPE type, Texture texture) {
        pos.x = x * size;
        pos.y = y * size;
        this.size = size;
        this.texture = texture;
        this.col = (int) x;
        this.row = (int) y;
        this.type = type;
        this.code = "";
    }

    public TILETYPE getTILETYPE() {
        return type;
    }

    public boolean isPassable() {
        if (type == TILETYPE.GRASS) {
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return "x: " + pos.x + " y: " + pos.y + " row: " + row + " col: " + col + " type: " + type;
    }
}
