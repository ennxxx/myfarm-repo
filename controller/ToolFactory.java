package controller;

import model.Feedback;
import model.tiles.*;
import model.tools.*;

import java.util.Objects;

public class ToolFactory implements AbstractFactory<Tool, String> {
    public Tool create (String flag) {
        return switch (flag.toLowerCase()) {
            case "plow" -> new Plow(){
                @Override
                public Feedback use(Tile tile) {
                    Feedback feedback = new Feedback();

                    if (tile instanceof AvailableTile) {
                        feedback.setPrompt("Plowed");
                        feedback.setSuccess(true);
                    }

                    return feedback;
                }
            };
            case "wateringcan" -> new WateringCan(){
                @Override
                public Feedback use(Tile tile) {
                    Feedback feedback = new Feedback();

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

                    if (tile instanceof UnavailableTile && Objects.equals(((UnavailableTile) tile).getObstruction(), "withered plant")) {
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

                    if (tile instanceof AvailableTile) {
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

                    if ((tile instanceof UnavailableTile && Objects.equals(((UnavailableTile) tile).getObstruction(), "rock")) || (tile instanceof AvailableTile) || (tile instanceof HarvestableTile) || (tile instanceof UnavailableTile && Objects.equals(((UnavailableTile) tile).getObstruction(), "withered plant"))) {
                        feedback.setPrompt("Dug Up");
                        feedback.setSuccess(true);
                    }

                    return feedback;
                }
            };
            default -> null;
        };

    }
}