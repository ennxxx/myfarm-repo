package model.crops;

/**
 * This is a child class of Crop that holds information about the Tunrip crop.
 */
public class Turnip extends Crop {
    public Turnip() {
        this.name = "Turnip";
        this.cost = 5.0;
        this.type = "Root Crop";
        this.timesWatered = 0;
        this.waterNeeds = 1;
        this.waterBonus = 2;
        this.timesFertilized = 0;
        this.fertilizerNeeds = 0;
        this.fertilizerBonus = 1;
        this.basePrice = 6.0;
        this.expGain = 5.0;
        this.harvestTime = 2;
        this.plantedSince = 0;
        this.harvestYieldMin = 1;
        this.harvestYieldMax = 2;
        this.isReady = false;
        this.isWithered = false;
    }
}
