package controller;

import model.Feedback;
import model.tiles.*;
import model.tools.Tool;
import view.FeedbackView;


public class ToolController {

    FeedbackView feedbackView;

    public ToolController(FeedbackView feedbackView) {
        this.feedbackView = feedbackView;
    }

    ToolFactory tf = new ToolFactory();

    public Tile useTool(String toolName, Tile tile) {
        Tool tool = tf.create(toolName);


        Feedback feedback = tool.use(tile);

        feedbackView.updateFeedback(feedback.getPrompt());


        if (!feedback.isSuccess()) {
            return tile;
        }

        switch (toolName.toLowerCase()) {
            case "plow" -> {
                if(tile instanceof AvailableTile){
                    return new PlantableTile();
                }
            }
            case "watering can" -> {
                if(tile instanceof HarvestableTile) {
                    ((HarvestableTile) tile).getCrop().water();
                    feedbackView.updateFeedback("Watered");
                }
                else{
                    feedbackView.updateFeedback("Unable to water");
                }
                return tile;
            }
            case "pickaxe" ->{
                if(tile instanceof UnavailableTile){
                    if(((UnavailableTile) tile).getObstruction().equals("rock")){
                        return new AvailableTile();
                    }
                }
            }
            case "fertilizer" -> {
                if(tile instanceof HarvestableTile) {
                    ((HarvestableTile) tile).getCrop().fertilize();
                    System.out.println("fertilized");
                }
                else{
                    feedbackView.updateFeedback("Unable to fertilize");
                }
                return tile;
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