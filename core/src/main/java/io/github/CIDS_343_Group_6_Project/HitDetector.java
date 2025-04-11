package io.github.CIDS_343_Group_6_Project;
import com.badlogic.gdx.math.Rectangle;
import map.Tile;
import org.w3c.dom.css.Rect;

public class HitDetector {
    private boolean isHit;


    public void checkIfHit(Rectangle rect1, Rectangle rect2){
        if(rect1.overlaps(rect2)){
            isHit = true;
        }
    }







}




