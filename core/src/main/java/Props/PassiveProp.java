package Props;

/**
 * An interface for props/items that the player cannot active use, these provide
 * raw stats.
 */
public interface PassiveProp {
    public int getStatValue();
    public void setStatValue(int statValue);
}
