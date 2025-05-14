package io.github.CIDS_343_Group_6_Project;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
public abstract class Prop {
    protected String name;
    protected Vector2 position;
//    protected int x, y; // position
    protected boolean isInteractive;
    protected boolean isDestroyed;

    protected String description;
    protected Hitbox hitbox;

    public Prop(String name, Vector2 position, boolean isInteractive,String description) {
        this.name = name;
        this.isInteractive = isInteractive;
        this.isDestroyed = false;
//        this.x = x;
//        this.y = y;
        this.position = position;
        this.description = description;
        this.hitbox = new Hitbox(position,null, 10, 10 );
    }

//    public void interact();

//    public int getX() { return x; }
//    public int getY() { return y; }
    public String getDescription() { return description; }

    public void setPostiion(Vector2 postition ) {
        this.position = postition; }
}
