package model.levels;

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

    public FarmerRanking nextLevel() {
        return null;
    }
}