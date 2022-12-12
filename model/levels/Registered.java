package model.levels;

/**
 * This is a child class of FarmerRanking that returns information on a Registered Farmer.
 */
public class Registered extends FarmerRanking {
    public Registered(){
        levelTitle = "Registered";
        levelRequirement = 5;
        bonusEarnings = 1;
        seedDiscount = 1;
        waterBonusInc = 0;
        fertilizerBonusInc = 0;
        registrationFee = 200;
    }

    /**
     * Levels up the farmer.
     *
     * @return farmer ranking
     */
    @Override
    public FarmerRanking nextLevel() {
        return new Distinguished();
    }
}