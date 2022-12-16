package model.levels;

/**
 * This is the FarmerRanking parent class that holds information about a Farmer's rank and benefits.
 */
public abstract class FarmerRanking {
    protected String levelTitle;
    protected int levelRequirement;

    protected int bonusEarnings;
    protected int seedDiscount;
    protected int waterBonusInc;
    protected int fertilizerBonusInc;

    protected double registrationFee;

    /**
     * This is an abstract class that levels up a farmer when they meet certain conditions.
     *
     * @return farmer ranking
     */
    public abstract FarmerRanking nextLevel();

    /**
     * Gets the bonus earnings of a farmer.
     *
     * @return bonus earnings
     */
    public int getBonusEarnings() {
        return bonusEarnings;
    }

    /**
     * Gets level requirements.
     *
     * @return level requirement
     */
    public int getLevelRequirement() {
        return levelRequirement;
    }

    /**
     * Gets registration fee to level up.
     *
     * @return registration fee
     */
    public double getRegistrationFee() {
        return registrationFee;
    }

    /**
     * Gets seed discount given a farmer's rank.
     *
     * @return seed discount
     */
    public int getSeedDiscount(){
        return seedDiscount;
    }

    /**
     * Gets water bonus increase given a farmer's rank.
     *
     * @return water bonus
     */
    public int getWaterBonusInc(){
        return waterBonusInc;
    }

    /**
     * Gets fertilizer bonus increase given a farmer's rank.
     *
     * @return fertilizer bonus
     */
    public int getFertilizerBonusInc(){
        return fertilizerBonusInc;
    }

    /**
     * Gets a farmer's level title.
     *
     * @return level tile
     */
    public String getLevelTitle() { return levelTitle; }
}
