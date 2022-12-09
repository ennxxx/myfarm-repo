package model.tiles;

// class for unplowed tiles (default tiles)
public class AvailableTile extends Tile {

    public AvailableTile() {
        this.available = true;
        this.harvestable = false;
        this.isPlowed = false;
    }
}