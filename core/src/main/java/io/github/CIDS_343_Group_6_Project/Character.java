package io.github.CIDS_343_Group_6_Project;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * An abstract class to represent all characters in the game.
 * it is a child of the Entity class
 */
public class Character extends Entity {
    /**
     * A basic constructor to make a Character with no parameters
     */
    // Constructors
    public Character(Vector2 pos, TextureRegion texture, float width, float height, int health) {
        super(new Vector2(pos.x, pos.y), texture, width, height);
        hitBox.setX(pos.x);
        hitBox.setY(pos.y);
    }

    // character states
    /**
     * Character states that show the current state a character is in
     * {@code @boolean} controllable: is the character controllable?
     * {@code @boolean} alive: is the Character alive?
     * {@code @boolean} dead: is the Character dead? (opposite of alive)
     * {@code @boolean} hostile: is the Character hostile to the player?
     */
    private boolean controllable = false;
    private boolean alive = true;
    private boolean dead = false;
    private boolean hostile = false;

    // attributes
    /**
     * Basic Attributes for all Characters
     * {@code @String} name: the name of the Character
     * {@code @int} character_health: how much health the Character has
     * {@code @int} character_Strength: how much strength the Character has
     * {@code @int} character_magic: how good at magic is the Character
     * {@code @int} character_intelligence: how smart is the Character
     */
    public String name;
    private int character_health;
    private int character_Strength;
    private int character_magic;
    private int character_intelligence;

    //Rectangle
    /**
     * for hit detection
     */
    private Rectangle hitBox = new Rectangle();
    private HitDetector hitDetector = new HitDetector();


    // getters ---------------------------------------------------------------
    //------------------------------------------------------------------------

    /**
     * state getters
     * Getter for controllabe
     *
     * @return controllable
     */
    public boolean getControllable() {
        return controllable;
    }

    /**
     * Getter for alive
     *
     * @return alive
     */
    public boolean getAlive() {
        return alive;
    }

    /**
     * getter for dead
     *
     * @return dead
     */
    public boolean getDead() {
        return dead;
    }

    /**
     * getter for hostile
     *
     * @return hostile
     */
    public boolean getHostile() {
        return hostile;
    }

    /**
     * Attribute getters
     * getter for character_health
     *
     * @return
     */
    public int getCharacterHealth() {
        return character_health;
    }

    /**
     * getter for character_strength
     *
     * @return character_Strength
     */
    public int getCharacterStrength() {
        return character_Strength;
    }

    /**
     * getter for character magic
     *
     * @return character_magic
     */
    public int getCharacterMagic() {
        return character_magic;
    }

    /**
     * getter for character intelligence
     *
     * @return character_intelligence
     */
    public int getCharacterIntelligence() {
        return character_intelligence;
    }

    /**
     * getter for name
     *
     * @return name
     */
    public String getName() {
        return name;
    }
    // Setters ---------------------------------------------------------------
    //------------------------------------------------------------------------

    /**
     * setter for controlable
     *
     * @param controllable
     */
    public void setControllable(boolean controllable) {
        this.controllable = controllable;
    }

    /**
     * setter for alive
     *
     * @param alive
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * setter for dead
     *
     * @param dead
     */
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    /**
     * setter for hostile
     *
     * @param hostile
     */
    public void setHostile(boolean hostile) {
        this.hostile = hostile;
    }

    /**
     * setter for character health
     *
     * @param health
     */
    public void setCharacterHealth(int health) {
        this.character_health = health;
    }

    /**
     * setter for characterstrength
     *
     * @param strength
     */
    public void setCharacterStrength(int strength) {
        this.character_Strength = strength;
    }

    /**
     * setter for character magic
     *
     * @param magic
     */
    public void setCharacterMagic(int magic) {
        this.character_magic = magic;
    }

    /**
     * setter for character intelligence
     *
     * @param intelligence
     */
    public void setCharacterIntelligence(int intelligence) {
        this.character_intelligence = intelligence;
    }

    /**
     * setter for name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public boolean checkIfDead(){
        if(character_health <= 0){
            this.dead = true;
        }else{
            this.dead = false;
        }
        return dead;
    }

}


