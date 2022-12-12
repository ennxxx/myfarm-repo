package controller;

import model.tiles.*;
import view.TileView;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This is a class to initialize actions done on a tile.
 */
public class TileController {
    private Tile[][] tiles;
    private Tile clickedTile;

    int height;
    int width;
    private TileView tileView;

    /**
     * Constructor that initializes default tile values.
     *
     * @param tiles farm plot
     * @param tileView display of a tile
     * @param height tile's height
     * @param width tile's width
     */
    public TileController(Tile[][] tiles, TileView tileView, int height, int width) {
        this.tiles = tiles;
        this.height = height;
        this.width = width;
        this.tileView = tileView;
        this.clickedTile = null;
        updateTileViewIndex();
    }

    /**
     * Updates a tile view
     */
    public void updateTileViewIndex(){

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 5; y++) {
                this.tileView.updateTileView(
                        this.tiles[y][x],
                        this.tileView.getTileView()[y][x]);
            }
        }
    }

    /**
     * Gets the farm plot.
     *
     * @return tiles
     */
    public Tile[][] getTiles() {
        return tiles;
    }

    /**
     * Updates how the farm plot looks.
     */
    public void updateFarmPanel(){

        this.tileView.getFarmPanel().removeAll();
        for(int y = 0; y < 5; y++) {
            for(int x = 0; x < 10; x++) {

                JButton newTileBtn = this.tileView.getTileView()[y][x];

                this.tileView.getFarmPanel().add(this.tileView.getTileView()[y][x]);
            }
        }

        this.tileView.getFarmPanel().revalidate();
        this.tileView.getFarmPanel().repaint();
    }

    /**
     * Locates what tile is clicked.
     */
    public void clickListener() {

        for(int y = 0; y < 5; y++) {
            for(int x = 0; x < 10; x++) {
                int finalY = y;
                int finalX = x;
                this.tileView.getTileView()[y][x].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        clickedTile = tiles[finalY][finalX];
                    }
                });
            }
        }
    }

    /**
     * Gets clicked tile.
     *
     * @return clicked tile
     */
    public Tile getClickedTile() {
        return this.clickedTile;
    }

    /**
     * Updates clicked tile according to actions done.
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @param newTile updated tile
     */
    public void updateTile(int x, int y, Tile newTile){
        this.tiles[y][x] = newTile;
    }

    /**
     * Gets the display of a tile.
     *
     * @param tile clicked tile
     * @return display of new tile
     */
    public String getTileType(Tile tile){
        if (tile instanceof AvailableTile){
            return "Unplowed";
        } if (tile instanceof PlantableTile) {
            return "Plowed";
        } if (tile instanceof HarvestableTile) {
            return "Harvestable";
        } if (tile instanceof UnavailableTile) {
            String obstruction = ((UnavailableTile) tile).getObstruction();
            if (obstruction.equals("rock")){
                return "Rock";
            } else {
                return "Withered";
            }
        }
        return "Unplowed";
    }
}
