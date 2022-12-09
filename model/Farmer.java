package model;

import model.levels.*;

public class Farmer {
    private double exp;
    private int level;
    private FarmerRanking rank;
    private double objectCoins;

    public Farmer() {
        this.exp = 0;
        this.level = 0;
        this.rank = new Default();
        this.objectCoins = 100;
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
}
