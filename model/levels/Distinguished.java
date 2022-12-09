package model.levels;

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

    @Override
    public FarmerRanking nextLevel() {
        return new Legendary();
    }


}