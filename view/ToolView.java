package view;

import javax.swing.*;
import java.awt.*;

public class ToolView extends JPanel {
    private JPanel toolPanel;
    private JButton plowBtn, waterBtn, fertilizerBtn, pickaxeBtn, shovelBtn;

    public ToolView() {
        this.toolPanel = new JPanel();
        this.toolPanel.setOpaque(false);
        GridLayout toolLayout = new GridLayout(1, 1,10,0);
        this.toolPanel.setLayout(toolLayout);
        this.toolPanel.setBounds(420, 670, 440, 85);

        Icon plow = new ImageIcon("assets/equipment/plow.png");
        Icon water = new ImageIcon("assets/equipment/water.png");
        Icon fertilizer = new ImageIcon("assets/equipment/fertilizer.png");
        Icon pickaxe = new ImageIcon("assets/equipment/pickaxe.png");
        Icon shovel = new ImageIcon("assets/equipment/shovel.png");

        this.plowBtn = new JButton(plow);
        this.waterBtn = new JButton(water);
        this.fertilizerBtn = new JButton(fertilizer);
        this.pickaxeBtn = new JButton(pickaxe);
        this.shovelBtn = new JButton(shovel);

        this.toolPanel.add(plowBtn);
        this.toolPanel.add(waterBtn);
        this.toolPanel.add(fertilizerBtn);
        this.toolPanel.add(pickaxeBtn);
        this.toolPanel.add(shovelBtn);
    }

    // If plow button pressed, do action

    // If water button pressed, do action

    // If fertilizer button pressed, do action

    // If pickaxe button pressed, do action

    // If shovel button pressed, do action

    public JPanel getToolView() {
        return this.toolPanel;
    }
}
