import model.CropModel;

public class Main {
    public static void main(String[] args) {

        // Initializes frames
        MainFrame mainFrame = new MainFrame();
        StoreFrame storeFrame = new StoreFrame();

        // Initializes models
        CropModel cropModel = new CropModel("");

        // Combines view and model
        MainController mainController = new MainController(mainFrame, storeFrame);
        StoreController storeController = new StoreController(storeFrame, mainFrame, cropModel);
    }
}
