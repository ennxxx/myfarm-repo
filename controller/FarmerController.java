package controller;

import model.Farmer;
import model.Feedback;
import model.crops.Crop;
import model.levels.*;
import model.tiles.Tile;
import model.tools.Tool;
import view.FarmerView;

public class FarmerController {

    Farmer farmer;
    Tool activeTool = null;
    Crop activeCrop = null;
    int currentLevel;

    public FarmerController() {
        this.farmer = new Farmer();
        this.currentLevel = farmer.getLevel();
    }

    public void levelUp() {
        //TODO: implement level up feedback
        this.currentLevel = farmer.getLevel();
        FarmerRanking next = this.farmer.getRank().nextLevel();

        if (this.farmer.getLevel() >= next.getLevelRequirement() && farmer.getObjectCoins() >= next.getRegistrationFee()) {
            // ask if they want to level up
            // if yes, level up
            this.farmer.setRank(this.farmer.nextLevel());
            // if no, do nothing
        }
    }

    public Feedback setActiveTool(String toolName) {
        Feedback feedback = new Feedback();
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

    public Tool getActiveTool() {
        return this.activeTool;
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
