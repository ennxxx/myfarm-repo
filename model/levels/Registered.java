package model.levels;

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

    @Override
    public FarmerRanking nextLevel() {
        return new Distinguished();
    }
}