package model.tools;

/**
 * A parent class that holds Tool information.
 */
public abstract class Tool implements Usable {
    protected double cost;
    protected double expGain;
    protected String name;

    /**
     * Get cost to use a tool.
     *
     * @return cost
     */
    public double getCost() {
        return this.cost;
    }

    /**
     * Get experience gained after using a tool.
     *
     * @return experience gain
     */
    public double getExpGain() {
        return this.expGain;
    }

    /**
     * Get name of a tool.
     *
     * @return name
     */
    public String getName(){
        return this.name;
    }
}
