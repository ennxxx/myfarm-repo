package model;

import model.tiles.AvailableTile;
import model.tiles.Tile;

import java.util.ArrayList;

public class FarmPlot {
    private Tile[][] tiles;
    ArrayList<Crop> availableCrops;
    String farmName;
    int[] rockFormation;

    public FarmPlot(String name) {
        tiles = new Tile[5][10];
        availableCrops = new ArrayList<Crops>();
        farmName = name;

        // init all tiles
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                tiles[i][j] = new AvailableTile();
                tiles[i][j].setX(j);
                tiles[i][j].setY(i);
            }
        }
    }

    public void updateTileModel(Tile tile, int x, int y) {
        tiles[x][y] = tile;
    }
}