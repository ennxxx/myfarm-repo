package controller;

import model.FarmPlot;
import model.tiles.AvailableTile;
import model.tiles.HarvestableTile;
import model.tiles.Tile;
import model.tiles.UnavailableTile;
import view.TileView;

import javax.swing.*;

public class FarmPlotController {

    private FarmPlot farmPlot;

    public FarmPlotController() {
        this.farmPlot = new FarmPlot();

    }

    public boolean isFull() {

        // check if farmplot is full
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.farmPlot.getTile(i, j) instanceof AvailableTile || this.farmPlot.getTile(i, j) instanceof HarvestableTile) {
                    return false;
                }
            }
        }

        return false;
    }


    public FarmPlot getFarmPlot() {
        return farmPlot;
    }

    public void updateTile(Tile tile, int x, int y) {
        farmPlot.updateTileModel(tile, x, y);
        // update the view of the same tile
        // farmPlotView.updateTileView(tile, x, y);
    }

    public void advanceDay(TileView tileView, TileController tileController) {
        
        // update the view of the same tile
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

                // update the view of the same tile
                tileView.updateTileView(current, tileView.getTileView()[y][x]);
                tileController.updateTile(x, y, current);
            }
        }
    }

    public boolean isEmpty() {

        // check if farmplot is empty
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.farmPlot.getTile(i, j) instanceof HarvestableTile) {
                    return false;
                }
            }
        }

        return false;
    }
}
