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

    public static final TextureRegion[][] textures = getTileSet();

    public enum TILETYPE {

        GRASS   (textures[1][0]),
        WATER   (textures[1][14]);

        private final TextureRegion texture;

        TILETYPE(TextureRegion texture) {
            this.texture = texture;
        }

        public TextureRegion getValue() {
            return texture;
        }


    }

}
