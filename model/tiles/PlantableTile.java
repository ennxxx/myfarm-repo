package model.tiles;

// class for plowed tiles
public class PlantableTile extends Tile {

    public PlantableTile() {
        this.available = true;
        this.harvestable = false;
        this.isPlowed = true;
    }
}
