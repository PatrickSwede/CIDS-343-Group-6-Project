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
        float spawnTileX;
        float spawnTileY;
        Tile[][] tiles = map.getTiles();
        int chunkSize = map.getChunkSize();
        Enemy enemy;
        ArrayList<Enemy> enemies = new ArrayList<>();

        for (int y = 0; y < map.getSize(); y++) {
            for (int x = 0; x < map.getSize(); x++) {
                if (tiles[(y * chunkSize) + (chunkSize / 2)][(x *  chunkSize) + (chunkSize / 2)].getIsPassable()) {
                    spawnTileX = tiles[(y * chunkSize) + (chunkSize / 2)][(x *  chunkSize) + (chunkSize / 2)].getPos().x;
                    spawnTileY = tiles[(y * chunkSize) + (chunkSize / 2)][(x *  chunkSize) + (chunkSize / 2)].getPos().y;
                    enemy = new Enemy(new Vector2(spawnTileX, spawnTileY), Enums.ENEMIES.FIRST.getValue(),
                       characterSizeX, characterSizeY, "Bad Guy", 10, 10, 10);
                    enemies.add(enemy);

                }
            }
        }
        return enemies;
    }
}
