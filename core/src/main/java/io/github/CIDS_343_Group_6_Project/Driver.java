package io.github.CIDS_343_Group_6_Project;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import map.Chunk;
import map.Tile;

// Adding Comment for Preliminary Project Research Assignment

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Driver implements ApplicationListener {
    Texture backGroundTexture;
    Texture bucketTexture;
    Texture dropTexture;
    Sound dropSound;
    Music music;
    SpriteBatch spriteBatch;
    FitViewport viewport;
    Sprite bucketSprite;
    Vector2 touchPos;
    Array<Sprite> dropSprites;
    float dropTimer;
    Rectangle bucketRectangle;
    Rectangle dropRectangle;
    Control keyPress = new Control (8,5,new OrthographicCamera());

    // For hard coded map
    Tile[][] tiles;
    Chunk chunk;


    @Override
    public void create() {
        // objects
        bucketTexture = new Texture("bucket.png");
        dropTexture = new Texture("drop.png");
        dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.mp3"));
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(800, 800);
        bucketSprite = new Sprite(bucketTexture);
        bucketSprite.setSize(50, 50);
        touchPos = new Vector2();
        dropSprites = new Array<>();
        bucketRectangle = new Rectangle();
        dropRectangle = new Rectangle();
        Gdx.input.setInputProcessor(keyPress);


        // For hard coded map
        tiles = new Tile[30][30];
        TextureRegion tempText;

        for(int i = 0; i < 30; i++) {
            for(int j = 0; j < 30; j++) {
                if((i < 5 || i > 24) || (j < 5 || j > 24)) {tempText = Enums.TILETYPE.WATER.getValue();}
                else {tempText = Enums.TILETYPE.GRASS.getValue();}
                tiles[i][j] = new Tile(j, i,  80/3f , tempText, Enums.TILETYPE.WATER);
                }
            }

        chunk = new Chunk(30, 30, tiles);
        chunk.setTiles(tiles);
    }



    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        // Hello World!!!
        input();
        logic();
        draw();
    }

    private void input() {

        float speed = 1000f;
        float delta = Gdx.graphics.getDeltaTime();

        if (keyPress.getUp() && keyPress.getRight()) {
            bucketSprite.translateY(speed * delta);
            bucketSprite.translateX(speed * delta);
        } else if (keyPress.getUp() && keyPress.getLeft()) {
            bucketSprite.translateY(speed * delta);
            bucketSprite.translateX(-speed * delta);
        } else if (keyPress.getUp()) {
            bucketSprite.translateY(speed * delta);
        } else if (keyPress.getDown() && keyPress.getRight()) {
            bucketSprite.translateY(-speed * delta);
            bucketSprite.translateX(speed * delta);
        } else if (keyPress.getDown() && keyPress.getLeft()) {
            bucketSprite.translateY(-speed * delta);
            bucketSprite.translateX(-speed * delta);
        } else if (keyPress.getDown()) {
            bucketSprite.translateY(-speed * delta);
        } else if(keyPress.getRight()) {
            bucketSprite.translateX(speed * delta);
        } else if(keyPress.getLeft()) {
            bucketSprite.translateX(-speed * delta);
        }
        if (Gdx.input.isTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            viewport.unproject(touchPos);
            bucketSprite.setCenterX(touchPos.x);
            bucketSprite.setCenterY(touchPos.y);
        }
    }

    private void logic() {
        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();
        float bucketWidth = bucketSprite.getWidth();
        float bucketHeight = bucketSprite.getHeight();

        bucketSprite.setX(MathUtils.clamp(bucketSprite.getX(), 0, worldWidth- bucketWidth));
        bucketSprite.setY(MathUtils.clamp(bucketSprite.getY(), 0, worldHeight - bucketHeight));

        float delta = Gdx.graphics.getDeltaTime();
        bucketRectangle.set(bucketSprite.getX(), bucketSprite.getY(), bucketWidth, bucketHeight);

        /*
        for (int i = dropSprites.size - 1; i >= 0; i--) {
            Sprite dropSprite = dropSprites.get(i);
            float dropWidth = dropSprite.getWidth();
            float dropHeight = dropSprite.getHeight();

            dropSprite.translateY(-100f * delta);
            dropRectangle.set(dropSprite.getX(), dropSprite.getY(), dropWidth, dropHeight);

            if (dropSprite.getY() < -dropHeight) dropSprites.removeIndex(i);
            else if (bucketRectangle.overlaps(dropRectangle)) {
                dropSprites.removeIndex(i);
            }
        }

        dropTimer += delta;
        if (dropTimer > 1f) {
            dropTimer = 0;
            createDroplet();
        }
         */
    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        spriteBatch.setProjectionMatrix((viewport.getCamera().combined));
        spriteBatch.begin();
        // Hard coded map
        chunk.draw(spriteBatch);

        bucketSprite.draw(spriteBatch);
        /*
        for(Sprite dropSprite : dropSprites) {
            dropSprite.draw(spriteBatch);
        }
        */
        spriteBatch.end();
    }

    private void createDroplet() {
        float dropWidth = 50;
        float dropHeight = 50;
        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();

        Sprite dropSprite = new Sprite(dropTexture);
        dropSprite.setSize(dropWidth, dropHeight);
        dropSprite.setX(MathUtils.random(0f, worldWidth - dropWidth));
        dropSprite.setY(worldHeight);
        dropSprites.add(dropSprite);
    }
    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void dispose() {
        // Destroy application's resources here.
        spriteBatch.dispose();
    }
}

//Change//
