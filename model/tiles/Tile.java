package model.tiles;

public abstract class Tile {
    protected boolean available;
    protected boolean harvestable;
    protected boolean isPlowed;

    protected int x;
    protected int y;

    public void setPlowed(boolean b) {
        isPlowed = b;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int j) {
        x = j;
    }

    public void setY(int i) {
        y = i;
    }
}
