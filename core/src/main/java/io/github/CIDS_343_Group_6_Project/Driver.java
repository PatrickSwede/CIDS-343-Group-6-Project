package io.github.CIDS_343_Group_6_Project;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.Array;

public class Driver implements ApplicationListener {
    private SpriteBatch spriteBatch;
    private OrthographicCamera camera;
    private FitViewport viewport;

    private Texture bucketTexture;
    private Sprite bucketSprite;
    private Vector2 touchPos;
    private Array<Sprite> dropSprites;
    private Rectangle bucketRectangle;
    private Rectangle dropRectangle;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(8, 5, camera); // World units
        spriteBatch = new SpriteBatch();

        bucketTexture = new Texture("bucket.png");
        bucketSprite = new Sprite(bucketTexture);
        bucketSprite.setSize(1, 1); // 1x1 world unit

        touchPos = new Vector2();
        dropSprites = new Array<>();
        bucketRectangle = new Rectangle();
        dropRectangle = new Rectangle();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        input();
        logic();
        draw();
    }

    private void input() {
// Your original input handling here (e.g., touch to move bucket)
    }

    private void logic() {
// Your original game logic here (e.g., spawn and move raindrops)
    }

    private void draw() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);

        spriteBatch.begin();
        bucketSprite.draw(spriteBatch);
// draw raindrops, etc. here
        spriteBatch.end();
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {
        spriteBatch.dispose();
        bucketTexture.dispose();
// Dispose any other textures if needed
    }
}
