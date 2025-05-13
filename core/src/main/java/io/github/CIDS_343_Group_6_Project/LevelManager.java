package io.github.CIDS_343_Group_6_Project;

public class LevelManager {
    private static int level = 1;

    public static int getLevel() {
        return level;
    }

    public static void levelUp() {
        level++;
        System.out.println("Level increased to " + level);
    }

    public static void applyLevelToEnemy(Character enemy) {
        if (enemy instanceof Enemy) {
            enemy.setCharacterStrength(level * 2); // Example: scale strength
            enemy.setCharacterHealth(level * 10); // Example: scale health
            System.out.println(enemy.getName() + " scaled to level " + level);
        }
    }
}
