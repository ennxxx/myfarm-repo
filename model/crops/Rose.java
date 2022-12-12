package model.crops;

/**
 * This is a child class of Crop that holds information about the Rose flower.
 */
public class Rose extends Crop {
    public Rose() {
        this.name = "Rose";
        this.cost = 5.0;
        this.type = "Flower";
        this.timesWatered = 0;
        this.waterNeeds = 1;
        this.waterBonus = 2;
        this.timesFertilized = 0;
        this.fertilizerNeeds = 0;
        this.fertilizerBonus = 1;
        this.basePrice = 5.0;
        this.expGain = 2.5;
        this.harvestTime = 1;
        this.plantedSince = 0;
        this.harvestYieldMin = 1;
        this.harvestYieldMax = 1;
        this.isReady = false;
        this.isWithered = false;
    }
}
