import view.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This class shows the main view or frame of the program.
 *
 * @version 2.0
 */
public class MainView {
    ToolView toolView = new ToolView();
    TileView tileView = new TileView();
    FarmerView farmerView = new FarmerView();
    FeedbackView feedbackView = new FeedbackView();

    private JFrame mainView;
    private JLabel bgLbl;
    private JPanel menuPanel;
    private JButton sleepBtn, storeBtn, lvlBtn, exitBtn, plantBtn, harvestBtn;

    /**
     * Constructor that initializes the frame with assets.
     */
    public MainView() {

        // Initializes the frame
        this.mainView = new JFrame("My Farm");
        this.mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainView.setResizable(false);
        this.mainView.setSize(1280, 800);
        this.mainView.setLayout(null);

        ImageIcon logo = new ImageIcon("assets/farm/logo.png");
        this.mainView.setIconImage(logo.getImage());

        // Places background
        this.bgLbl = new JLabel();
        ImageIcon bgIcon = new ImageIcon("assets/farm/farm.png");
        this.bgLbl.setIcon(bgIcon);
        this.bgLbl.setBounds(0, 0, 1280, 800);

        // Sets panel for menu buttons
        this.menuPanel = new JPanel();
        this.menuPanel.setOpaque(false);
        GridLayout menuLayout = new GridLayout(6, 1,0,8);
        this.menuPanel.setLayout(menuLayout);
        this.menuPanel.setBounds(20, 250, 130, 340);

        Icon sleep = new ImageIcon("assets/menu/sleep.png");
        Icon store = new ImageIcon("assets/menu/store.png");
        Icon plant = new ImageIcon("assets/menu/plant.png");
        Icon harvest = new ImageIcon("assets/menu/harvest.png");
        Icon levelUp = new ImageIcon("assets/menu/levelUp.png");
        Icon exit = new ImageIcon("assets/menu/exit.png");

        this.sleepBtn = new JButton(sleep);
        this.storeBtn = new JButton(store);
        this.plantBtn = new JButton(plant);
        this.harvestBtn = new JButton(harvest);
        this.lvlBtn = new JButton(levelUp);
        this.exitBtn = new JButton(exit);

        this.menuPanel.add(sleepBtn);
        this.menuPanel.add(storeBtn);
        this.menuPanel.add(plantBtn);
        this.menuPanel.add(harvestBtn);
        this.menuPanel.add(lvlBtn);
        this.menuPanel.add(exitBtn);

        // Places components in the frame
        this.mainView.add(toolView.getToolView());
        this.mainView.add(tileView.getFarmPanel());
        this.mainView.add(farmerView.getFarmerView());
        this.mainView.add(feedbackView.getFeedbackView());
        this.mainView.add(this.menuPanel);
        this.mainView.add(this.bgLbl);

        // Show the main frame
        this.mainView.setVisible(true);
    }

    /**
     * Sets an action to the exitBtn.
     *
     * @param actionListener action to be done
     */
    public void setExitBtnListener(ActionListener actionListener) {
        this.exitBtn.addActionListener(actionListener);
    }

    /**
     * Sets an action to the storeBtn.
     *
     * @param actionListener action to be done
     */
    public void setStoreBtnListener(ActionListener actionListener) {
        this.storeBtn.addActionListener(actionListener);
    }

    /**
     * Sets an action to the harvestBtn.
     *
     * @param actionListener action to be done
     */
    public void setHarvestBtnListener(ActionListener actionListener){ this.harvestBtn.addActionListener(actionListener); }

    /**
     * Sets an action to the plantBtn.
     *
     * @param actionListener action to be done
     */
    public void setPlantCropBtnListener(ActionListener actionListener){ this.plantBtn.addActionListener(actionListener); }

    /**
     * Sets an action to the sleepBtn.
     *
     * @param actionListener action to be done
     */
    public void setSleepBtnListener(ActionListener actionListener) {
        this.sleepBtn.addActionListener(actionListener);
    }

    /**
     * Sets an action to the lvlBtn.
     *
     * @param actionListener action to be done
     */
    public void setLvlBtnListener(ActionListener actionListener){
        this.lvlBtn.addActionListener(actionListener);
    }

    /**
     * Gets the storeBtn.
     */
    public JButton getStoreBtn() {
        return this.storeBtn;
    }

    /**
     * Gets the view that shows all tools.
     *
     * @return toolView
     */
    public ToolView getToolView() {
        return this.toolView;
    }

    /**
     * Gets the view that displays feedback.
     *
     * @return feedbackView
     */
    public FeedbackView getFeedbackView() {
        return this.feedbackView;
    }

    /**
     * Gets the view that shows farmer information and status.
     *
     * @return farmerView
     */
    public FarmerView getFarmerView() {
        return this.farmerView;
    }

    /**
     * Gets the view of the farmland with 10x5 tiles.
     *
     * @return tileView
     */
    public TileView getTileView() {
        return this.tileView;
    }
}
