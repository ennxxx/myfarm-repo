package model.levels;

/**
 * This is a child class of FarmerRanking that returns information on a Distinguished Farmer.
 */
public class Distinguished extends FarmerRanking {
    public Distinguished() {
        levelTitle = "Distinguished Farmer";
        levelRequirement = 10;
        bonusEarnings = 2;
        seedDiscount = 2;
        waterBonusInc = 1;
        fertilizerBonusInc = 0;
        registrationFee = 300;
    }

    /**
     * Levels up the farmer.
     *
     * @return farmer ranking
     */
    @Override
    public FarmerRanking nextLevel() {
        return new Legendary();
    }


}