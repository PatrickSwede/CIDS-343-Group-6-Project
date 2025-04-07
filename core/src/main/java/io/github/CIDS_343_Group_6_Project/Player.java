package io.github.CIDS_343_Group_6_Project;

import com.badlogic.gdx.graphics.Texture;

/** Player class under character
 *
 */
public class Player extends Character{
    // Data Fields
    // test texture
    /** player texture
     * currently a placeholder, may not integrate with driver though
     */
    static Texture playerTexture = new Texture("kiryu-chan - Copy.png");

    //Constructors

    /**
     * constructor for making a player object
     * @param player_name
     * set Controllable from character parent to true
     */
    public Player(String player_name){
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




}
