package controller;

import model.FarmerModel;
import model.levels.*;
//import view.FarmerView;


public class FarmerController {

        FarmerModel farmerModel;
        //FarmerView farmerView;

        public void levelUp(){
            FarmerRanking next = farmerModel.getRank().nextLevel();

            if(farmerModel.getLevel() >= next.getLevelRequirement() && farmerModel.getObjectCoins() >= next.getRegistrationFee()){
                // ask if they want to level up
                // if yes, level up
                farmerModel.setRank(farmerModel.nextLevel());
                // if no, do nothing
            }
        }
}
