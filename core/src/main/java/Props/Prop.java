package Props;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import io.github.CIDS_343_Group_6_Project.Entity;
import io.github.CIDS_343_Group_6_Project.Hitbox;

public abstract class Prop extends Entity {
    private boolean isInteractive;
    private String name;
    private boolean isDestroyed;
    private Rectangle hitbox;

    public Prop(Vector2 pos, TextureRegion texture, int width, int height, boolean isInteractive, String name) {
        super(pos, texture, width, height);
        this.isInteractive = isInteractive;
        this.name = name;
        this.isDestroyed = false;
        this.hitbox = new Rectangle(pos.x, pos.y, width, height);
    }

    public String getName() { return name; }
    public Rectangle getHitboxRect() { return this.hitbox; }

    public void setHitboxRect(Vector2 pos) { hitbox.setPosition(pos); }

    public void draw(SpriteBatch batch) {
        batch.draw(super.getTexture(), super.getPos().x, super.getPos().y);
    }
}

