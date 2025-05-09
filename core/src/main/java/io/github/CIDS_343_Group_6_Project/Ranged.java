package io.github.CIDS_343_Group_6_Project;

import com.badlogic.gdx.math.Vector2;


public class Ranged extends Weapon{
   private Vector2 projectilePos;
   private Hitbox projectileHitbox;

    public Ranged(String name, Vector2 position, boolean isInteractive, String description) {
        super(name, position, isInteractive, description);
    }

    public void shoot(){
        int distance = 0;
        projectilePos = new Vector2();
        projectileHitbox = new Hitbox(projectilePos, null, 1, 1);
        while(distance > 200){
            projectilePos.y += distance;
            projectileHitbox.setPosition(projectilePos);
            distance++;
        }

    }
}
