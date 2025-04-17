package io.github.CIDS_343_Group_6_Project;

import map.Chunk;
import map.EZChunk;
import map.Tile;

public class Movement {
    Character character;
    Chunk chunk;
    Tile[][] tiles;

    public Movement(Character character, EZChunk chunk) {
        this.character = character;
        this.chunk = chunk;
        this.tiles = chunk.getTiles();
    }

    public boolean isMoveValid(String direction) {
        int col = (int) Math.ceil(character.getPos().x / (80/3f));
        int row = (int) Math.ceil(character.getPos().y / (80/3f));

        Tile tile1;
        Tile tile2;
        switch (direction) {
            case "up right":
                tile1 = tiles[row + 1][col];
                tile2 = tiles[row][col + 1];
                return tile1.getCode().equals("1") && tile2.getCode().equals("1");

            case "up left":
                tile1 = tiles[row + 1][col];
                tile2 = tiles[row][col - 1];
                return tile1.getCode().equals("1") && tile2.getCode().equals("1");

            case "up":
                tile1 = tiles[row + 1][col];
                return tile1.getCode().equals("1");

            case "down right":
                tile1 = tiles[row - 1][col];
                tile2 = tiles[row][col + 1];
                return tile1.getCode().equals("1") && tile2.getCode().equals("1");

            case "down left":
                tile1 = tiles[row - 1][col];
                tile2 = tiles[row][col - 1];
                return tile1.getCode().equals("1") && tile2.getCode().equals("1");

            case "down":
                tile1 = tiles[row - 1][col];
                return tile1.getCode().equals("1");

            case "right":
                tile1 = tiles[row][col + 1];
                return tile1.getCode().equals("1");

            case "left":
                tile1 = tiles[row][col - 1];
                return tile1.getCode().equals("1");

            default:
                return false;
        }
    }
}
