package model.tiles;

/**
 * This is a child class for plowed Tiles.
 */
public class PlantableTile extends Tile {

    /**
     * Constructor for plowed or plantable tiles.
     */
    public PlantableTile() {
        this.available = true;
        this.harvestable = false;
        this.isPlowed = true;
    }
}
