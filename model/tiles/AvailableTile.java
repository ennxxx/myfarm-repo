package model.tiles;

/**
 * This is a child class for default and unplowed Tiles.
 */
public class AvailableTile extends Tile {

    /**
     * Constructor for available and unplowed tiles.
     */
    public AvailableTile() {
        this.available = true;
        this.harvestable = false;
        this.isPlowed = false;
    }
}