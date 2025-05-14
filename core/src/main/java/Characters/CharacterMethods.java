package Characters;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import io.github.CIDS_343_Group_6_Project.Enums;
import map.Map;
import map.Tile;

import java.util.ArrayList;

public class CharacterMethods {
    public static Player initializePlayer(int spawnTileX, int spawnTileY, float characterSizeX, float characterSizeY,
                                             TextureRegion playerTexture, Sprite playerSprite) {
        Player player = new Player(new Vector2( spawnTileX * characterSizeX,
            spawnTileY * characterSizeY ), playerTexture,
            characterSizeX,characterSizeY, "The Guy", 100);
        playerSprite.translateX(spawnTileX * characterSizeX);
        playerSprite.translateY(spawnTileY * characterSizeY);
        return player;
    }

    public static ArrayList<Enemy> initializeEnemies(float characterSizeX, float characterSizeY, Map map) {
        int spawnTileX;
        int spawnTileY;
        Tile[][] tiles = map.getTiles();
        int chunkSize = map.getChunkSize();
        Enemy enemy;
        ArrayList<Enemy> enemies = new ArrayList<>();

        for (int i = 0; i < map.getNumberRows() / map.getSize(); i++) {
            for (int j = 0; j < map.getNumberCols() / map.getSize(); j++) {
                if (tiles[(i * (int) chunkSize) + (chunkSize / 2)][(j * (int) chunkSize) + (chunkSize / 2)].getIsPassable()) {
                    spawnTileX = (i * (int) characterSizeX) + chunkSize / 2;
                    spawnTileY = (j * (int) characterSizeX) + chunkSize / 2;
                    enemy = new Enemy(new Vector2(spawnTileX * characterSizeX, spawnTileY * characterSizeY), Enums.ENEMIES.FIRST.getValue(),
                       characterSizeX, characterSizeY, "Bad Guy", 10, 10, 10);
                    enemies.add(enemy);

                }
            }
        }
        return enemies;
    }
}
