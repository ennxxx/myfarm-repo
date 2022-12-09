package model.crops;

public class Sunflower extends Crop{
    public Sunflower() {
        this.name = "Sunflower";
        this.cost = 20.0;
        this.type = "Flower";
        this.timesWatered = 0;
        this.waterNeeds = 2;
        this.waterBonus = 3;
        this.timesFertilized = 0;
        this.fertilizerNeeds = 1;
        this.fertilizerBonus = 2;
        this.basePrice = 19.0;
        this.expGain = 7.5;
        this.harvestTime = 3;
        this.plantedSince = 0;
        this.harvestYieldMin = 1;
        this.harvestYieldMax = 1;
        this.isReady = false;
        this.isWithered = false;
    }
}
