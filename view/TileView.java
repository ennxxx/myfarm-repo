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

        return this.tileViewIndex;
    }

    public Icon changeTileDisplay(String tileType) {
        return switch (tileType.toLowerCase()) {
            case "unplowed" -> new ImageIcon("assets/tiles/unplowed.png");
            case "plowed" -> new ImageIcon("assets/tiles/plowed.png");
            case "watered" -> new ImageIcon("assets/tiles/crop_water.png");
            case "withered" -> new ImageIcon("assets/tiles/withered.png");
            case "harvestable" -> new ImageIcon("assets/tiles/crop_nwater.png");
            case "rock" -> new ImageIcon("assets/tiles/rock.png");
            case "apple" -> new ImageIcon("assets/crops/apple.png");
            case "carrot" -> new ImageIcon("assets/crops/carrot.png");
            case "mango" -> new ImageIcon("assets/crops/mango.png");
            case "potato" -> new ImageIcon("assets/crops/potato.png");
            case "rose" -> new ImageIcon("assets/crops/rose.png");
            case "sunflower" -> new ImageIcon("assets/crops/sunflower.png");
            case "turnip" -> new ImageIcon("assets/crops/turnip.png");
            case "tulip" -> new ImageIcon("assets/crops/tulip.png");
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
            tileView.setIcon(changeTileDisplay("harvestable"));
            if (((HarvestableTile) tile).getCrop().isWatered()) {
                System.out.println("crop is watered");
                tileView.setIcon(changeTileDisplay("watered"));
            }
            if (((HarvestableTile) tile).getCrop().isReady()) {
                System.out.println("harvestable");
                tileView.setIcon(changeTileDisplay(((HarvestableTile) tile).getCrop().getName().toLowerCase()));
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