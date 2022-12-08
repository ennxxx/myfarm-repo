package model;

import model.tiles.AvailableTile;
import model.tiles.Tile;

import java.util.ArrayList;

public class FarmPlotModel {
    private Tile[][] tiles;
    ArrayList<SeedModel> availableSeeds;
    String farmName;
    int[] rockFormation;

    public FarmPlotModel(String name) {
        tiles = new Tile[5][10];
        availableSeeds = new ArrayList<SeedModel>();
        farmName = name;

        // init all tiles
        for(Tile[] row : tiles)
            for (Tile tile : row)
                tile = new AvailableTile();
    }
}