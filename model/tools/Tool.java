package model.tools;

public abstract class Tool implements Usable {
    protected double cost;
    protected double expGain;

    public double getCost() {
        return cost;
    }

    public double getExpGain() {
        return expGain;
    }
}
