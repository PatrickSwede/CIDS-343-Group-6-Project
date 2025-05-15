package map;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

public interface Interactable {

    public Rectangle getHitbox();

    public void setHitbox(Vector2 pos);
}
