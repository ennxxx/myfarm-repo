package controller;

import model.Feedback;
import model.tiles.*;
import model.tools.Tool;
import view.FeedbackView;

/**
 * This is a class to initialize tool actions.
 */
public class ToolController {

    FeedbackView feedbackView;
    ToolFactory tf = new ToolFactory();

    /**
     * Constructor that initializes new tools.
     *
     * @param feedbackView feedback on what is equipped
     */
    public ToolController(FeedbackView feedbackView) {
        this.feedbackView = feedbackView;
    }

    /**
     * Uses a tool on a tile.
     *
     * @param toolName equipped tool
     * @param tile active tile
     * @return feedback on action
     */
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
                    feedbackView.updateFeedback("You have watered this tile.");
                }
                else{
                    feedbackView.updateFeedback("Unable to water this tile.");
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
                }
                else{
                    feedbackView.updateFeedback("Unable to fertilize this tile.");
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