package model.tiles;

// class for tile with obstruction
public class UnavailableTile extends Tile {
    String obstruction;

    // may be obstructed by a withered plant, rock, or growing tree
    // tile is unavailable until obstruction is removed
    public UnavailableTile(String obstruction) {
        this.available = false;
        this.harvestable = false;
        this.isPlowed = false;

        switch (obstruction) {
            case "withered plant" -> this.obstruction = "withered plant";
            case "rock" -> this.obstruction = "rock";
            case "growing tree" -> this.obstruction = "growing tree";
            default -> this.obstruction = "none";
        }
    }

    public String getObstruction() {
        return this.obstruction;
    }
}