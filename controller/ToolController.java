package controller;

import model.Feedback;
import model.tiles.AvailableTile;
import model.tiles.HarvestableTile;
import model.tiles.PlantableTile;
import model.tiles.Tile;
import model.tools.Tool;

public class ToolController {

    ToolFactory tf = new ToolFactory();

    public Tile useTool(String toolName, Tile tile) {
        Tool tool = tf.create(toolName);

        Feedback feedback = tool.use(tile);

        if (!feedback.isSuccess()) {
            return tile;
        }

        switch (toolName.toLowerCase()) {
            case "plow" -> {
                return new PlantableTile();
            }
            case "wateringcan" -> {
                if(tile instanceof HarvestableTile) {
                    ((HarvestableTile) tile).getCrop().water();
                    return tile;
                }
            }
            case "pickaxe", "shovel" -> {
                return new AvailableTile();
            }
            case "fertilizer" -> {
                if(tile instanceof HarvestableTile) {
                    ((HarvestableTile) tile).getCrop().fertilize();
                    return tile;
                }
            }

            default -> {
                return tile;
            }

        }

        return tile;
    }

}