package io.github.CIDS_343_Group_6_Project;

import Characters.CharacterMethods;
import Characters.Enemy;
import Characters.Player;
import Props.Prop;
import Props.Weapon;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import map.*;

import java.util.ArrayList;
import java.util.Random;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Driver implements ApplicationListener {
    // Textures and Sprites
    TextureRegion playerTexture;
    TextureRegion firstEnemyTexture;
    SpriteBatch spriteBatch;

    // For camera and controls
    OrthographicCamera camera;
    int displayHeight;
    int displayWidth;
    Control keyPress;
    Vector2 touchPos;

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
    boolean attacking;

    // For enemies
    ArrayList<Enemy> enemies;

    // For items
    Weapon starterSword;
    Rectangle equippedWeapon;
    // For combat logic
    HitDetector hitDetector;
    long startTime;
    long elapsedTime;
    long elapsedSeconds;
    long elapsedMinutes;
    Random ranDir;
    String[] enemyDir;

    @Override
    public void create() {
        // objects
        playerTexture = Enums.PLAYER.STANDING.getValue();
        firstEnemyTexture = Enums.ENEMIES.FIRST.getValue();
        spriteBatch = new SpriteBatch();

        // Camera and Controls
        displayHeight = 400;
        displayWidth = 400;
        camera = new OrthographicCamera(displayWidth, displayHeight);
        camera.zoom = .4f;
        camera.position.x += Enums.SETTINGS.RESOLUTIONX.getValue() / 2f;
        camera.position.y += Enums.SETTINGS.RESOLUTIONY.getValue() / 2f;
        keyPress = new Control (Enums.SETTINGS.RESOLUTIONX.getValue(), Enums.SETTINGS.RESOLUTIONY.getValue(),camera);
        touchPos = new Vector2();
        Gdx.input.setInputProcessor(keyPress);

        // For random map
        size = 9;
        numRooms = 81;
        spread = 0f;
        chunkSize = 9;
        obstacleDensity = 0.05f;
        tileSizeX = Enums.SETTINGS.RESOLUTIONX.getValue() / (chunkSize * size);
        tileSizeY = Enums.SETTINGS.RESOLUTIONY.getValue() / (chunkSize * size);
        map = MapMethods.initializeLevel(size, numRooms, spread, chunkSize, obstacleDensity);

        // For Characters
        playerSprite = new Sprite(playerTexture);
        characterSizeX = tileSizeX;
        characterSizeY = tileSizeY;
        playerSprite.setSize(characterSizeX, characterSizeY);
        movement = new Movement(map, characterSizeX, characterSizeY);
        boolean attacking = false;

        // For Enemies
        enemies = new ArrayList<>();

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

        // For items
        starterSword = new Weapon(player.getPos(), Enums.WEAPONS.STARTER.getValue(), 8, 8, true,
            "Starter Sword", 10);
        player.addToInventory(starterSword);
        // For combat logic
        hitDetector = new HitDetector();
        startTime = System.currentTimeMillis();
        ranDir = new Random();
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
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            attacking = true;
        }
        /*
        if (Gdx.input.isTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            //viewport.unproject(touchPos);
            playerSprite.setCenterX(touchPos.x);
            playerSprite.setCenterY(touchPos.y);
        }

         */
        camera.update();


    }

    private void logic() {
        // Update timers
        elapsedTime = System.currentTimeMillis() - startTime;
        elapsedSeconds = elapsedTime / 1000;
        elapsedMinutes = elapsedSeconds / 60;
        int dir;
        float speed = 50f;
        float delta = Gdx.graphics.getDeltaTime();

        // Simple combat
        if (attacking) {
            player.getInventoryItem(0).setHitboxRect(new Vector2(player.getPos().x + (characterSizeX), player.getPos().y + (characterSizeY - 7)));
            player.getInventoryItem(0).setPos(new Vector2(player.getPos().x + (characterSizeX), player.getPos().y + (characterSizeY - 7)));
            equippedWeapon =  player.getInventoryItem(0).getHitboxRect();
            for (int i = 0; i < enemies.size(); i++) {
                Rectangle enemyRect = enemies.get(i).getCollisionHitbox();
                System.out.println(equippedWeapon.overlaps(enemyRect));
                System.out.println(equippedWeapon.toString());
                if (equippedWeapon.overlaps(enemyRect)) {
                    enemies.get(i).setCharacterHealth(enemies.get(i).getCharacterHealth() - 10);
                    System.out.println(enemies.get(i).getCharacterHealth());
                    if (enemies.get(i).checkIfDead()) {
                        enemies.remove(enemies.get(i));
                        enemySprites.remove(enemySprites.get(i));
                    }
                }
            }
        }

        // Enemy Movement
        for (int i = 0; i< enemies.size(); i++) {
            dir = ranDir.nextInt(4);
            if (dir == 0) {
                float y = movement.Move(enemies.get(i), "up", speed * delta);
                enemies.get(i).setPos(new Vector2 (enemies.get(i).getPos().x, enemies.get(i).getPos().y + y));
                enemySprites.get(i).translateY(y);
            } else if (dir == 1) {
                float y = movement.Move(enemies.get(i), "down", speed * delta);
                enemies.get(i).setPos(new Vector2 (enemies.get(i).getPos().x, enemies.get(i).getPos().y + y));
                enemySprites.get(i).translateY(y);
            } else if(dir == 2) {
                float x = movement.Move(enemies.get(i), "right", speed * delta);
                enemies.get(i).setPos(new Vector2 (enemies.get(i).getPos().x + x, enemies.get(i).getPos().y));
                enemySprites.get(i).translateX(x);
            } else {
                float x = movement.Move(enemies.get(i), "left", speed * delta);
                enemies.get(i).setPos(new Vector2 (enemies.get(i).getPos().x + x, enemies.get(i).getPos().y));
                enemySprites.get(i).translateX(x);
            }
        }

        // Check if all enemies are dead
        if (enemies.isEmpty()) {
            map = MapMethods.initializeLevel(size, numRooms, spread, chunkSize, obstacleDensity);
            player.setPos(new Vector2(spawnTilePosX * characterSizeX, spawnTilePosY * characterSizeY));
            camera.position.x = spawnTilePosX * characterSizeX;
            camera.position.y = spawnTilePosY * characterSizeY;
            playerSprite.setPosition(spawnTilePosX * characterSizeX, spawnTilePosY * characterSizeY);
            enemies = CharacterMethods.initializeEnemies(characterSizeX, characterSizeY, map);
            // Draw the new enemies
            for (int  i = 0; i < enemies.size(); i++) {
                Sprite enemySprite = new Sprite(enemies.get(i).getTexture());
                enemySprite.translateX(enemies.get(i).getPos().x);
                enemySprite.translateY(enemies.get(i).getPos().y);
                enemySprites.add(enemySprite);
            }
        }
    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        // All Sprites drawn here
        map.draw(spriteBatch);
        playerSprite.draw(spriteBatch);
        for (int i = 0; i < enemySprites.size(); i++) {
            enemySprites.get(i).draw(spriteBatch);
        }
        if (attacking) {
            player.getInventoryItem(0).draw(spriteBatch);
            attacking = false;
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
