import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private MainFrame mainFrame;
    private StoreFrame storeFrame;

    public MainController(MainFrame mainFrame, StoreFrame storeFrame) {
        this.mainFrame = mainFrame;
        this.storeFrame = storeFrame;

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
    }
}
