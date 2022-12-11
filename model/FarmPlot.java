package model;

import controller.CropFactory;
import model.crops.Crop;
import model.tiles.AvailableTile;
import model.tiles.Tile;

import java.util.ArrayList;

public class FarmPlot {
    private Tile[][] tiles;
    ArrayList<Crop> availableCrops;
    int height;
    int width;
    int[] rockFormation;

    public FarmPlot() {
        this.height = 5;
        this.width = 10;
        tiles = new Tile[height][width];
        availableCrops = new ArrayList<>();

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

    public void initializeCrops() {
        String[] cropList = {"Turnip", "Carrot", "Potato", "Rose", "Tulips", "Sunflower", "Mango", "Apple"};
        CropFactory cropFactory = new CropFactory();

        for (String crop : cropList) {
            availableCrops.add(cropFactory.create(crop));
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Tile getTile(int y, int x) {
        return tiles[y][x];
    }
}