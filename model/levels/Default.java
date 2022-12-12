package model.levels;

/**
 * This is a child class of FarmerRanking that returns information on a Default Farmer.
 */
public class Default extends FarmerRanking {
    public Default(){
        levelTitle = "Farmer";
        levelRequirement = 0;
        bonusEarnings = 0;
        seedDiscount = 0;
        waterBonusInc = 0;
        fertilizerBonusInc = 0;
        registrationFee = 0;
    }

    /**
     * Levels up the farmer.
     *
     * @return farmer ranking
     */
    @Override
    public FarmerRanking nextLevel() {
        return new Registered();
    }
}
