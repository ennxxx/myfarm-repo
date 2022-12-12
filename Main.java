import view.StoreView;

/**
 * This class represents the driver in the program.
 *
 * @version 2.0
 */
public class Main {
    public static void main(String[] args) {

        // Initializes the main frames
        MainView mainView = new MainView();
        StoreView storeView = new StoreView();

        // Combines view and model
        MainController mainController = new MainController(mainView, storeView);
    }
}
