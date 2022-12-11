package model.tiles;

import model.crops.Crop;

// class for tiles with a crop planted on them
public class HarvestableTile extends Tile {
    private Crop crop;

    public HarvestableTile(Crop crop) {
        this.available = false;
        this.harvestable = true;
        this.isPlowed = true;
        this.crop = crop;
    }

    public Crop getCrop() {
        return crop;
    }

}