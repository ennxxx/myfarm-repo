package controller;

import model.Farmer;
import model.Feedback;
import model.crops.Crop;
import model.levels.*;
import model.tiles.Tile;
import model.tools.Tool;
//import view.FarmerView;

public class FarmerController {

        Farmer farmer;
        Tool activeTool = null;

    //FarmerView farmerView;

        public void levelUp(){
            FarmerRanking next = this.farmer.getRank().nextLevel();

            if(this.farmer.getLevel() >= next.getLevelRequirement() && farmer.getObjectCoins() >= next.getRegistrationFee()){
                // ask if they want to level up
                // if yes, level up
                this.farmer.setRank(this.farmer.nextLevel());
                // if no, do nothing
            }
        }

        public void setActiveTool(Tool tool){

        }

        public Feedback plantCrop(Crop crop, Tile tile){
            Feedback feedback = new Feedback();

            if(this.farmer.getObjectCoins() >= crop.getCost()){
                this.farmer.setObjectCoins(this.farmer.getObjectCoins() - crop.getCost());
                // TODO: plant the seed
            }

            feedback.setPrompt("Not enough money!");
            return feedback;
        }

        public void useTool(String toolName){
            //TODO: fix this
            ToolFactory tf = new ToolFactory();
            Tool tool = tf.create(toolName);

            if(this.farmer.getObjectCoins() >= tool.getCost()){
                this.farmer.setObjectCoins(this.farmer.getObjectCoins() - tool.getCost());
                this.farmer.gainExp(tool.getExpGain());
            }
        }

        public void harvestCrop(){
            //TODO: Implement harvest crop
        }
}
