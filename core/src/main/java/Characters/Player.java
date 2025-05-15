package Characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import Props.Prop;
import java.util.ArrayList;

/** Player class under character
 *
 */
public class Player extends Character {
    // Data Fields
    // test texture
    /** player texture
     * currently a placeholder, may not integrate with driver though
     */
    static Texture playerTexture = new Texture("kiryu-chan - Copy.png");
    private ArrayList <Prop> inventory = new ArrayList<Prop>();
    //Constructors

    /**
     * constructor for making a player object
     * @param player_name
     * set Controllable from character parent to true
     */
    public Player(Vector2 pos, TextureRegion texture, float width, float height, String player_name, int playerHealth){
        super(new Vector2(pos.x, pos.y), texture, width, height, playerHealth);
        this.name = player_name;
        this.setControllable(true);
    }


    // getters

    /**
     * getter for player texture
     * @return playerTexture
     */
    public static Texture getPlayerTexture(){
        return playerTexture;
    }
    public ArrayList <Prop> getInventory(){
        return inventory;
    }
    public void addToInventory(Prop prop){
        inventory.add(prop);
    }
    public Prop getInventoryItem(int index){
        return inventory.get(index);
    }
}
