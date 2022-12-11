package model.crops;

import javax.swing.*;

public abstract class Crop {
    protected String name;
    protected double cost;
    protected String type;

    protected int timesWatered;
    protected int waterNeeds;
    protected int waterBonus;

    protected int timesFertilized;
    protected int fertilizerNeeds;
    protected int fertilizerBonus;

    protected double basePrice;
    protected double expGain;

    protected int harvestTime;
    protected int plantedSince;
    protected int harvestYieldMin;
    protected int harvestYieldMax;

    protected boolean isReady;
    protected boolean isWithered;

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getType(){
        return type;
    }

    public int getTimesWatered() {
        return timesWatered;
    }

    public int getWaterNeeds() {
        return waterNeeds;
    }

    public int getWaterBonus() {
        return waterBonus;
    }

    public int getTimesFertilized() {
        return timesFertilized;
    }

    public int getFertilizerNeeds() {
        return fertilizerNeeds;
    }

    public int getFertilizerBonus() {
        return fertilizerBonus;
    }

    public double getExpGain() {
        return expGain;
    }

    public int getHarvestTime() {
        return harvestTime;
    }

    public int getHarvestYield() {
        int yield = (int) (Math.random() * (harvestYieldMax - harvestYieldMin + 1) + harvestYieldMin);
        return yield;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int plantedWhen() {
        return plantedSince;
    }

    public boolean isReady() {
        return isReady;
    }

    public boolean isWithered() {
        return isWithered;
    }

    public void harvestable() {
        isReady = true;
    }

    public void wither() {
        isWithered = true;
    }

    public void water() {
        timesWatered++;
    }

    public void fertilize() {
        timesFertilized++;
    }

    public boolean isWatered() {
        return timesWatered >= waterNeeds;
    }

    public void growCrop() {
        plantedSince++;
        if(plantedSince == harvestTime) {
            if(timesWatered < waterNeeds) {
                System.out.println("not watered enough");
                JOptionPane.showMessageDialog(null, "Your crop was not watered enough and has withered.");
                wither();
            }
            if(timesFertilized < fertilizerNeeds) {
                System.out.println("not fertilized enough");
                JOptionPane.showMessageDialog(null, "Your crop was not fertilized enough!");
                wither();
            }
            else {
                System.out.println("crop is ready");
                harvestable();
            }
        }

        if(plantedSince > harvestTime) {
            wither();
        }
    }
}
