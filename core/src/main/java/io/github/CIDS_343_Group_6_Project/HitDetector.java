package io.github.CIDS_343_Group_6_Project;
import com.badlogic.gdx.math.Rectangle;
import map.Tile;
import org.w3c.dom.css.Rect;

public class HitDetector {
    private boolean isHit;

    /** Constructor for making object
     *
     */
    // Constructor ----------------------------------------------------------
    public HitDetector(){
        isHit = false;
    }


    /**
     * Getter and settor for checking to see of two objects are hitting
     * it sets isHit to true or false depending on if two rectangles are
     * hitting if they overlap
     * then returns what isHit is set to.
     * @param rect1
     * @param rect2
     */
    public boolean checkIfHit(Rectangle rect1, Rectangle rect2){
        if(rect1.overlaps(rect2)){
            isHit = true;
        } else {
            isHit = false;
        }
        return isHit;
    }







}




