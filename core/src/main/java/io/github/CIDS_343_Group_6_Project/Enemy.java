package io.github.CIDS_343_Group_6_Project;

/**
 * Enemy class under NPC
 */
public class Enemy extends NPC{

    /**
     * constructor for Enemy class
     * @param enemy_name
     * @param enemy_health
     * @param enemy_magic
     * @param enemy_intelligence
     */
    public Enemy(String enemy_name, int enemy_health, int enemy_magic,int enemy_intelligence ){
        this.setControllable(false);
        this.setName(enemy_name);
        this.setCharacterHealth(enemy_health);
        this.setCharacterMagic(enemy_magic);
        this.setCharacterIntelligence(enemy_intelligence);
    }
}
