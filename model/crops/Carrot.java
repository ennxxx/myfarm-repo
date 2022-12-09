package model.crops;

public class Carrot extends Crop {
    public Carrot() {
        this.name = "Carrot";
        this.cost = 10.0;
        this.type = "Root Crop";
        this.timesWatered = 0;
        this.waterNeeds = 1;
        this.waterBonus = 2;
        this.timesFertilized = 0;
        this.fertilizerNeeds = 0;
        this.fertilizerBonus = 1;
        this.basePrice = 9.0;
        this.expGain = 7.5;
        this.harvestTime = 3;
        this.plantedSince = 0;
        this.harvestYieldMin = 1;
        this.harvestYieldMax = 2;
        this.isReady = false;
        this.isWithered = false;
    }
}
