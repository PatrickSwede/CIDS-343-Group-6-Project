package io.github.CIDS_343_Group_6_Project;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * passive characters class under NPC
 * may be traders, pedestrians, etc
 */
public class Passive_Life extends NPC{

    /**
     * Constructor for Passive_Life class
     * @param life_name
     * @param life_health
     * @param life_magic
     * @param life_intelligence
     */
    public Passive_Life(Vector2 pos, TextureRegion texture, float width, float height, String life_name, int life_health, int life_magic, int life_intelligence ){
        super(new Vector2(pos.x, pos.y), texture, width, height);
        this.setControllable(false);
        this.setName(life_name);
        this.setCharacterHealth(life_health);
        this.setCharacterMagic(life_magic);
        this.setCharacterIntelligence(life_intelligence);
    }
}
