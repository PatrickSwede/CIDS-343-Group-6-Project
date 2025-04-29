package io.github.CIDS_343_Group_6_Project;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Hitbox extends Entity {
    private Rectangle hitbox = new Rectangle();
    private Vector2 position = new Vector2();
    private float width;
    private float height;

    /**
     * A basic constructor which will be superimposed on following child classes
     *
     * @param pos     a vector representing position both x and y
     * @param texture the texture of the entity
     * @param width   the width represented as a float
     * @param height  the height represented as a float
     */
    public Hitbox(Vector2 pos, TextureRegion texture, float width, float height) {
        super(pos, texture, width, height);
        hitbox.setSize(width, height);
        hitbox.setPosition(pos.x, pos.y);
        this.width = width;
        this.height = height;
    }


    public void setWidth (float width){
        this.width = width;
    }
    public void setHeight (float height){
        this.height = height;
    }
    public void setPosition (float x, float y){
        this.position.set(x, y);
    }
    public Rectangle getHitbox(){
        return hitbox;
    }

}
