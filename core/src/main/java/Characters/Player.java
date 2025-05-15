package Characters;

import Props.ActiveProp;
import Props.Inventory;
import Props.PassiveProp;
import Props.Weapon;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.sun.java.swing.plaf.windows.TMSchema;
import map.Interactable;

import java.util.ArrayList;

/** Player class under character
 *
 */
public class Player extends Character implements Inventory, Interactable {
    // Attributes
    private ArrayList<ActiveProp> activeProps;
    private ArrayList<PassiveProp> passiveProps;
    private Rectangle hitbox;
    private Weapon equippedWeapon;

    //Constructors
    /**
     * constructor for making a player object
     * @param name
     * set Controllable from character parent to true
     */
    public Player(Vector2 pos, TextureRegion texture, float width, float height, String name, int playerHealth){
        super(new Vector2(pos.x, pos.y), texture, width, height, playerHealth);
        this.name = name;
        this.setControllable(true);
        this.hitbox = new Rectangle(pos.x, pos.y, width, height);
        this.activeProps = new ArrayList<>();
        this.passiveProps = new ArrayList<>();
    }

    public void addToActiveProps(ActiveProp thing) { activeProps.add(thing); }

    // Getters

    public ArrayList<ActiveProp> getActiveProps() { return this.activeProps; }

    public ArrayList<PassiveProp> getPassiveProps() { return this.passiveProps; }

    public Rectangle getHitbox() { return this.hitbox; }

    public Weapon getEquippedWeapon() { return this.equippedWeapon; }

    // Setters

    public void setActiveProps(ArrayList<ActiveProp> activeProps) { this.activeProps = activeProps; }

    public void setPassiveProps(ArrayList<PassiveProp> passiveProps) { this.passiveProps =  passiveProps; }

    public void setHitbox(Vector2 pos) { this.hitbox.setPosition(pos.x, pos.y); }

    public void setEquippedWeapon(Weapon weapon) { this.equippedWeapon = weapon;}
}
