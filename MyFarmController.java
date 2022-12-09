import controller.FarmPlotController;
import controller.FarmerController;
import controller.ToolController;
import controller.ToolFactory;
import model.tiles.Tile;

public class MyFarmController {
    private MyFarmView myfarmView;
//    private MyFarmModel myfarmModel;

     private FarmPlotController farmPlotController;
     private FarmerController farmerController;
     private ToolController toolController;


    public MyFarmController(MyFarmView myfarmView) {
        this.myfarmView = myfarmView;
        // TODO: add instantiation of rock tiles through file input
        // TODO: add getTile from myfarmView

        this.farmerController = new FarmerController();
        this.toolController = new ToolController();
        this.farmPlotController = new FarmPlotController();
    }

    public void useToolOnTile(String toolName, Tile tile) {
        Tile newTile = this.toolController.useTool(toolName, tile);
        // TODO: update farm stats
        this.farmerController.setActiveTool(toolName);
        this.farmPlotController.updateTile(newTile, tile.getX(), tile.getY());
    }





}
