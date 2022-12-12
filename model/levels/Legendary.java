package model.levels;

/**
 * This is a child class of FarmerRanking that returns information on a Legendary Farmer.
 */
public class Legendary extends FarmerRanking {
    public Legendary() {
        levelTitle = "Legendary Farmer";
        levelRequirement = 15;
        bonusEarnings = 3;
        seedDiscount = 3;
        waterBonusInc = 2;
        fertilizerBonusInc = 1;
        registrationFee = 400;
    }

    /**
     * Maximum level is reached, does not return a new level.
     *
     * @return null
     */
    public FarmerRanking nextLevel() {
        return null;
    }
}