import controller.*;
import model.FarmPlot;
import model.Feedback;
import model.crops.Crop;
import model.tiles.AvailableTile;
import model.tiles.HarvestableTile;
import model.tiles.PlantableTile;
import model.tiles.Tile;
import model.tools.Tool;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private MainFrame mainFrame;
    private StoreFrame storeFrame;
    private ToolView toolView;
    private FarmerView farmerView;
    private FeedbackView feedbackView;
    private TileView tileView;
    private TileController tileController;
    private FarmPlotController farmPlotController;
    private FarmerController farmerController;
    private ToolController toolController;
    private StoreController storeController;

    private boolean exitedWindow = false;
    private Feedback display;
    private FarmPlot farmPlot;
    private Tile lastClicked;
    private Tile lastClickedBackup;


    public MainController(MainFrame mainFrame, StoreFrame storeFrame) {
        // instantiate frames
        this.mainFrame = mainFrame;
        this.storeFrame = storeFrame;

        // instantiate models
        this.farmPlot = new FarmPlot();

        // instantiate views
        this.toolView = mainFrame.getToolView();
        this.feedbackView = mainFrame.getFeedbackView();
        this.farmerView = mainFrame.getFarmerView();
        this.tileView = mainFrame.getTileView();

        // instantiate controllers
        this.farmerController = new FarmerController(this.farmerView);
        this.toolController = new ToolController();
        this.farmPlotController = new FarmPlotController();
        this.storeController = new StoreController(storeFrame, farmerController, feedbackView);
        this.tileController = new TileController(farmPlot.getTiles(), tileView, farmPlot.getHeight(), farmPlot.getWidth());
        this.tileController.clickListener();

        this.lastClicked = null;
        // TODO: add instantiation of rock tiles through file input
        // TODO: add getTile from myfarmView

        // Sets the active tool when a tool button is clicked
        this.toolView.setPlowBtnAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    display = farmerController.setActiveTool("Plow");
                    // use the tool on the farmer's tile
                    useToolWrapper();
            }
        });

        this.toolView.setWaterBtnAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                display = farmerController.setActiveTool("Watering Can");

                // get the crop's water level
                int waterLevel = ((HarvestableTile) lastClicked).getCrop().getTimesWatered();
                int waterBonus = ((HarvestableTile) lastClicked).getCrop().getWaterBonus();

                // get the farmer rank's water level
                int farmerRank = farmerController.getFarmer().getRank().getWaterBonusInc();

                if(waterLevel > (waterBonus + farmerRank)) {
                    display.setPrompt("You have already watered this crop to its maximum!");
                } else {
                    // use the tool on the farmer's tile
                    useToolWrapper();
                }
            }
        });

        this.toolView.setFertilizerBtnAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                display = farmerController.setActiveTool("Fertilizer");
//
                int fertilizerLevel = ((HarvestableTile) lastClicked).getCrop().getTimesFertilized();
                int fertilizerBonus = ((HarvestableTile) lastClicked).getCrop().getFertilizerBonus();

                int farmerRank = farmerController.getFarmer().getRank().getFertilizerBonusInc();

                if(fertilizerLevel > (fertilizerBonus + farmerRank)) {
                    display.setPrompt("You have already fertilized this crop to its maximum!");
                } else {
                    useToolWrapper();
                }

                // use the tool on the farmer's tile
            }
        });

        this.toolView.setPickaxeBtnAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                display = farmerController.setActiveTool("Pickaxe");
                // use the tool on the farmer's tile
                useToolWrapper();
            }
        });

        this.toolView.setShovelBtnAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                display = farmerController.setActiveTool("Shovel");
                // use the tool on the farmer's tile
                useToolWrapper();

            }
        });

        // Exits the game
        this.mainFrame.setExitBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.mainFrame.setLvlBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                farmerController.levelUp();
            }
        });

        // plants the crop
        this.mainFrame.setPlaceCropBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // get crop from farmer
                Crop inventory = farmerController.getFarmer().getInventory();

                // get farmer's current tile
                Tile currentTile = farmerController.getFarmer().getActiveTile();

                Feedback plantingFeedBack = new Feedback();
                if(currentTile instanceof PlantableTile){

                    plantingFeedBack = plantOnTile(inventory, currentTile);
                    farmerController.getFarmer().setInventory(null);

                    plantingFeedBack.setPrompt("Successfully planted the crop");
                }
                else{
                    plantingFeedBack.setPrompt("Cannot plant on this tile");
                }
                feedbackView.updateFeedback(plantingFeedBack.getPrompt());
            }
        });

        // Opens the seed store
        this.mainFrame.setPlantBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == mainFrame.getStoreBtn()) {
                    storeFrame.getStoreFrame().setVisible(true);
                }
            }
        });

        // Goes to the next day
        this.mainFrame.setSleepBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = nextDay();
                feedbackView.updateFeedback(display.getPrompt());
                if(!display.isSuccess()){
                    JOptionPane.showMessageDialog(null, display.getPrompt());
                    System.exit(0);
                }
            }
        });

        this.mainFrame.setHarvestBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get farmer's current tile
                harvestCrop(farmerController.getFarmer().getActiveTile(), farmerController.getActiveTileView());
                farmerController.updateFarmerView();
            }
        });

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

    private void harvestCrop(Tile activeTile, JButton activeTileView) {

        // guard clause for harvesting
        if(activeTile instanceof HarvestableTile){
            if(!((HarvestableTile) activeTile).getCrop().isReady()){
                feedbackView.updateFeedback("Crop is not ready to be harvested");
                return;
            }
        }

        // harvest the crop on the farmer's currentTile
        if(activeTile instanceof HarvestableTile) {
            // get the crop from the tile
            Crop harvestedCrop = ((HarvestableTile) activeTile).getCrop();

            double sellPrice = harvestedCrop.getBasePrice();
            int yield = harvestedCrop.getHarvestYield();
            farmerController.getFarmer().setObjectCoins(
                    farmerController.getFarmer().getObjectCoins() +
                    sellPrice);

            // replace active tile with a new available tile
            AvailableTile farmerTile = new AvailableTile();
            farmerTile.setY(activeTile.getY());
            farmerTile.setX(activeTile.getX());

            // update tile and view
            tileView.updateTileView(farmerTile, activeTileView);
            tileController.updateTile(farmerTile.getX(), farmerTile.getY(), farmerTile);
            tileController.updateTileViewIndex();
            tileController.updateFarmPanel();

            System.out.println("updated harvested tile at: " + activeTile.getX() + ", " + activeTile.getY());

            Feedback harvestFeedback = new Feedback();
            harvestFeedback.setPrompt("" +
                    "You harvested a crop of " + yield + " " + harvestedCrop.getName() + " for " + sellPrice + " coins");

            feedbackView.updateFeedback(harvestFeedback.getPrompt());
        }
    }

    private Feedback plantOnTile(Crop inventory, Tile lastClicked) {

        Feedback feedback = new Feedback();
        if(!(lastClicked instanceof PlantableTile)) {
            feedback.setSuccess(true);
            feedback.setPrompt("Tile not plantable");

            return feedback;
        }

        Tile newTile = new HarvestableTile(inventory);

        System.out.println("newtile crop: " + ((HarvestableTile) newTile).getCrop().getName());

        newTile.setY(lastClicked.getY());
        newTile.setX(lastClicked.getX());

        this.tileController.updateTile(lastClicked.getX(), lastClicked.getY(), newTile);
        this.tileController.updateTileViewIndex();
        this.tileController.updateFarmPanel();
        feedback.setSuccess(true);
        feedback.setPrompt("Successfully planted: " + inventory.getName());

        return feedback;
    }

    public void useToolWrapper(){
        Tool currentTool = farmerController.getActiveTool();
        // check if farmer can afford the tool
        if(farmerController.getFarmer().getObjectCoins() < currentTool.getCost()){
            display.setPrompt("You cannot afford this tool");
            display.setSuccess(false);
            feedbackView.updateFeedback(display.getPrompt());
            return;
        }


        Tile currentTile = farmerController.getFarmer().getActiveTile();

        // plow the tile
        Feedback toolFeedback = useToolOnTile(currentTool.getName(), currentTile);
        tileView.updateTileView(currentTile, farmerController.getActiveTileView());

        tileController.updateTileViewIndex();
        tileController.updateFarmPanel();

        feedbackView.updateFeedback(display.getPrompt() + toolFeedback.getPrompt());

        // give farmer XP
        farmerController.getFarmer().setXp(farmerController.getFarmer().getXp() + currentTool.getExpGain());
        farmerController.getFarmer().setObjectCoins(farmerController.getFarmer().getObjectCoins() - currentTool.getCost());

        farmerController.updateFarmerView();
    }


    //TODO: update this to accommodate the growing of crops
    public Feedback nextDay() {
        Feedback feedback = new Feedback();
        farmerController.getFarmer().advanceDay();
        farmerView.updateFarmerView(farmerController.getFarmer());
        farmPlotController.advanceDay(
                tileView, tileController
        );


        feedback.setPrompt("You have slept through the night.");
        feedback.setSuccess(true);

        // check if farm is full
        boolean fullFarm = farmPlotController.isFull();

        // check if farmer cannot buy the cheapest seed
        double cheapestSeedPrice = storeController.getCheapestPrice();
        boolean cannotAffordSeed = farmerController.getFarmer().getObjectCoins() < cheapestSeedPrice;
        boolean cannotAffordShovel = farmerController.getFarmer().getObjectCoins() < 7;
        boolean emptyFarm = farmPlotController.isEmpty();

        if(fullFarm && cannotAffordShovel){
            feedback.setPrompt("You have run out of space and cannot afford a shovel. Game Over.");
            feedback.setSuccess(false);
        }
        else if(emptyFarm && cannotAffordSeed){
            feedback.setPrompt("You have run out of seeds and cannot afford a seed. Game Over.");
            feedback.setSuccess(false);
        }

        return feedback;
    }

    public Feedback useToolOnTile(String toolName, Tile tile) {
        Feedback feedback = new Feedback();
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
            // TODO: update farm stats

            feedback.setSuccess(true);
            feedback.setPrompt("You used " + toolName + " on a tile!");

            return feedback;
    }

    public Feedback printTileStatus(Tile tile){
        Feedback feedback = new Feedback();
        feedback.setPrompt("Tile Details: " + tileController.getTileType(tile));
        feedback.setSuccess(true);
        return feedback;
    }

}