package controller;

import model.FarmPlot;
import model.tiles.Tile;
import view.TileView;

public class FarmPlotController {

    private FarmPlot farmPlot;
    private TileView farmPlotView;

    public FarmPlotController() {
        this.farmPlot = new FarmPlot();

    }


    public FarmPlot getFarmPlot() {
        return farmPlot;
    }

    public void updateTile(Tile tile, int x, int y) {
        farmPlot.updateTileModel(tile, x, y);
        // update the view of the same tile
        // farmPlotView.updateTileView(tile, x, y);
    }

}
