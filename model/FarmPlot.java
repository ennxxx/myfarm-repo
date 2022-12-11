package model;

import controller.CropFactory;
import model.crops.Crop;
import model.tiles.AvailableTile;
import model.tiles.Tile;
import model.tiles.UnavailableTile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

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

        // read the tile config file

        Stack<Character> tileStack = new Stack<Character>();

        String tileConfig = "";

        try {
            tileConfig = new String(Files.readAllBytes(Paths.get("tileConfig.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // split by comma
        String[] tileConfigArray = tileConfig.split(",");

        // check if less than 10 rocks are in the array
        for (String tile : tileConfigArray) {
            tileStack.push(tile.charAt(0));
        }

        int rockCounter = 0;
        // init all tiles
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if(!tileStack.empty() && tileStack.pop() == 'r' && rockCounter < 30) {
                    System.out.println("rock");
                    tiles[i][j] = new UnavailableTile("rock");
                    rockCounter++;
                } else {
                    tiles[i][j] = new AvailableTile();
                }
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