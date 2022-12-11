package model;

import model.crops.Crop;
import model.levels.Default;
import model.levels.FarmerRanking;
import model.tiles.Tile;

public class Farmer {
    private double exp;
    private int level;
    private FarmerRanking rank;
    private double objectCoins;
    private int days;
    private Crop inventory;
    private Tile activeTile;

    public Farmer() {
        this.activeTile = null;
        this.exp = 0;
        this.level = 0;
        this.rank = new Default();
        this.objectCoins = 100;
        this.days = 1;
    }

    public double getExp() {
        return this.exp;
    }

    public int getLevel() {
        this.level = (int) this.exp / 100;
        return this.level;
    }

    public FarmerRanking getRank() {
        return this.rank;
    }

    public double getObjectCoins() {
        return this.objectCoins;
    }

    public void gainExp(double exp) {
        this.exp += exp;
    }

    public FarmerRanking nextLevel() {
        return this.rank.nextLevel();
    }

    public void setRank(FarmerRanking rank) {
        this.rank = rank;
    }

    public void setObjectCoins(double objectCoins) {
        this.objectCoins = objectCoins;
    }

    public int getDays() {
        return this.days;
    }

    public void advanceDay() {
        this.days++;
    }

    public void setInventory(Crop activeCrop) {
        this.inventory = activeCrop;
    }

    public Crop getInventory(){
        return this.inventory;
    }

    public void setTile(Tile lastClicked) {
        this.activeTile = lastClicked;
    }
    public Tile getActiveTile(){
        return this.activeTile;
    }

    public double getXp() {
        return this.exp;
    }

    public void setXp(double xp) {
        this.exp = xp;
        int lvl = (int) this.exp / 100;
        this.level = lvl;
    }
}
