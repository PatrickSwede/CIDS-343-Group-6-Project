package io.github.CIDS_343_Group_6_Project;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bladed extends Weapon{
    private SpriteBatch swordbatch;
    private Texture swordTexture = new Texture("diamond_sword.jpg");
    private Sprite swordSprite = new Sprite(swordTexture);
    SpriteBatch batch = new SpriteBatch();

    public Bladed(String name, Vector2 position, boolean isInteractive, String description) {
        super(name, position, isInteractive, description);
    }

    public void Swing(){
        float oldWidth = hitbox.getWidth();
        float oldHeight = hitbox.getHeight();
        batch.begin();
        swordSprite.draw(batch);
        hitbox.setBoxArea(oldWidth + 10, oldHeight + 10);
        hitbox.setBoxArea(oldWidth, oldHeight);
        batch.end();
    }

}
