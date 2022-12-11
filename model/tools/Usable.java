package model.tools;

import model.Feedback;
import model.tiles.Tile;

public interface Usable {
    default Feedback use(Tile tile){
        return new Feedback();
    }

}