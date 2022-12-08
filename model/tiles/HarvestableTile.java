package model.tiles;

import model.CropModel;

// class for tiles with a crop planted on them
public class HarvestableTile extends Tile {
    private CropModel crop;

    public HarvestableTile() {
        this.available = false;
        this.harvestable = true;
        this.isPlowed = true;
    }
}