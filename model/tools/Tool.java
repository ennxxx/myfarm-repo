package model.tools;

public abstract class Tool implements Usable {
    protected double cost;
    protected double expGain;
    protected String name;

    public double getCost() {
        return this.cost;
    }

    public double getExpGain() {
        return this.expGain;
    }

    public String getName(){
        return this.name;
    }
}
