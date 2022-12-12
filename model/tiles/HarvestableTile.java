package model.tiles;

import model.crops.Crop;

/**
 * This is a child class for Tiles with a crop planted on them.
 */
public class HarvestableTile extends Tile {
    private Crop crop;

    /**
     * Constructor for harvestable tiles.
     *
     * @param crop harvestable crop on tile
     */
    public HarvestableTile(Crop crop) {
        this.available = false;
        this.harvestable = true;
        this.isPlowed = true;
        this.crop = crop;
    }

    /**
     * Get harvestable crop on tile.
     *
     * @return crop
     */
    public Crop getCrop() {
        return crop;
    }

}