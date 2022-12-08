package model.levels;

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

    @Override
    public FarmerRanking nextLevel() {
        return new Registered();
    }
}
