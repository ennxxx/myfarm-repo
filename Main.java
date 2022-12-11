import view.StoreFrame;

public class Main {
    public static void main(String[] args) {

        // Initializes frames
        MainFrame mainFrame = new MainFrame();
        StoreFrame storeFrame = new StoreFrame();

        // Combines view and model
        MainController mainController = new MainController(mainFrame, storeFrame);
    }
}
