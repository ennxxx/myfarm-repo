package view;

import model.tiles.*;

import javax.swing.*;
import java.awt.*;

public class TileView extends JPanel {
    private JPanel farmPanel;
    private Icon tileDisplay;

    public TileView() {
        this.farmPanel = new JPanel();
        this.farmPanel.setOpaque(false);
        GridLayout farmLayout = new GridLayout(5, 10,8,8);
        this.farmPanel.setLayout(farmLayout);
        this.farmPanel.setBounds(250, 260, 772, 382);

        // Sets all tiles as unplowed
        this.tileDisplay = new ImageIcon("assets/tiles/unplowed.png");


        //TODO: make tileDisplay dynamic
        for (int i = 0; i < (10*5); i++) {
            this.farmPanel.add(new JButton(tileDisplay));
        }
    }

    // Randomly generated rocks

    public JPanel getTileView() {
        return this.farmPanel;
    }

    public Icon changeTileDisplay(String tileType) {
        return switch(tileType.toLowerCase()){
            case "unplowed" -> new ImageIcon("assets/tiles/unplowed.png");
            case "plowed" -> new ImageIcon("assets/tiles/plowed.png");
            case "watered" -> new ImageIcon("assets/tiles/crop_water");
            case "withered" -> new ImageIcon("assets/tiles/withered.png");
            case "harvestable" -> new ImageIcon("assets/tiles/crop_nwater.png");
            case "rock" -> new ImageIcon("assets/tiles/rock.png");
            default -> new ImageIcon("assets/tiles/unplowed.png");
        };
    }

    public void updateTileView(Tile tile) {
        if(tile instanceof AvailableTile){
            this.tileDisplay = changeTileDisplay("unplowed");
        } if(tile instanceof PlantableTile) {
            this.tileDisplay = changeTileDisplay("plowed");
        } if(tile instanceof HarvestableTile) {
            if(((HarvestableTile)tile).getCrop().isWatered()){
                this.tileDisplay = changeTileDisplay("watered");
            } else {
                this.tileDisplay = changeTileDisplay("harvestable");
            }
        } if(tile instanceof UnavailableTile) {
            String obstruction = ((UnavailableTile) tile).getObstruction();
            if(obstruction.equals("withered plant")){
                this.tileDisplay = changeTileDisplay("withered");
            } else if(obstruction.equals("rock")){
                this.tileDisplay = changeTileDisplay("rock");
            } else if(obstruction.equals("growing tree")){
                this.tileDisplay = changeTileDisplay("unplowed");
            }
        }
    }
}
