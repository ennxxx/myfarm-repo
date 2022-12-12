package model;

import model.crops.Crop;
import model.levels.Default;
import model.levels.FarmerRanking;
import model.tiles.Tile;

/**
 * This is a class that represents the farmer in the game.
 */
public class Farmer {
    private double exp;
    private int level;
    private FarmerRanking rank;
    private double objectCoins;
    private int days;
    private Crop inventory;
    private Tile activeTile;

    /**
     * Constructor that initializes the farmer with default values.
     */
    public Farmer() {
        this.activeTile = null;
        this.exp = 0;
        this.level = 0;
        this.rank = new Default();
        this.objectCoins = 100;
        this.days = 1;
    }

    /**
     * Gets the experience points of a farmer.
     *
     * @return experience
     */
    public double getExp() {
        return this.exp;
    }

    /**
     * Gets the level of a farmer.
     *
     * @return level
     */
    public int getLevel() {
        this.level = (int) this.exp / 100;
        return this.level;
    }

    /**
     * Gets the rank of a farmer.
     *
     * @return rank
     */
    public FarmerRanking getRank() {
        return this.rank;
    }

    /**
     * Gets the Objectcoins of a farmer.
     *
     * @return Objectcoins
     */
    public double getObjectCoins() {
        return this.objectCoins;
    }

    /**
     * Increases experience points of a farmer.
     */
    public void gainExp(double exp) {
        this.exp += exp;
    }

    /**
     * Increases level of a farmer.
     *
     * @return farmer ranking
     */
    public FarmerRanking nextLevel() {
        return this.rank.nextLevel();
    }

    /**
     * Sets the rank of a farmer.
     *
     * @param rank farmer ranking
     */
    public void setRank(FarmerRanking rank) {
        this.rank = rank;
    }

    /**
     * Sets the Objectcoins of a farmer.
     *
     * @param objectCoins Objectcoins
     */
    public void setObjectCoins(double objectCoins) {
        this.objectCoins = objectCoins;
    }

    /**
     * Gets the number of days passed.
     *
     * @return days
     */
    public int getDays() {
        return this.days;
    }

    /**
     * Advances the days in game.
     */
    public void advanceDay() {
        this.days++;
    }

    /**
     * Sets the inventory that holds a crop.
     *
     * @param activeCrop Recently bought crop
     */
    public void setInventory(Crop activeCrop) {
        this.inventory = activeCrop;
    }

    /**
     * Gets the inventory that holds a crop.
     *
     * @return crop
     */
    public Crop getInventory(){
        return this.inventory;
    }

    /**
     * Sets the last clicked tile.
     *
     * @param lastClicked last clicked tile
     */
    public void setTile(Tile lastClicked) {
        this.activeTile = lastClicked;
    }

    /**
     * Gets the last clicked tile.
     *
     * @return active tile
     */
    public Tile getActiveTile(){
        return this.activeTile;
    }

    /**
     * Gets the experience of a farmer.
     *
     * @return experience
     */
    public double getXp() {
        return this.exp;
    }

    /**
     * Sets the experience of a farmer.
     *
     * @param xp experience points
     */
    public void setXp(double xp) {
        this.exp = xp;
        int lvl = (int) this.exp / 100;
        this.level = lvl;
    }
}
