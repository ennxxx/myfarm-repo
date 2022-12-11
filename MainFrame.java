import controller.TileController;
import model.Farmer;
import view.FarmerView;
import view.FeedbackView;
import view.TileView;
import view.ToolView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class MainFrame {
    ToolView toolView = new ToolView();
    TileView tileView = new TileView();
    FarmerView farmerView = new FarmerView();
    FeedbackView feedbackView = new FeedbackView();

    private JFrame mainFrame;
    private JLabel bgLbl;
    private JPanel menuPanel;
    private JButton sleepBtn, plantBtn, lvlBtn, exitBtn;

    public MainFrame() {

        // Initializes the frame
        this.mainFrame = new JFrame("My Farm");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setResizable(false);
        this.mainFrame.setSize(1280, 800);
        this.mainFrame.setLayout(null);

        ImageIcon logo = new ImageIcon("assets/farm/logo.png");
        this.mainFrame.setIconImage(logo.getImage());

        // Places background
        this.bgLbl = new JLabel();
        ImageIcon bgIcon = new ImageIcon("assets/farm/farm.png");
        this.bgLbl.setIcon(bgIcon);
        this.bgLbl.setBounds(0, 0, 1280, 800);

        // Sets panel for menu buttons
        this.menuPanel = new JPanel();
        this.menuPanel.setOpaque(false);
        GridLayout menuLayout = new GridLayout(4, 1,0,10);
        this.menuPanel.setLayout(menuLayout);
        this.menuPanel.setBounds(20, 300, 130, 230);

        Icon sleep = new ImageIcon("assets/menu/sleep.png");
        Icon plant = new ImageIcon("assets/menu/plant.png");
        Icon levelUp = new ImageIcon("assets/menu/levelUp.png");
        Icon exit = new ImageIcon("assets/menu/exit.png");

        this.sleepBtn = new JButton(sleep);
        this.plantBtn = new JButton(plant);
        this.lvlBtn = new JButton(levelUp);
        this.exitBtn = new JButton(exit);

        this.menuPanel.add(sleepBtn);
        this.menuPanel.add(plantBtn);
        this.menuPanel.add(lvlBtn);
        this.menuPanel.add(exitBtn);

        // Places components in the frame

        this.mainFrame.add(toolView.getToolView());
        this.mainFrame.add(tileView.getFarmPanel());
        this.mainFrame.add(farmerView.getFarmerView());
        this.mainFrame.add(feedbackView.getFeedbackView());
        this.mainFrame.add(this.menuPanel);
        this.mainFrame.add(this.bgLbl);

        // Show the main frame
        this.mainFrame.setVisible(true);
    }

    public void setExitBtnListener(ActionListener actionListener) {
        this.exitBtn.addActionListener(actionListener);
    }

    public void setPlantBtnListener(ActionListener actionListener) {
        this.plantBtn.addActionListener(actionListener);
    }

    public void setSleepBtnListener(ActionListener actionListener) {
        this.sleepBtn.addActionListener(actionListener);
    }

    public JFrame getMainFrame() {
        return this.mainFrame;
    }
    public JButton getPlantBtn() {
        return this.plantBtn;
    }

    public ToolView getToolView() {
        return this.toolView;
    }

    public FeedbackView getFeedbackView() {
        return this.feedbackView;
    }

    public FarmerView getFarmerView() {
        return this.farmerView;
    }

    public TileView getTileView() {
        return this.tileView;
    }
}
