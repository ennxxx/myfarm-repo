package model.crops;

public class Potato extends Crop{
    public Potato() {
        this.name = "Potato";
        this.cost = 20.0;
        this.type = "Root Crop";
        this.timesWatered = 0;
        this.waterNeeds = 3;
        this.waterBonus = 4;
        this.timesFertilized = 0;
        this.fertilizerNeeds = 1;
        this.fertilizerBonus = 2;
        this.basePrice = 3.0;
        this.expGain = 12.5;
        this.harvestTime = 5;
        this.plantedSince = 0;
        this.harvestYieldMin = 1;
        this.harvestYieldMax = 10;
        this.isReady = false;
        this.isWithered = false;
    }
}
