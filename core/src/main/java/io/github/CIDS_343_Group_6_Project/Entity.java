package io.github.CIDS_343_Group_6_Project;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * An abstract class to represent the fundamentals of an entity which most elements of the game will consist of
 * @author Patrick Swedenborg
 */
public abstract class Entity {
    private Vector2 pos;
    private Texture texture;
    private float width;
    private float height;

    /**
     * A basic constructor which will be superimposed on following child classes
     * @param pos a vector representing position both x and y
     * @param texture the texture of the entity
     * @param width the width represented as a float
     * @param height the height represented as a float
     */
    public Entity(Vector2 pos, Texture texture, float width, float height) {
        this.pos = pos;
        this.texture = texture;
        this.width = width;
        this.height = height;
    }

    /**
     * A basic draw method to put the instance on the screen
     * @param batch the instance being visualized on the screen
     */
    public void draw(SpriteBatch batch) {
        batch.draw(texture, pos.x, pos.y, width, height);
    }

    /**
     * Getter for pos attribute
     * @return pos
     */
    public Vector2 getPos() {
        return pos;
    }

    /**
     * Getter for texture attribute
     * @return texture
     */
    public Texture getTexture() {
        return texture;
    }

    /**
     * Getter for width attribute
     * @return width
     */
    public float getWidth() {
        return width;
    }

    /**
     * Getter for height attribute
     * @return height
     */
    public float getHeight() {
        return height;
    }

    /**
     * Setter for pos attribute
     * @param pos a vector representing the new position
     */
    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    /**
     * Setter for texture attribute
     * @param texture the new texture for the entity
     */
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    /**
     * Setter for width attribute
     * @param width the new width represented as a float
     */
    public void setWidth(float width) {
        this.width = width;
    }

    /**
     * Setter for height attribute
     * @param height the new height represented as a float
     */
    public void setHeight(float height) {
        this.height = height;
    }
}
