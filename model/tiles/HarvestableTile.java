package model.tiles;

import model.crops.Crop;

// class for tiles with a crop planted on them
public class HarvestableTile extends Tile {
    private Crop crop;

    public HarvestableTile() {
        this.available = false;
        this.harvestable = true;
        this.isPlowed = true;
    }

    public Crop getCrop() {
        return crop;
    }

}