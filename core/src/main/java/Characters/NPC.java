package Characters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Abstract class for a non-playable characters
 * child of character class
 */
public class NPC extends Character {

    NPC(Vector2 pos, TextureRegion texture, float width, float height, int health) {
        super(new Vector2(pos.x, pos.y), texture, width, height, health);
    }
}
