package model.tools;

import model.Feedback;
import model.tiles.Tile;

/**
 * This is an interface to use a Tool on a Tile.
 */
public interface Usable {
    default Feedback use(Tile tile){
        return new Feedback();
    }

}