package io.github.CIDS_343_Group_6_Project;

public class Character extends Entity{
    // character states
    private boolean controllable = false;
    private boolean alive = true;
    private boolean dead = false;
    private boolean hostile = false;

    // attributes
    public String name;
    private int character_health;
    private int character_Strength;
    private int character_magic;
    private int character_intelligence;

    // Constructors
    public Character(){

    }
    // getters
    public boolean getControllable(){
        return controllable;
    }
    public boolean getAlive(){
        return alive;
    }
    public boolean getDead(){
        return dead;
    }
    public boolean getHostile(){
        return hostile;
    }
    public int getCharacterHealth(){
        return character_health;
    }
    public int getCharacterStrength(){
        return character_Strength;
    }
    public int getCharacterMagic(){
        return character_magic;
    }
    public int getCharacterIntelligence(){
        return character_intelligence;
    }
    public String getName(){
        return name;
    }
    // Setters
    public void setControllable(boolean controllable){
        this.controllable = controllable;
    }
    public void setAlive(boolean alive){
        this.alive = alive;
    }
    public void setDead(boolean dead){
        this.dead = dead;
    }
    public void setHostile(boolean hostile){
        this.hostile = hostile;
    }
    public void setCharacterHealth(int health){
        this.character_health = health;
    }
    public void setCharacterStrength(int strength){
        this.character_Strength = strength;
    }
    public void setCharacterMagic(int magic){
        this.character_magic = magic;
    }
    public void setCharacterIntelligence(int intelligence){
        this.character_intelligence = intelligence;
    }
    public void setName(String name){
        this.name = name;
    }

}
