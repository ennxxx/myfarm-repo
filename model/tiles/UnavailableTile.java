package model.tiles;

/**
 * This is a child class for Tiles that have an obstruction.
 */
public class UnavailableTile extends Tile {
    String obstruction;

    /**
     * Constructor for unavailable tiles.
     *
     * @param obstruction a withered plant, rock, or growing tree
     */
    public UnavailableTile(String obstruction) {
        this.available = false;
        this.harvestable = false;
        this.isPlowed = false;

        // May be obstructed by a withered plant, rock, or growing tree
        // Tile is unavailable until obstruction is removed
        switch (obstruction) {
            case "withered plant" -> this.obstruction = "withered plant";
            case "rock" -> this.obstruction = "rock";
            case "growing tree" -> this.obstruction = "growing tree";
            default -> this.obstruction = "none";
        }
    }

    /**
     * Gets the obstruction on a tile.
     *
     * @return obstruction
     */
    public String getObstruction() {
        return this.obstruction;
    }
}