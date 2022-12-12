package controller;

import model.Farmer;
import model.Feedback;
import model.crops.Crop;
import model.levels.*;
import model.tiles.Tile;
import model.tools.Tool;
import view.FarmerView;

import javax.swing.*;

/**
 * This is a class to initialize farmer actions.
 */
public class FarmerController {

    private Farmer farmer;

    private JButton activeTileView;
    private Tool activeTool = null;
    private Crop activeCrop = null;

    private FarmerView farmerView;

    /**
     * Constructor to initialize a new farmer.
     *
     * @param farmerView farmer information
     */
    public FarmerController(FarmerView farmerView) {
        this.farmer = new Farmer();
        this.farmerView = farmerView;
        this.activeTileView = null;
    }

    /**
     * Gets the active tile clicked.
     *
     * @return active tile
     */
    public JButton getActiveTileView(){
        return this.activeTileView;
    }

    /**
     * Sets the active tile as a new button.
     *
     * @param newBtn new button
     */
    public void setActiveTileView(JButton newBtn){
        this.activeTileView = newBtn;
    }

    /**
     * Levels up a farmer.
     */
    public void levelUp() {

        int currentLevel = farmer.getLevel();
        FarmerRanking next = this.farmer.getRank().nextLevel();

        // Ask the farmer if they want to level up
        int choice = JOptionPane.showConfirmDialog(null, "Would you like to level up?");
        if (choice == JOptionPane.YES_OPTION) {
            // Check if farmer has enough coins
            if (farmer.getObjectCoins() >= next.getRegistrationFee()) {
                // Check if farmer has enough experience
                if (farmer.getLevel() >= next.getLevelRequirement()) {
                    // Levels up the farmer and shows a message
                    farmer.setObjectCoins(farmer.getObjectCoins() - next.getRegistrationFee());
                    farmer.setRank(next);
                    updateFarmerView();
                    JOptionPane.showMessageDialog(null, "You have leveled up!");
                } else {
                    JOptionPane.showMessageDialog(null, "You do not have enough experience to level up!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "You do not have enough Objectcoins to level up!");
            }
        }
    }

    /**
     * Sets active tool held.
     *
     * @param toolName equipped tool
     * @return feedback on what is equipped
     */
    public Feedback setActiveTool(String toolName) {

        Feedback feedback = new Feedback();
        if (toolName == null) {
            activeTool = null;
            feedback.setPrompt("You're not holding a tool");
            feedback.setSuccess(true);
            return feedback;
        }

        ToolFactory tf = new ToolFactory();
        Tool tool = tf.create(toolName);

        if (this.farmer.getObjectCoins() >= tool.getCost()) {
            feedback.setSuccess(true);
            feedback.setPrompt("You are currently using the " + toolName + "!");
            this.activeTool = tool;
            return feedback;
        }

        feedback.setPrompt("Not enough money to use " + toolName + "!");
        return feedback;
    }

    /**
     * Update farmer view accordingly.
     */
    public void updateFarmerView(){
        farmerView.updateFarmerView(farmer);
    }

    /**
     * Gets the active tool.
     *
     * @return equipped tool
     */
    public Tool getActiveTool() {
        return this.activeTool;
    }

    /**
     * Gets the farmer.
     *
     * @return farmer
     */
    public Farmer getFarmer() {
        return this.farmer;
    }
}
