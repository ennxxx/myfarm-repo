package view;

import model.tiles.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TileView extends JPanel {
    private Icon tileDisplay;

    private JPanel farmPanel;
    private JButton[][] tileViewIndex;

    public TileView() {

        this.farmPanel = new JPanel();
        this.farmPanel.setOpaque(false);
        GridLayout farmLayout = new GridLayout(5, 10,8,8);
        this.farmPanel.setLayout(farmLayout);
        this.farmPanel.setBounds(250, 260, 772, 382);

        int height = 5;
        int width = 10;

        this.tileViewIndex = new JButton[5][10];
        // Sets all tiles as unplowed
        this.tileDisplay = new ImageIcon("assets/tiles/unplowed.png");

        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 10; x++) {
                JButton newTileBtn = new JButton(this.tileDisplay);
                this.farmPanel.add(newTileBtn);
                this.tileViewIndex[y][x] = newTileBtn;
            }
        }
    }

    public void setTileBtnAction(ActionListener action){
        for (Component c : this.farmPanel.getComponents()) {
            ((JButton) c).addActionListener(action);
        }
    }

    // Randomly generated rocks

    public JButton[][] getTileView() {
        System.out.println("height: " + this.tileViewIndex.length);
        System.out.println("width: " + this.tileViewIndex[0].length);
        return this.tileViewIndex;
    }

    public Icon changeTileDisplay(String tileType) {
        return switch (tileType.toLowerCase()) {
            case "unplowed" -> new ImageIcon("assets/tiles/unplowed.png");
            case "plowed" -> new ImageIcon("assets/tiles/plowed.png");
            case "watered" -> new ImageIcon("assets/tiles/crop_water");
            case "withered" -> new ImageIcon("assets/tiles/withered.png");
            case "harvestable" -> new ImageIcon("assets/tiles/crop_nwater.png");
            case "rock" -> new ImageIcon("assets/tiles/rock.png");
            default -> new ImageIcon("assets/tiles/unplowed.png");
        };
    }

    public void updateTileView(Tile tile, JButton tileView) {
        if (tile instanceof AvailableTile) {
            tileView.setIcon(changeTileDisplay("unplowed"));
        }
        if (tile instanceof PlantableTile) {
            tileView.setIcon(changeTileDisplay("plowed"));
        }
        if (tile instanceof HarvestableTile) {
            if (((HarvestableTile) tile).getCrop().isWatered()) {
                tileView.setIcon(changeTileDisplay("watered"));
            } else {
                tileView.setIcon(changeTileDisplay("harvestable"));
            }
        }
        if (tile instanceof UnavailableTile) {
            String obstruction = ((UnavailableTile) tile).getObstruction();
            switch (obstruction) {
                case "withered plant" -> tileView.setIcon(changeTileDisplay("withered"));
                case "rock" -> tileView.setIcon(changeTileDisplay("rock"));
                case "growing tree" -> tileView.setIcon(changeTileDisplay("tree"));
            }
        }

        tileView.revalidate();
        tileView.repaint();
    }

    public JPanel getFarmPanel() {
        return this.farmPanel;
    }
}

    // set btn action for each button til