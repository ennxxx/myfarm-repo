package model.levels;

public abstract class FarmerRanking {
    protected String levelTitle;
    protected int levelRequirement;

    protected int bonusEarnings;
    protected int seedDiscount;
    protected int waterBonusInc;
    protected int fertilizerBonusInc;

    protected double registrationFee;

    public abstract FarmerRanking nextLevel();

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public double getRegistrationFee() {
        return registrationFee;
    }

    public String getLevelTitle() {
        return levelTitle;
    }
}
