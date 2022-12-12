package model.tiles;

/**
 * This is a parent class that gets coordinates and boolean conditions of a tile.
 */
public abstract class Tile {
    protected boolean available;
    protected boolean harvestable;
    protected boolean isPlowed;

    protected int x;
    protected int y;

    /**
     * Sets a tile as plowed.
     *
     * @param true if plowed, false otherwise.
     */
    public void setPlowed(boolean b) {
        isPlowed = b;
    }

    /**
     * Gets the x coordinate of a tile.
     *
     * @return x
     */
    public int getX() { return x; }

    /**
     * Gets the y coordinate of a tile.
     *
     * @return y
     */
    public int getY() { return y; }

    /**
     * Set x coordinate of a tile.
     *
     * @param j x coordinate
     */
    public void setX(int j) {
        x = j;
    }

    /**
     * Set y coordinate of a tile.
     *
     * @param i y coordinate
     */
    public void setY(int i) {
        y = i;
    }

}
