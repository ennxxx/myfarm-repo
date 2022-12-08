import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.io.InputStream;

public class MainView {

    ToolView toolView = new ToolView();
    TileView tileView = new TileView();
    FarmerView farmerView = new FarmerView();

    private JFrame mainFrame;
    private JLabel bgLbl, feedbackLbl;
    private JPanel menuPanel;
    private JButton sleepBtn, plantBtn, lvlBtn, exitBtn;

    public MainView() {

        // Initializes the frame
        this.mainFrame = new JFrame("MyFarm");
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

        // Sets the feedback label
        Border border = BorderFactory.createLineBorder(new Color(0xC27D63), 4);
        this.feedbackLbl = new JLabel("Feedback", JLabel.CENTER);
        this.feedbackLbl.setForeground(new Color(0x96584F));
        this.feedbackLbl.setBackground(new Color(0xFBE6DB));
        this.feedbackLbl.setOpaque(true);
        this.feedbackLbl.setBorder(border);
        this.feedbackLbl.setBounds(1130, 240, 130, 370);

        // Places components in the frame
        this.mainFrame.add(toolView.getToolView());
        this.mainFrame.add(tileView.getTileView());
        this.mainFrame.add(farmerView.getFarmerView());
        this.mainFrame.add(this.menuPanel);
        this.mainFrame.add(this.feedbackLbl);
        this.mainFrame.add(this.bgLbl);

        // Show the main frame
        this.mainFrame.setVisible(true);
    }
}
