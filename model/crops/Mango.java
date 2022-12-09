package model.crops;

public class Mango extends Crop{
    public Mango() {
        this.name = "Mango";
        this.cost = 100.0;
        this.type = "Fruit Tree";
        this.timesWatered = 0;
        this.waterNeeds = 7;
        this.waterBonus = 7;
        this.timesFertilized = 0;
        this.fertilizerNeeds = 4;
        this.fertilizerBonus = 4;
        this.basePrice = 8.0;
        this.expGain = 25.0;
        this.harvestTime = 10;
        this.plantedSince = 0;
        this.harvestYieldMin = 5;
        this.harvestYieldMax = 15;
        this.isReady = false;
        this.isWithered = false;
    }
}
