package io.github.CIDS_343_Group_6_Project;

import com.badlogic.gdx.math.Vector2;

public class Shield extends Prop {
    private int defenceValue;

    public Shield(String name, Vector2 position, boolean isInteractive, String description, int defenceValue) {
        super(name, position, isInteractive, description);
        this.defenceValue = defenceValue;
    }

    public int getDefenceValue(){
        return defenceValue;
    }
}
