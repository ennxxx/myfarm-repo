package controller;

import model.Feedback;
import model.tiles.*;
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
            case "watering can" -> {
                if(tile instanceof HarvestableTile) {
                    ((HarvestableTile) tile).getCrop().water();
                    System.out.println("Watered");
                    return tile;
                }
            }
            case "pickaxe" ->{
                return new AvailableTile();
            }
            case "fertilizer" -> {
                if(tile instanceof HarvestableTile) {
                    ((HarvestableTile) tile).getCrop().fertilize();
                    System.out.println("fertilized");
                    return tile;
                }
            }
            case "shovel" -> {
                if((tile instanceof UnavailableTile && ((UnavailableTile) tile).getObstruction().equals("withered plant")) || (tile instanceof HarvestableTile )) {
                    return new AvailableTile();
                }

                return tile;
            }

            default -> {
                return tile;
            }

        }

        return tile;
    }

}