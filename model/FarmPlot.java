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

/**
 * This is a class that represents the farm plot in the game.
 */
public class FarmPlot {
    private Tile[][] tiles;
    ArrayList<Crop> availableCrops;
    int height;
    int width;
    int[] rockFormation;

    /**
     * Constructor that initializes a farm plot.
     */
    public FarmPlot() {
        this.height = 5;
        this.width = 10;
        tiles = new Tile[height][width];
        availableCrops = new ArrayList<>();

        // Read the tile config file
        Stack<Character> tileStack = new Stack<Character>();
        String tileConfig = "";
        try {
            tileConfig = new String(Files.readAllBytes(Paths.get("tileConfig.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Split by commas
        String[] tileConfigArray = tileConfig.split(",");

        // Check if less than 10 rocks are in the array
        for (String tile : tileConfigArray) {
            tileStack.push(tile.charAt(0));
        }

        int rockCounter = 0;

        // Initialize all tiles
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if (!tileStack.empty() && tileStack.pop() == 'r' && rockCounter < 30) {
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

    /**
     * Gets the tiles in a farm plot.
     *
     * @return tiles
     */
    public Tile[][] getTiles() {
        return tiles;
    }

    /**
     * Gets the height of a farm plot
     *
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the width of a farm plot
     *
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets a specific tile in a farm plot.
     *
     * @param y y-coordinate
     * @param x x-coordinate
     * @return tiles[x][y]
     */
    public Tile getTile(int y, int x) {
        return tiles[y][x];
    }
}