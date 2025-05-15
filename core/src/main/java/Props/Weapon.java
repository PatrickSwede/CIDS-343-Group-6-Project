package Props;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import io.github.CIDS_343_Group_6_Project.Entity;
import map.Interactable;

public class Weapon extends Entity implements ActiveProp, Interactable {
    private String name;
    private int damage;
    private Rectangle hitbox;

    public Weapon(Vector2 pos, TextureRegion texture, int width, int height, String name, int damage) {
        super(pos, texture, width, height);
        this.name = name;
        this.damage = damage;
        this.hitbox = new Rectangle(pos.x, pos.y, width, height);
    }

    public String getName() { return this.name; }

    public int getDamage() { return this.damage; }

    public Rectangle getHitbox() { return this.hitbox; }

    public void setName(String name) { this.name = name; };

    public void setDamage(int damage) { this.damage = damage; }

    public void setHitbox(Vector2 pos) { this.hitbox.setPosition(pos.x, pos.y); }


}

