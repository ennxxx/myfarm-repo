package controller;

import model.FarmPlot;
import model.tiles.AvailableTile;
import model.tiles.HarvestableTile;
import model.tiles.Tile;
import model.tiles.UnavailableTile;
import view.TileView;

/**
 * This is a class to initialize actions done on the farm plot.
 */
public class FarmPlotController {

    private FarmPlot farmPlot;

    /**
     * Initializes a new farm plot.
     */
    public FarmPlotController() {
        this.farmPlot = new FarmPlot();
    }

    /**
     * Checks if a farm plot is full.
     *
     * @return true if full, false otherwise
     */
    public boolean isFull() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.farmPlot.getTile(i, j) instanceof AvailableTile || this.farmPlot.getTile(i, j) instanceof HarvestableTile) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Advances the day and updates the tile view.
     *
     * @param tileView tile display
     * @param tileController tile actions
     */
    public void advanceDay(TileView tileView, TileController tileController) {

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 5; y++) {
                Tile current = tileController.getTiles()[y][x];
                if(current instanceof HarvestableTile) {
                    ((HarvestableTile) current).getCrop().growCrop();
                    if(((HarvestableTile) current).getCrop().isWithered()){
                        current = new UnavailableTile("withered plant");
                    }
                }
                current.setY(y);
                current.setX(x);

                tileView.updateTileView(current, tileView.getTileView()[y][x]);
                tileController.updateTile(x, y, current);
            }
        }
    }

    /**
     * Checks if a farm plot is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.farmPlot.getTile(i, j) instanceof HarvestableTile) {
                    return false;
                }
            }
        }

        return true;
    }
}
