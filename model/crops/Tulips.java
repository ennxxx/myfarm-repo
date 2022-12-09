package model.crops;

public class Tulips extends Crop{
    public Tulips() {
        this.name = "Tulips";
        this.cost = 10.0;
        this.type = "Flower";
        this.timesWatered = 0;
        this.waterNeeds = 2;
        this.waterBonus = 3;
        this.timesFertilized = 0;
        this.fertilizerNeeds = 0;
        this.fertilizerBonus = 1;
        this.basePrice = 9.0;
        this.expGain = 5.0;
        this.harvestTime = 2;
        this.plantedSince = 0;
        this.harvestYieldMin = 1;
        this.harvestYieldMax = 1;
        this.isReady = false;
        this.isWithered = false;
    }
}
