package io.github.CIDS_343_Group_6_Project;

/**
 * passive characters class under NPC
 * may be traders, pedestrians, etc
 */
public class Passive_Life extends NPC{

    /**
     * Constructor for Passive_Life class
     * @param life_name
     * @param life_health
     * @param life_magic
     * @param life_intelligence
     */
    public Passive_Life(String life_name, int life_health, int life_magic,int life_intelligence ){
        this.setControllable(false);
        this.setName(life_name);
        this.setCharacterHealth(life_health);
        this.setCharacterMagic(life_magic);
        this.setCharacterIntelligence(life_intelligence);
    }
}
