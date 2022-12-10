import controller.FarmPlotController;
import controller.FarmerController;
import controller.TileController;
import controller.ToolController;
import model.CropModel;
import model.FarmPlot;
import model.Farmer;
import model.Feedback;
import model.tiles.Tile;
import view.FarmerView;
import view.FeedbackView;
import view.TileView;
import view.ToolView;

import java.awt.event.*;

public class MainController {
    private MainFrame mainFrame;
    Farmer farmer;
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
    private Feedback display;
    private FarmPlot farmPlot;
    CropModel cropModel;


    public MainController(MainFrame mainFrame, StoreFrame storeFrame) {
        // instantiate frames
        this.mainFrame = mainFrame;
        this.storeFrame = storeFrame;

        // instantiate models
        this.farmer = new Farmer();
        this.farmPlot = new FarmPlot();

        // instantiate views
        this.toolView = mainFrame.getToolView();
        this.feedbackView = mainFrame.getFeedbackView();
        this.farmerView = mainFrame.getFarmerView();
        this.tileView = mainFrame.getTileView();

        // instantiate controllers
        this.storeController = new StoreController(storeFrame, farmer);
        this.farmerController = new FarmerController();
        this.toolController = new ToolController();
        this.farmPlotController = new FarmPlotController();
        this.tileController = new TileController(farmPlot.getTiles(),tileView, farmPlot.getHeight(), farmPlot.getWidth());
        this.tileController.clickListener(this.tileView);

        // TODO: add instantiation of rock tiles through file input
        // TODO: add getTile from myfarmView

        // Sets the active tool when a tool button is clicked
        this.toolView.setPlowBtnAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = farmerController.setActiveTool("Plow");
                feedbackView.updateFeedback(display.getPrompt());
            }
        });

        this.toolView.setWaterBtnAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = farmerController.setActiveTool("Watering Can");
                feedbackView.updateFeedback(display.getPrompt());
            }
        });

        this.toolView.setFertilizerBtnAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = farmerController.setActiveTool("Fertilizer");
                feedbackView.updateFeedback(display.getPrompt());
            }
        });

        this.toolView.setPickaxeBtnAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = farmerController.setActiveTool("Pickaxe");
                feedbackView.updateFeedback(display.getPrompt());
            }
        });

        this.toolView.setShovelBtnAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = farmerController.setActiveTool("Shovel");
                feedbackView.updateFeedback(display.getPrompt());
            }
        });

        // Exits the game
        this.mainFrame.setExitBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Opens the seed store
        this.mainFrame.setPlantBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == mainFrame.getPlantBtn()) {
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
                    farmerView.updateFarmerView(farmer);
            }
        });
    }

    //TODO: update this to accommodate the growing of crops
    public Feedback nextDay() {
        Feedback feedback = new Feedback();
        this.farmer.advanceDay();

        feedback.setPrompt("You have slept through the night.");
        feedback.setSuccess(true);
        // for all crops, update plantedSince
        return feedback;
    }

    public void useToolOnTile(String toolName, Tile tile) {
        Tile newTile = this.toolController.useTool(toolName, tile);
        // TODO: update farm stats
        this.farmPlotController.updateTile(newTile, tile.getX(), tile.getY());
    }

}