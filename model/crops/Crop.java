package model.crops;

import javax.swing.*;

/**
 * This is the Crop parent class that holds crop information.
 */
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

    /**
     * Gets the cost of a crop.
     *
     * @return cost of crop
     */
    public double getCost() {
        return cost;
    }

    /**
     * Gets the name of a crop.
     *
     * @return name of crop
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the type of crop.
     *
     * @return type of crop
     */
    public String getType(){
        return type;
    }

    /**
     * Gets the number of times a crop has been watered.
     *
     * @return times watered
     */
    public int getTimesWatered() {
        return timesWatered;
    }

    /**
     * Gets the water bonus limit of a crop.
     *
     * @return water bonus
     */
    public int getWaterBonus() {
        return waterBonus;
    }

    /**
     * Gets the number of times a crop has been fertilized.
     *
     * @return times fertilized
     */
    public int getTimesFertilized() {
        return timesFertilized;
    }

    /**
     * Gets the fertilizer bonus limit of a crop.
     *
     * @return fertilizer bonus
     */
    public int getFertilizerBonus() {
        return fertilizerBonus;
    }

    /**
     * Gets experience gained from harvesting a crop.
     *
     * @return experience gain
     */
    public double getExpGain() {
        return expGain;
    }

    /**
     * Gets the yield of a harvest.
     *
     * @return harvest yield
     */
    public int getHarvestYield() {
        int yield = (int) (Math.random() * (harvestYieldMax - harvestYieldMin + 1) + harvestYieldMin);
        return yield;
    }

    /**
     * Gets the base selling price of a crop.
     *
     * @return base price
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Gets a value to determine if a crop is ready for harvest.
     *
     * @return true if ready, false otherwise
     */
    public boolean isReady() {
        return isReady;
    }

    /**
     * Gets a value to determine if a crop has withered.
     *
     * @return true if withered, false otherwise
     */
    public boolean isWithered() {
        return isWithered;
    }

    /**
     * Sets a crop as harvestable.
     */
    public void harvestable() {
        isReady = true;
    }

    /**
     * Sets a crop as withered.
     */
    public void wither() {
        isWithered = true;
    }

    /**
     * Waters a crop.
     */
    public void water() {
        timesWatered++;
    }

    /**
     * Fertilizes a crop.
     */
    public void fertilize() {
        timesFertilized++;
    }

    /**
     * Sets a crop as watered.
     */
    public boolean isWatered() {
        return timesWatered >= waterNeeds;
    }

    /**
     * Grows a crop if it meets the required conditions.
     */
    public void growCrop() {
        plantedSince++;
        if (plantedSince == harvestTime) {
            if (timesWatered < waterNeeds) {
                JOptionPane.showMessageDialog(null, "Oh no! Your crop was not watered enough and has withered.");
                wither();
            }
            if (timesFertilized < fertilizerNeeds) {
                JOptionPane.showMessageDialog(null, "Oh no! Your crop was not fertilized enough and has withered.");
                wither();
            }
            if (timesWatered >= waterNeeds && timesFertilized >= fertilizerNeeds) {
                JOptionPane.showMessageDialog(null, "Nice! You have crops ready for harvest.");
                harvestable();
            }
        }

        if (plantedSince > harvestTime) {
            JOptionPane.showMessageDialog(null, "Oh no! You missed the harvest time of your crop.");
            wither();
        }
    }
}
