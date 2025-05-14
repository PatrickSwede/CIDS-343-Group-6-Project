package io.github.CIDS_343_Group_6_Project;

import com.badlogic.gdx.math.Vector2;

public class Consumable extends Prop{
    private int ConsumableValue = 0;

    public Consumable(String name, Vector2 position, boolean isInteractive, String description, int ConsumableValue) {
        super(name, position, isInteractive, description);
        this.ConsumableValue = ConsumableValue;
    }

    public int usesConsumable() {
        return ConsumableValue;
    }
}
