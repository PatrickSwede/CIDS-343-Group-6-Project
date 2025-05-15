package Props;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Consumable implements ActiveProp {
    private String name;
    private int consumableValue;

    public Consumable(String name, int consumableValue) {
        this.name = name;
        this.consumableValue = consumableValue;
    }


    public String getName() { return this.name; }

    public int getConsumableValue() { return this.consumableValue; }

    public void setName(String name) { this.name = name; }

    public void setConsumableValue(int consumableValue) { this.consumableValue = consumableValue; }
}
