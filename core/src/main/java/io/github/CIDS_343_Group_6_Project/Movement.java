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
                if(character.getPos().y + speed > Enums.SETTINGS.RESOLUTIONY.getValue() - 10) {
                    return 0;
                }

                Vector2[] topPoints = character.getPlayerTopPoints();
                Tile[] topTiles = new Tile[2];
                topTiles[0] = map.getTileAtPos(topPoints[0]);
                topTiles[1] = map.getTileAtPos(topPoints[1]);
                System.out.println(topTiles[0].getIsPassable());
                System.out.println(topTiles[1].getIsPassable());


                for(int i =0; i < 2; i++) {
                    if (!topTiles[i].getIsPassable()) {
                        return 0;
                    }
                }
                character.setCharacterCoords(newPos);
                return speed;

            case "down":
                newPos = new Vector2(currentPos.x, currentPos.y - speed);
                if (character.getPos().y - speed < 0) {
                    return 0;
                }
                Vector2[] botPoints = character.getPlayerBotPoints();
                Tile[] botTiles = new Tile[2];
                botTiles[0] = map.getTileAtPos(botPoints[0]);
                botTiles[1] = map.getTileAtPos(botPoints[1]);
                System.out.println(botTiles[0].getIsPassable());
                System.out.println(botTiles[1].getIsPassable());


                for(int i =0; i < 2; i++) {
                    if (!botTiles[i].getIsPassable()) {
                        return 0;
                    }
                }
                character.setCharacterCoords(newPos);
                return -speed;

            case "right":
                newPos = new Vector2(character.getPos().x + speed, character.getPos().y);
                if (character.getPos().x + speed > Enums.SETTINGS.RESOLUTIONX.getValue() - 10) {
                    return 0;
                }
                Vector2[] rightPoints = character.getPlayerRightPoints();
                Tile[] rightTiles = new Tile[2];
                rightTiles[0] = map.getTileAtPos(rightPoints[0]);
                rightTiles[1] = map.getTileAtPos(rightPoints[1]);
                System.out.println(rightTiles[0].getIsPassable());
                System.out.println(rightTiles[1].getIsPassable());


                for(int i =0; i < 2; i++) {
                    if (!rightTiles[i].getIsPassable()) {
                        return 0;
                    }
                }
                character.setCharacterCoords(newPos);
                return speed;

            case "left":
                newPos = new Vector2(character.getPos().x - speed, character.getPos().y);
                if (character.getPos().x - speed < 0) {
                    return 0;
                }
                Vector2[] leftPoints = character.getPlayerLeftPoints();
                Tile[] leftTiles = new Tile[2];
                leftTiles[0] = map.getTileAtPos(leftPoints[0]);
                leftTiles[1] = map.getTileAtPos(leftPoints[1]);
                System.out.println(leftTiles[0].getIsPassable());
                System.out.println(leftTiles[1].getIsPassable());


                for(int i =0; i < 2; i++) {
                    if (!leftTiles[i].getIsPassable()) {
                        return 0;
                    }
                }
                character.setCharacterCoords(newPos);
                return -speed;

            default:
                return 0;

        }
    }
  
    public void enemyMove (Vector2 playerpos, Vector2 enemypos, float speed) {
        if (enemypos.x < playerpos.x) {
            int min = (int) (playerpos.x - enemypos.x < speed ? playerpos.x - enemypos.x : speed);
                enemypos.x += min;
        } else if (enemypos.x > playerpos.x) {
            int min = (int) (enemypos.x - playerpos.x < speed ? enemypos.x - playerpos.x : speed);
            enemypos.x -= min;
        }
        if (enemypos.y < playerpos.y) {
            int min = (int) (playerpos.y - enemypos.y < speed ? playerpos.y - enemypos.y : speed);
            enemypos.y += min;
        } else if (enemypos.y > playerpos.y) {
            int min = (int) (enemypos.y - playerpos.y < speed ? enemypos.y - playerpos.y : speed);
            enemypos.y -= min;
        }
    }


    // enemy movement refrence from zombiegame by Dr. Jacob Hendricks
//    public Pair move(int x, int y, int dest_x, int dest_y, int speed){
//        if (x < dest_x) {
//            int min = dest_x - x < speed ? dest_x - x : speed;
//            x += min;
//        } else if (x > dest_x) {
//            int min = x - dest_x < speed ? x - dest_x : speed;
//            x -= min;
//        }
//
//        if (y < dest_y) {
//            int min = dest_y - y < speed ? dest_y - y : speed;
//            y += min;
//        } else if (y > dest_y) {
//            int min = y - dest_y < speed ? y - dest_y : speed;
//            y -= min;
//        }
//        Pair coord = new Pair();
//        coord.x = x;
//        coord.y = y;
//        return coord;
//
//    }
}
