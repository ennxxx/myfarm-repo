package model.crops;

/**
 * This is a child class of Crop that holds information about the Apple fruit tree.
 */
public class Apple extends Crop {
    public Apple() {
        this.name = "Apple";
        this.cost = 200.0;
        this.type = "Fruit Tree";
        this.timesWatered = 0;
        this.waterNeeds = 7;
        this.waterBonus = 7;
        this.timesFertilized = 0;
        this.fertilizerNeeds = 5;
        this.fertilizerBonus = 5;
        this.basePrice = 5.0;
        this.expGain = 25.0;
        this.harvestTime = 10;
        this.plantedSince = 0;
        this.harvestYieldMin = 10;
        this.harvestYieldMax = 15;
        this.isReady = false;
        this.isWithered = false;
    }
}
