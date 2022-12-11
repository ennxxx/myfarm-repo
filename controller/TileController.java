package controller;

import model.tiles.*;
import view.TileView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class TileController {
    private Tile[][] tiles;
    private Tile clickedTile;

    int height;
    int width;
    private TileView tileView;

    public TileController(Tile[][] tiles, TileView tileView, int height, int width) {
        this.tiles = tiles;
        this.height = height;
        this.width = width;
        this.tileView = tileView;
        this.clickedTile = null;

    }



    public void updateTileViewIndex(){

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 5; y++) {
                this.tileView.updateTileView(
                        this.tiles[y][x],
                        this.tileView.getTileView()[y][x]);
            }
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }


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

    public Tile getClickedTile() {
        return this.clickedTile;
    }

    public void updateTile(int x, int y, Tile newTile){
        this.tiles[y][x] = newTile;
    }

    public String getTileType(Tile tile){
        if(tile instanceof AvailableTile){
            return "Unplowed";
        } if(tile instanceof PlantableTile) {
            return "Plowed";
        } if(tile instanceof HarvestableTile) {
            return "Harvestable";
            //TODO: add crop details
        } if(tile instanceof UnavailableTile) {
            String obstruction = ((UnavailableTile) tile).getObstruction();
            if(obstruction.equals("rock")){
                return "Rock";
            } else {
                return "Withered";
            }
        }
        return "Unplowed";
    }
}
