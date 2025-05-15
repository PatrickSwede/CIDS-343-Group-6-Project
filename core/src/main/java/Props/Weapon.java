package Props;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Weapon extends Prop{
    private int damage;

    public Weapon(Vector2 pos, TextureRegion texture, int width, int height, boolean isInteractive, String name, int damage) {
        super(pos, texture, width, height, isInteractive, name);
        this.damage = damage;
    }

    public int getDamage() { return damage; }

    public void setDamage(int damage) { this.damage = damage; }


}
