package model.levels;

public class Farmer extends FarmerRanking {
    public Farmer(){
        levelTitle = "Farmer";
        levelRequirement = 0;
        bonusEarnings = 0;
        seedDiscount = 0;
        waterBonusInc = 0;
        fertilizerBonusInc = 0;
        registrationFee = 100;
    }

    @Override
    public FarmerRanking nextLevel() {
        return new Registered();
    }
}
