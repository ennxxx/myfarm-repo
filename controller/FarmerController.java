package controller;

import model.Farmer;
import model.Feedback;
import model.crops.Crop;
import model.levels.*;
import model.tiles.Tile;
import model.tools.Tool;
import view.FarmerView;
import view.TileView;

import javax.swing.*;

public class FarmerController {

    private Farmer farmer;

    private JButton activeTileView;
    private Tool activeTool = null;
    private Crop activeCrop = null;

    private FarmerView farmerView;

    public FarmerController(FarmerView farmerView) {
        this.farmer = new Farmer();
        this.farmerView = farmerView;
        this.activeTileView = null;
    }

    public JButton getActiveTileView(){
        return this.activeTileView;
    }

    public void setActiveTileView(JButton newBtn){
        this.activeTileView = newBtn;
    }

    public void levelUp() {
        //TODO: implement level up feedback
        int currentLevel = farmer.getLevel();
        FarmerRanking next = this.farmer.getRank().nextLevel();


        // ask the farmer if they want to level up
        int choice = JOptionPane.showConfirmDialog(null, "Would you like to level up?");
        if(choice == JOptionPane.YES_OPTION) {
            // check if farmer has enough coins
            if (farmer.getObjectCoins() >= next.getRegistrationFee()) {
                // check if farmer has enough exp
                if (farmer.getLevel() >= next.getLevelRequirement()) {
                    // level up
                    farmer.setObjectCoins(farmer.getObjectCoins() - next.getRegistrationFee());
                    farmer.setRank(next);
                    updateFarmerView();
                    JOptionPane.showMessageDialog(null, "You have leveled up!");
                } else {
                    JOptionPane.showMessageDialog(null, "You do not have enough exp to level up!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "You do not have enough coins to level up!");
            }
        }
    }

    public Feedback setActiveTool(String toolName) {

        Feedback feedback = new Feedback();
        if(toolName == null){
            activeTool = null;
            feedback.setPrompt("You're not holding a tool");
            feedback.setSuccess(true);
            return feedback;
        }

        ToolFactory tf = new ToolFactory();
        Tool tool = tf.create(toolName);

        //TODO: implement equipped tool better, don't remove money unless a tile is clicked
        if (this.farmer.getObjectCoins() >= tool.getCost()) {
            feedback.setSuccess(true);
            feedback.setPrompt("You are currently using the " + toolName + "!");
            this.activeTool = tool;
            return feedback;
        }

        feedback.setPrompt("Not enough money to use " + toolName + "!");
        return feedback;
    }

    public Feedback setActiveCrop(String cropName){
        Feedback feedback = new Feedback();
        CropFactory cf = new CropFactory();
        Crop crop = cf.create(cropName);

        if (this.farmer.getObjectCoins() >= crop.getCost()) {
            feedback.setSuccess(true);
            feedback.setPrompt("Seed to be planted: " + cropName);
            this.activeCrop = crop;
            return feedback;
        }

        feedback.setPrompt("Not enough money to buy " + cropName + "!");
        return feedback;
    }

        public Feedback useActiveTool(Tile tile){
            Feedback feedback = new Feedback();

            if(this.activeTool != null){
                if(this.farmer.getObjectCoins() >= this.activeTool.getCost()){
                    this.farmer.setObjectCoins(this.farmer.getObjectCoins() - this.activeTool.getCost());
                    this.farmer.gainExp(this.activeTool.getExpGain());
                    feedback.setSuccess(true);
                    feedback.setPrompt("You used the " + this.activeTool.getName() + "!");
                    this.activeTool.use(tile);
                    return feedback;
                }
                return feedback;
            }

            return feedback;
        }

    public Feedback plantCrop(Crop crop, Tile tile) {
        Feedback feedback = new Feedback();

        if (this.farmer.getObjectCoins() >= crop.getCost()) {
            this.farmer.setObjectCoins(this.farmer.getObjectCoins() - crop.getCost());
            //TODO: plant the seed
        }

        feedback.setPrompt("Not enough money!");
        return feedback;
    }

    public void updateFarmerView(){
        farmerView.updateFarmerView(farmer);
    }

    public Tool getActiveTool() {
        return this.activeTool;
    }

    public Farmer getFarmer() {
        return this.farmer;
    }


//        public void useTool(){
//            //TODO: use the active tool on the tile
//
//            }
//        }
//
//        public void harvestCrop(){
//            //TODO: Implement harvest crop
//        }

}
