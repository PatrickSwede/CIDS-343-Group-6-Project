package io.github.CIDS_343_Group_6_Project;

import Characters.Character;
import Characters.CharacterMethods;
import Characters.Enemy;
import Characters.Player;
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
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import map.*;

import java.util.ArrayList;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Driver implements ApplicationListener {
    TextureRegion playerTexture;
    TextureRegion firstEnemyTexture;
    Sound dropSound;
    Music music;
    SpriteBatch spriteBatch;

    Vector2 touchPos;


    // For camera and controls
    OrthographicCamera camera;
    int displayHeight;
    int displayWidth;
    Control keyPress;

    // For random map
    int size;
    int numRooms;
    float spread;
    int chunkSize;
    float obstacleDensity;
    int tileSizeX;
    int tileSizeY;
    Map map;
    Player player;
    Movement movement;

    // For characters
    int spawnTilePosX;
    int spawnTilePosY;
    Sprite playerSprite;
    ArrayList<Sprite> enemySprites;
    float characterSizeX;
    float characterSizeY;


    // For enemies
    ArrayList<Enemy> enemies;

    @Override
    public void create() {
        // objects

        playerTexture = Enums.PLAYER.STANDING.getValue();
        firstEnemyTexture = Enums.ENEMIES.FIRST.getValue();
        dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.mp3"));
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        spriteBatch = new SpriteBatch();
        touchPos = new Vector2();


        // Camera and Controls
        displayHeight = 400;
        displayWidth = 400;
        camera = new OrthographicCamera(displayWidth, displayHeight);
        camera.zoom = .4f;
        camera.position.x += Enums.SETTINGS.RESOLUTIONX.getValue() / 2f;
        camera.position.y += Enums.SETTINGS.RESOLUTIONY.getValue() / 2f;
        keyPress = new Control (Enums.SETTINGS.RESOLUTIONX.getValue(), Enums.SETTINGS.RESOLUTIONY.getValue(),camera);
        Gdx.input.setInputProcessor(keyPress);


        // For random map
        size = 9;
        numRooms = 81;
        spread = 0f;
        chunkSize = 9;
        obstacleDensity = 0f;
        tileSizeX = Enums.SETTINGS.RESOLUTIONX.getValue() / (chunkSize * size);
        tileSizeY = Enums.SETTINGS.RESOLUTIONY.getValue() / (chunkSize * size);
        map = MapMethods.initializeLevel(size, numRooms, spread, chunkSize, obstacleDensity);



        // For Characters

        playerSprite = new Sprite(playerTexture);
        characterSizeX = tileSizeX;
        characterSizeY = tileSizeY;
        playerSprite.setSize(characterSizeX, characterSizeY);
        movement = new Movement(map, characterSizeX, characterSizeY);

        // For Enemies
        enemies = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            enemies.add(new Enemy(new Vector2(50,50),firstEnemyTexture,characterSizeX,
                characterSizeY, "first Enemies", 100, 0, 0));
        }



        // Initialize Player
        spawnTilePosX = map.getNumberRows() / 2;
        spawnTilePosY = map.getNumberRows() / 2;
        player = CharacterMethods.initializePlayer(spawnTilePosX, spawnTilePosY, characterSizeX, characterSizeY, playerTexture,
            playerSprite);


        // Initialize Enemies
        enemies = CharacterMethods.initializeEnemies(characterSizeX, characterSizeY, map);
        enemySprites = new ArrayList<Sprite>();

        for (int  i = 0; i < enemies.size(); i++) {
            Sprite enemySprite = new Sprite(enemies.get(i).getTexture());
            enemySprite.translateX(enemies.get(i).getPos().x);
            enemySprite.translateY(enemies.get(i).getPos().y);
            enemySprites.add(enemySprite);

        }
    }



    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        input();
        logic();
        draw();
    }

    private void input() {

        float speed = 50f;
        float delta = Gdx.graphics.getDeltaTime();

        if (keyPress.getUp() && keyPress.getRight()) {
            float y = movement.Move(player,"up", speed * delta);
            float x = movement.Move(player,"right", speed * delta);
            playerSprite.translateY(y);
            playerSprite.translateX(x);
            camera.position.y += (y);
            camera.position.x += (x);
            player.setPos(new Vector2(playerSprite.getX(), playerSprite.getY()));

        } else if (keyPress.getUp() && keyPress.getLeft()) {
            float y = movement.Move(player,"up", speed * delta);
            float x = movement.Move(player,"left", speed * delta);
            playerSprite.translateY(y);
            playerSprite.translateX(x);
            camera.position.y += (y);
            camera.position.x += (x);
            player.setPos(new Vector2(playerSprite.getX(), playerSprite.getY()));

        } else if (keyPress.getUp()) {
            float y = movement.Move(player,"up", speed * delta);
            playerSprite.translateY(y);
            camera.position.y += (y);
            player.setPos(new Vector2(playerSprite.getX(), playerSprite.getY()));

        } else if (keyPress.getDown() && keyPress.getRight()) {
            float y = movement.Move(player,"down", speed * delta);
            float x = movement.Move(player,"right", speed * delta);
            playerSprite.translateY(y);
            playerSprite.translateX(x);
            camera.position.y += (y);
            camera.position.x += (x);
            player.setPos(new Vector2(playerSprite.getX(), playerSprite.getY()));

        } else if (keyPress.getDown() && keyPress.getLeft()) {
            float y = movement.Move(player,"down", speed * delta);
            float x = movement.Move(player,"left", speed * delta);
            playerSprite.translateY(y);
            playerSprite.translateX(x);
            camera.position.y += (y);
            camera.position.x += (x);
            player.setPos(new Vector2(playerSprite.getX(), playerSprite.getY()));

        } else if (keyPress.getDown()) {
            float y = movement.Move(player, "down", speed * delta);
            playerSprite.translateY(y);
            camera.position.y += (y);
            player.setPos(new Vector2(playerSprite.getX(), playerSprite.getY()));

        } else if(keyPress.getRight()) {
            float x = movement.Move(player,"right", speed * delta);
            playerSprite.translateX(x);
            camera.position.x += (x);
            player.setPos(new Vector2(playerSprite.getX(), playerSprite.getY()));

        } else if(keyPress.getLeft()) {
            float x = movement.Move(player,"left", speed * delta);
            playerSprite.translateX(x);
            camera.position.x += (x);
            player.setPos(new Vector2(playerSprite.getX(), playerSprite.getY()));

        }
        if (Gdx.input.isTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            //viewport.unproject(touchPos);
            playerSprite.setCenterX(touchPos.x);
            playerSprite.setCenterY(touchPos.y);
        }
        camera.update();


    }

    private void logic() {

    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        // map
        map.draw(spriteBatch);

        playerSprite.draw(spriteBatch);

        for (int i = 0; i < enemySprites.size(); i++) {
            enemySprites.get(i).draw(spriteBatch);
        }


        spriteBatch.end();
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
