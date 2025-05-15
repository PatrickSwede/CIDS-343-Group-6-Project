package Props;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Consumable extends Prop{
    private int ConsumableValue = 0;

    public Consumable(Vector2 pos, TextureRegion texture, int width, int height, boolean isInteractive,
                      String name, int ConsumableValue) {
        super(pos, texture, width, height, isInteractive, name);
        this.ConsumableValue = ConsumableValue;
    }

    public int usesConsumable() {
        return ConsumableValue;
    }
}
