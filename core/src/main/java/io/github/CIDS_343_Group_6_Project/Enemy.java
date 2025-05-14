package Characters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Enemy class under NPC
 */
public class Enemy extends NPC{

    /**
     * constructor for Enemy class
     * @param enemy_name
     * @param enemy_health
     * @param enemy_magic
     * @param enemy_intelligence
     */
    public Enemy(Vector2 pos, TextureRegion texture, float width, float height, String enemy_name, int enemy_health, int enemy_magic, int enemy_intelligence ){
        super(new Vector2(pos.x, pos.y), texture, width, height,enemy_health);
        this.setControllable(false);
        this.setName(enemy_name);
        this.setCharacterHealth(enemy_health);
        this.setCharacterMagic(enemy_magic);
        this.setCharacterIntelligence(enemy_intelligence);
    }


}
