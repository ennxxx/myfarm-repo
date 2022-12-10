package controller;

import model.tiles.Tile;
import view.TileView;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TileController {
    private Tile[][] tiles;
    int height;
    int width;

    private FarmerController farmerController;

    public TileController(Tile[][] tiles, TileView tileView, int height, int width) {
        this.tiles = tiles;
        this.height = height;
        this.width = width;
        this.farmerController = farmerController;
    }


    public void clickListener(TileView tileView) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                tileView.getTileView().getComponent(i * 10 + j).addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JButton button = (JButton) e.getSource();
                        int x = button.getX();
                        int y = button.getY();

                        // get button width and height
                        int btnWidth = button.getWidth();
                        int btnHeight = button.getHeight();

                        x = x / btnWidth;
                        y = y / btnHeight;

                        if(x > (width - 1))
                            x = 9;
                        if(x < 0)
                            x = 0;

                        if(y > height)
                            y = 4;
                        if(y < 0)
                            y = 0;

                        System.out.println("Clicked Tile: ("+ x + ", " + y + ")");
                    }
                });
            }
        }
    }
}
