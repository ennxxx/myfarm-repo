package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This is a view class that displays the tool buttons.
 */
public class ToolView extends JPanel {
    private JPanel toolPanel;
    private JButton plowBtn, waterBtn, fertilizerBtn, pickaxeBtn, shovelBtn;

    /**
     * Constructor that initializes a tool view.
     */
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

    /**
     * Sets plow button to do an action.
     *
     * @param action action to be done
     */
    public void setPlowBtnAction(ActionListener action) {
        this.plowBtn.addActionListener(action);
    }

    /**
     * Sets waatering can button to do an action.
     *
     * @param action action to be done
     */
    public void setWaterBtnAction(ActionListener action) {
        this.waterBtn.addActionListener(action);
    }

    /**
     * Sets fertilizer button to do an action.
     *
     * @param action action to be done
     */
    public void setFertilizerBtnAction(ActionListener action) {
        this.fertilizerBtn.addActionListener(action);
    }

    /**
     * Sets pickaxe button to do an action.
     *
     * @param action action to be done
     */
    public void setPickaxeBtnAction(ActionListener action) {
        this.pickaxeBtn.addActionListener(action);
    }

    /**
     * Sets shovel button to do an action.
     *
     * @param action action to be done
     */
    public void setShovelBtnAction(ActionListener action) {
        this.shovelBtn.addActionListener(action);
    }

    /**
     * Gets tool view.
     *
     * @return tool panel
     */
    public JPanel getToolView() {
        return this.toolPanel;
    }
}
