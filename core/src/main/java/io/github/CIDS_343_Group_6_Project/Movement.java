package io.github.CIDS_343_Group_6_Project;

import Characters.Character;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import map.Map;
import map.Tile;

public class Movement {
    Map map;
    Tile[][] tiles;
    int characterX;
    int characterY;

    public Movement(Map map, float characterX, float characterY) {
        this.map = map;
        this.tiles = map.getTiles();
        this.characterX = (int) characterX / 2;
        this.characterY = (int) characterY / 2;
    }

    private boolean checkCollision(Character character, Rectangle rect) {
        return character.getCollisionHitbox().getX() < rect.getX() + rect.getWidth() && character.getCollisionHitbox().getY() < rect.getY() + rect.getHeight() && character.getCollisionHitbox().getX() + character.getCollisionHitbox().getWidth() > rect.getX() && character.getCollisionHitbox().getY() + character.getCollisionHitbox().getHeight() > rect.getHeight();
    }

    public float Move(Character character, String direction, float speed) {
        Vector2 currentPos = character.getPos();
        int row;
        int col;
        Vector2 newPos;
        System.out.println((int) character.getPos().x + ". " + (int) character.getPos().y );
        switch (direction) {
            case "up":
                newPos = new Vector2(currentPos.x, currentPos.y + speed);
                row = (int) (map.getRowAtPos(newPos));
                col = (int) (map.getColAtPos(newPos));
                if(character.getPos().y + speed > Enums.SETTINGS.RESOLUTIONY.getValue() - 10) {
                    return 0;
                }
                if (!tiles[row][col].getIsPassable() && checkCollision(character, tiles[row][col].getCollisionHitbox())) {
                    return 0;
                }
                return speed;

            case "down":
                newPos = new Vector2(currentPos.x, currentPos.y - speed);
                row = (int) Math.floor(map.getRowAtPos(newPos));
                col = (int) Math.floor(map.getColAtPos(newPos));
                if (character.getPos().y - speed < 0) {
                    return 0;
                }
                if (!tiles[row][col].getIsPassable() && checkCollision(character, tiles[row][col].getCollisionHitbox())) {
                    return 0;
                }
                return -speed;

            case "right":
                newPos = new Vector2(character.getPos().x + speed, character.getPos().y);
                row = (int) Math.floor(map.getRowAtPos(newPos));
                col = (int) Math.floor(map.getColAtPos(newPos));
                if (character.getPos().x + speed > Enums.SETTINGS.RESOLUTIONX.getValue() - 10) {
                    return 0;
                }
                if (!tiles[row][col].getIsPassable() && checkCollision(character, tiles[row][col].getCollisionHitbox())) {
                    return 0;
                }
                return speed;

            case "left":
                newPos = new Vector2(character.getPos().x - speed, character.getPos().y);
                row = (int) Math.floor(map.getRowAtPos(newPos));
                col = (int) Math.floor(map.getColAtPos(newPos));
                if (character.getPos().x - speed < 0) {
                    return 0;
                }
                if (!tiles[row][col].getIsPassable() && checkCollision(character, tiles[row][col].getCollisionHitbox())) {
                    return 0;
                }
                return -speed;

            default:
                return 0;

        }
    }
}
