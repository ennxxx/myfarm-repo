import model.*;
import model.crops.*;
import model.tiles.*;
import model.tools.*;
import view.*;
import controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class initializes all actions done in the program.
 *
 * @version 2.0
 */
public class MainController {
    private MainView mainView;
    private StoreView storeFrame;
    private ToolView toolView;
    private FarmerView farmerView;
    private FeedbackView feedbackView;
    private TileView tileView;
    private TileController tileController;
    private FarmPlotController farmPlotController;
    private FarmerController farmerController;
    private ToolController toolController;
    private StoreController storeController;

    private Feedback display;
    private FarmPlot farmPlot;
    private Tile lastClicked;

    /**
     * Constructor that instantiates all models, views, and controllers.
     *
     * @param mainView main frame
     * @param storeView store frame
     */
    public MainController(MainView mainView, StoreView storeView) {
        // Instantiate main frames
        this.mainView = mainView;
        this.storeFrame = storeView;

        // Instantiate model
        this.farmPlot = new FarmPlot();

        // Instantiate views
        this.toolView = mainView.getToolView();
        this.feedbackView = mainView.getFeedbackView();
        this.farmerView = mainView.getFarmerView();
        this.tileView = mainView.getTileView();

        // Instantiate controllers
        this.farmerController = new FarmerController(this.farmerView);
        this.toolController = new ToolController(this.feedbackView);
        this.farmPlotController = new FarmPlotController();
        this.storeController = new StoreController(storeFrame, farmerController, feedbackView);
        this.tileController = new TileController(farmPlot.getTiles(), tileView, farmPlot.getHeight(), farmPlot.getWidth());
        this.tileController.clickListener();

        this.lastClicked = null;

        // Exits the game
        this.mainView.setExitBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Sets the active tool when a tool button is clicked
        this.toolView.setPlowBtnAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    display = farmerController.setActiveTool("Plow");
                    // Use the tool on the farmer's tile
                    useToolWrapper();
            }
        });

        // Performs action of a watering can
        this.toolView.setWaterBtnAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                display = farmerController.setActiveTool("Watering Can");

                if (!(lastClicked instanceof HarvestableTile)) {
                    display.setPrompt("You can only water plants!");
                    feedbackView.updateFeedback(display.getPrompt());
                    return;
                }

                // Get the crop's water level
                int waterLevel = ((HarvestableTile) lastClicked).getCrop().getTimesWatered();
                int waterBonus = ((HarvestableTile) lastClicked).getCrop().getWaterBonus();

                // Get the farmer rank's water level
                int farmerRank = farmerController.getFarmer().getRank().getWaterBonusInc();

                if (waterLevel > (waterBonus + farmerRank)) {
                    display.setPrompt("You have already watered this crop to its maximum!");
                } else {
                    // Use the tool on the farmer's tile
                    useToolWrapper();
                }
            }
        });

        // Performs action of the fertilizer
        this.toolView.setFertilizerBtnAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                display = farmerController.setActiveTool("Fertilizer");

                if(!(lastClicked instanceof HarvestableTile)) {
                    display.setPrompt("You can only use fertilizer on a crop!");
                    feedbackView.updateFeedback(display.getPrompt());
                    return;
                }
//
                int fertilizerLevel = ((HarvestableTile) lastClicked).getCrop().getTimesFertilized();
                int fertilizerBonus = ((HarvestableTile) lastClicked).getCrop().getFertilizerBonus();

                int farmerRank = farmerController.getFarmer().getRank().getFertilizerBonusInc();

                if(fertilizerLevel > (fertilizerBonus + farmerRank)) {
                    display.setPrompt("You have already fertilized this crop to its maximum!");
                } else {
                    useToolWrapper();
                }
            }
        });

        // Performs action of a pickaxe
        this.toolView.setPickaxeBtnAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                display = farmerController.setActiveTool("Pickaxe");
                // use the tool on the farmer's tile
                useToolWrapper();
            }
        });

        // Performs action of a shovel
        this.toolView.setShovelBtnAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                display = farmerController.setActiveTool("Shovel");
                // use the tool on the farmer's tile
                useToolWrapper();

            }
        });

        // Levels up the player
        this.mainView.setLvlBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                farmerController.levelUp();
            }
        });

        // Plants a crop on a tile
        this.mainView.setPlantCropBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Get crop from farmer
                Crop inventory = farmerController.getFarmer().getInventory();
                // Get current tile
                Tile currentTile = farmerController.getFarmer().getActiveTile();

                Feedback plantingFeedBack = new Feedback();
                if (currentTile instanceof PlantableTile){

                    plantingFeedBack = plantOnTile(inventory, currentTile);
                    farmerController.getFarmer().setInventory(null);

                    plantingFeedBack.setPrompt("Successfully planted the crop!");
                }
                else {
                    plantingFeedBack.setPrompt("You cannot plant on this tile.");
                }
                feedbackView.updateFeedback(plantingFeedBack.getPrompt());
            }
        });

        // Opens the seed store
        this.mainView.setStoreBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == mainView.getStoreBtn()) {
                    storeFrame.getStoreView().setVisible(true);
                }
            }
        });

        // Goes to the next day
        this.mainView.setSleepBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = nextDay();
                feedbackView.updateFeedback(display.getPrompt());
                if (!display.isSuccess()){
                    JOptionPane.showMessageDialog(null, display.getPrompt());
                    System.exit(0);
                }
            }
        });

        // Harvests a crop
        this.mainView.setHarvestBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                harvestCrop(farmerController.getFarmer().getActiveTile(), farmerController.getActiveTileView());
                farmerController.updateFarmerView();
            }
        });

        // Gets the location of a tile
        this.tileView.setTileBtnAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lastClicked = tileController.getClickedTile();
                farmerController.getFarmer().setTile(lastClicked);
                JButton clickedBtn = (JButton) e.getSource();
                farmerController.setActiveTileView(clickedBtn);
                Feedback move = new Feedback();
                move.setSuccess(true);
                move.setPrompt(
                        "You moved to tile: " +
                                farmerController.getFarmer().getActiveTile().getX() +
                                ", " +
                                farmerController.getFarmer().getActiveTile().getY()
                );

                feedbackView.updateFeedback(move.getPrompt());
            }
        });
    }

    /**
     * Harvest a crop
     *
     * @param activeTile current tile
     * @param activeTileView tile display
     */
    private void harvestCrop(Tile activeTile, JButton activeTileView) {

        // Guard clause for harvesting
        if (activeTile instanceof HarvestableTile){
            if (!((HarvestableTile) activeTile).getCrop().isReady()){
                feedbackView.updateFeedback("Crop is not ready to be harvested.");
                return;
            }
        }

        // Harvest the crop on the farmer's currentTile
        if(activeTile instanceof HarvestableTile) {

            // Get the crop from the tile
            Crop harvestedCrop = ((HarvestableTile) activeTile).getCrop();

            int yield = harvestedCrop.getHarvestYield();
            double pricePerPiece = harvestedCrop.getBasePrice() + farmerController.getFarmer().getRank().getBonusEarnings();
            double wateringCount = harvestedCrop.getTimesWatered() - 1;
            double harvestTotal = yield * pricePerPiece;
            double waterBonus = harvestTotal * 0.2 * (wateringCount);
            double fertilizerBonus = harvestTotal * 0.5 * (double)harvestedCrop.getTimesFertilized();
            double finalHarvestPrice = harvestTotal + waterBonus + fertilizerBonus;

            if(harvestedCrop.getType().equalsIgnoreCase("Flower")){
                finalHarvestPrice = finalHarvestPrice * 1.1;
            }

            farmerController.getFarmer().setObjectCoins(
                    farmerController.getFarmer().getObjectCoins() +
                    finalHarvestPrice);
            farmerController.getFarmer().setExp(
                    farmerController.getFarmer().getExp() +
                    harvestedCrop.getExpGain());

            // Replace active tile with a new available tile
            AvailableTile farmerTile = new AvailableTile();
            farmerTile.setY(activeTile.getY());
            farmerTile.setX(activeTile.getX());

            // Update tile and view
            tileView.updateTileView(farmerTile, activeTileView);
            tileController.updateTile(farmerTile.getX(), farmerTile.getY(), farmerTile);
            tileController.updateTileViewIndex();
            tileController.updateFarmPanel();

            Feedback harvestFeedback = new Feedback();
            harvestFeedback.setPrompt("" +
                    "You harvested a crop of " + yield + " " + harvestedCrop.getName() + " for " + finalHarvestPrice + " coins!");
            feedbackView.updateFeedback(harvestFeedback.getPrompt());
        }
    }

    /**
     * Plants a crop on a tile.
     *
     * @param inventory holds the seed
     * @param lastClicked last clicked tile
     * @return
     */
    private Feedback plantOnTile(Crop inventory, Tile lastClicked) {

        Feedback feedback = new Feedback();
        if (!(lastClicked instanceof PlantableTile)) {
            feedback.setSuccess(true);
            feedback.setPrompt("This tile is not plantable.");

            return feedback;
        }

        Tile newTile = new HarvestableTile(inventory);

        newTile.setY(lastClicked.getY());
        newTile.setX(lastClicked.getX());

        this.tileController.updateTile(lastClicked.getX(), lastClicked.getY(), newTile);
        this.tileController.updateTileViewIndex();
        this.tileController.updateFarmPanel();
        feedback.setSuccess(true);
        feedback.setPrompt("Successfully planted: " + inventory.getName());

        return feedback;
    }

    /**
     * Equips a tool.
     */
    public void useToolWrapper(){
        Tool currentTool = farmerController.getActiveTool();
        // Check if farmer can afford the tool
        if(farmerController.getFarmer().getObjectCoins() < currentTool.getCost()){
            display.setPrompt("You cannot afford this tool.");
            display.setSuccess(false);
            feedbackView.updateFeedback(display.getPrompt());
            return;
        }

        Tile currentTile = farmerController.getFarmer().getActiveTile();

        // Plow the tile
        useToolOnTile(currentTool.getName(), currentTile);
        tileView.updateTileView(currentTile, farmerController.getActiveTileView());

        tileController.updateTileViewIndex();
        tileController.updateFarmPanel();

        // Gives farmer experience
        farmerController.getFarmer().setExp(farmerController.getFarmer().getExp() + currentTool.getExpGain());
        farmerController.getFarmer().setObjectCoins(farmerController.getFarmer().getObjectCoins() - currentTool.getCost());

        farmerController.updateFarmerView();
    }

    /**
     * Advances the day and updates display accordingly.
     *
     * @return feedback of the next day
     */
    public Feedback nextDay() {
        Feedback feedback = new Feedback();
        farmerController.getFarmer().advanceDay();
        farmerView.updateFarmerView(farmerController.getFarmer());
        farmPlotController.advanceDay(
                tileView, tileController
        );

        feedback.setPrompt("You have slept through the night.");
        feedback.setSuccess(true);

        // Checks if the farm is full
        boolean fullFarm = farmPlotController.isFull();

        // Checks if farmer cannot buy the cheapest seed
        double cheapestSeedPrice = storeController.getCheapestPrice();
        boolean cannotAffordSeed = farmerController.getFarmer().getObjectCoins() < cheapestSeedPrice;
        boolean cannotAffordShovel = farmerController.getFarmer().getObjectCoins() < 7;
        boolean emptyFarm = farmPlotController.isEmpty();

        if (fullFarm && cannotAffordShovel) {
            feedback.setPrompt("You have run out of space and cannot afford a shovel. Game Over.");
            feedback.setSuccess(false);
        }
        else if (emptyFarm && cannotAffordSeed) {
            feedback.setPrompt("You have run out of seeds and cannot afford a seed. Game Over.");
            feedback.setSuccess(false);
        }

        return feedback;
    }

    /**
     * Uses tool on a tile.
     *
     * @param toolName equipped tool
     * @param tile tile to work on
     */
    public void useToolOnTile(String toolName, Tile tile) {
            Tile newTile = this.toolController.useTool(toolName, tile);
            newTile.setX(
                    tile.getX()
            );
            newTile.setY(
                    tile.getY()
            );
            this.tileController.updateTile(tile.getX(), tile.getY(), newTile);
            this.tileController.updateTileViewIndex();
            this.tileController.updateFarmPanel();

            tile = newTile;
    }

    /**
     * Prints tile status.
     *
     * @param tile tile to work on
     * @return feedback on tile
     */
    public Feedback printTileStatus(Tile tile){
        Feedback feedback = new Feedback();
        feedback.setPrompt("Tile Details: " + tileController.getTileType(tile));
        feedback.setSuccess(true);
        return feedback;
    }

}