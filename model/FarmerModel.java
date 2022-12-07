package model;

import model.levels.*;

public class FarmerModel {
    private String name;
    private double exp;
    private int level;
    private FarmerRanking rank;
    private double objectCoins;

    public FarmerModel(String name) {
        this.name = name;
        this.exp = 0;
        this.level = 0;
        this.rank = new Farmer();
        this.objectCoins = 100;
    }

    public String getName() {
        return this.name;
    }

    public double getExp() {
        return this.exp;
    }

    public int getLevel() {
        return this.level;
    }

    public FarmerRanking getRank() {
        return this.rank;
    }

    public double getObjectCoins() {
        return this.objectCoins;
    }

    public void setExp(double exp) {
        this.exp = exp;
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
