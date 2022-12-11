package controller;

import model.Feedback;
import model.tiles.*;
import model.tools.*;

public class ToolFactory implements AbstractFactory<Tool, String> {
    public Tool create (String flag) {
        return switch (flag.toLowerCase()) {
            case "plow" -> new Plow(){
                @Override
                public Feedback use(Tile tile) {
                    Feedback feedback = new Feedback();

                    feedback.setPrompt("Unable to plow");
                    feedback.setSuccess(false);

                    if (tile instanceof AvailableTile) {
                        feedback.setPrompt("Plowed");
                        feedback.setSuccess(true);
                    }

                    return feedback;
                }
            };
            case "watering can" -> new WateringCan(){
                @Override
                public Feedback use(Tile tile) {
                    Feedback feedback = new Feedback();

                    feedback.setPrompt("Unable to water");
                    feedback.setSuccess(false);

                    if (tile instanceof HarvestableTile) {
                        feedback.setPrompt("Watered");
                        feedback.setSuccess(true);
                    }

                    return feedback;
                }
            };

            case "pickaxe" -> new Pickaxe(){
                @Override
                public Feedback use(Tile tile) {
                    Feedback feedback = new Feedback();

                    feedback.setPrompt("Unable to mine");
                    feedback.setSuccess(false);

                    if (tile instanceof UnavailableTile && ((UnavailableTile) tile).getObstruction().equals("rock")) {
                        feedback.setPrompt("Mined");
                        feedback.setSuccess(true);
                    }

                    return feedback;
                }
            };
            case "fertilizer" -> new Fertilizer(){
                @Override
                public Feedback use(Tile tile) {
                    Feedback feedback = new Feedback();

                    feedback.setPrompt("Unable to fertilize");
                    feedback.setSuccess(false);

                    if (tile instanceof HarvestableTile) {
                        feedback.setPrompt("Fertilized");
                        feedback.setSuccess(true);
                    }

                    return feedback;
                }
            };
            case "shovel" -> new Shovel(){
                @Override
                public Feedback use(Tile tile) {
                    Feedback feedback = new Feedback();

                    feedback.setPrompt("Dug Up");
                    feedback.setSuccess(true);

                    return feedback;
                }
            };
            default -> null;
        };

    }
}