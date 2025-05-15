package io.github.CIDS_343_Group_6_Project;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Enums {

    private static TextureRegion[][] getTileSet() {
        Texture tileMap = new Texture(Gdx.files.internal("tileset.png"));
        TextureRegion[][] textures = new TextureRegion[32][32];
        for(int i = 0; i < 32; i++) {
            for(int j = 0; j< 32; j++) {
                textures[i][j] = new TextureRegion(tileMap, i * 8, j * 8 , 8,  8);
            }
        }
        return textures;
    }

    private static TextureRegion[][] getPlayerStances() {
        Texture tileMap = new Texture(Gdx.files.internal("mervin.png"));
        TextureRegion[][] textures = new TextureRegion[8][4];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 4; j++) {
                textures[i][j] = new TextureRegion(tileMap, i * 8, j * 8, 8, 8);
            }
        }
        return textures;
    }


    private static TextureRegion[][] getEnemies() {
        Texture tileMap = new Texture(Gdx.files.internal("enemies.png"));
        TextureRegion[][] textures = new TextureRegion[2][11];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 11; j++) {
                textures[i][j] = new TextureRegion(tileMap, i * 8, j * 11, 8, 8);
            }
        }
        return textures;
    }

    private static TextureRegion[][] getWeapons() {
        Texture tileMap = new Texture(Gdx.files.internal("Sheet_Small.png"));
        TextureRegion[][] textures = new TextureRegion[8][4];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                textures[i][j] = new TextureRegion(tileMap, i * 8, j * 8, 8, 8);
            }
        }
        return textures;
    }



    public static final TextureRegion[][] textures = getTileSet();

    public static final TextureRegion[][] player = getPlayerStances();

    public static final TextureRegion[][] enemy = getEnemies();

    public static final TextureRegion[][] weapon = getWeapons();

    public enum TILETYPE {

        GRASS   (textures[1][0]),
        WATER   (textures[1][14]),
        TREES   (textures[17][1]);

        private final TextureRegion texture;

        TILETYPE(TextureRegion texture) {
            this.texture = texture;
        }

        public TextureRegion getValue() {
            return texture;
        }


    }

    public enum PLAYER {

        STANDING (player[0][1]),
        MOVINGR (player[0][2]),
        MOVINGL (player[0][3]);

        private final TextureRegion texture;

        PLAYER(TextureRegion texture) {this.texture = texture;}

        public TextureRegion getValue() {return texture;}

    }


    public enum ENEMIES {
        FIRST (enemy[0][0]),
        SECOND (enemy[0][1]),
        THIRD (enemy[0][2]);

        private final TextureRegion texture;

        ENEMIES(TextureRegion texture) {this.texture = texture;}

        public TextureRegion getValue() {return texture;}
    }

    public enum WEAPONS {
        STARTER (weapon [0][3]);

        private final TextureRegion texture;

        WEAPONS(TextureRegion texture) {this.texture = texture;}

        public TextureRegion getValue() {return texture;}
    }



    public enum SETTINGS {
        RESOLUTIONX     (810),
        RESOLUTIONY     (810);

        private final int resolution;

        SETTINGS(int resolution) {this.resolution = resolution;}

        public int getValue() { return resolution;}
    }

}
