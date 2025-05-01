package io.github.CIDS_343_Group_6_Project;

import com.badlogic.gdx.math.Vector2;

public class Bladed extends Prop{

    public Bladed(String name, Vector2 position, boolean isInteractive, String description) {
        super(name, position, isInteractive, description);
    }

    public void Swing(){
        float oldWidth = hitbox.getWidth();
        float oldHeight = hitbox.getHeight();
        hitbox.setBoxArea(oldWidth + 10, oldHeight + 10);
        hitbox.setBoxArea(oldWidth, oldHeight);
    }

}
