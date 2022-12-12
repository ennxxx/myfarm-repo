package controller;

import model.Feedback;
import model.tiles.*;
import model.tools.*;

/**
 * This is a class that creates tools.
 */
public class ToolFactory implements AbstractFactory<Tool, String> {

    /**
     * Initializes new tools under the Tool class.
     *
     * @param flag name of tool
     * @return child Tool class
     */
    public Tool create (String flag) {
        return switch (flag.toLowerCase()) {
            case "plow" -> new Plow(){
                @Override
                public Feedback use(Tile tile) {
                    Feedback feedback = new Feedback();

                    feedback.setPrompt("Unable to plow on this tile.");
                    feedback.setSuccess(false);

                    if (tile instanceof AvailableTile) {
                        feedback.setPrompt("You have plowed this tile!");
                        feedback.setSuccess(true);
                    }

                    return feedback;
                }
            };
            case "watering can" -> new WateringCan(){
                @Override
                public Feedback use(Tile tile) {
                    Feedback feedback = new Feedback();

                    feedback.setPrompt("Unable to water this tile.");
                    feedback.setSuccess(false);

                    if (tile instanceof HarvestableTile) {
                        feedback.setPrompt("You have watered this tile!");
                        feedback.setSuccess(true);
                    }

                    return feedback;
                }
            };

            case "pickaxe" -> new Pickaxe(){
                @Override
                public Feedback use(Tile tile) {
                    Feedback feedback = new Feedback();

                    feedback.setPrompt("Unable to mine this tile.");
                    feedback.setSuccess(false);

                    if (tile instanceof UnavailableTile && ((UnavailableTile) tile).getObstruction().equals("rock")) {
                        feedback.setPrompt("You have mined this rock!");
                        feedback.setSuccess(true);
                    }

                    return feedback;
                }
            };
            case "fertilizer" -> new Fertilizer(){
                @Override
                public Feedback use(Tile tile) {
                    Feedback feedback = new Feedback();

                    feedback.setPrompt("Unable to fertilize this tile.");
                    feedback.setSuccess(false);

                    if (tile instanceof HarvestableTile) {
                        feedback.setPrompt("You have fertilized this tile!");
                        feedback.setSuccess(true);
                    }

                    return feedback;
                }
            };
            case "shovel" -> new Shovel(){
                @Override
                public Feedback use(Tile tile) {
                    Feedback feedback = new Feedback();

                    feedback.setPrompt("You have dug up this tile!");
                    feedback.setSuccess(true);

                    return feedback;
                }
            };
            default -> null;
        };

    }
}