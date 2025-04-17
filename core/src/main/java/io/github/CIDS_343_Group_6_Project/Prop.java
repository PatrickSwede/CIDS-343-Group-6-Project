package io.github.CIDS_343_Group_6_Project;
public abstract class Prop {
    protected String name;
    protected boolean isInteractive;
    protected boolean isDestroyed;
    protected int x, y; // position
    protected String description;

    public Prop(String name, boolean isInteractive, int x, int y, String description) {
        this.name = name;
        this.isInteractive = isInteractive;
        this.isDestroyed = false;
        this.x = x;
        this.y = y;
        this.description = description;
    }

    public abstract void interact();

    public int getX() { return x; }
    public int getY() { return y; }
    public String getDescription() { return description; }
}
