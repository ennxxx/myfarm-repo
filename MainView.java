import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.io.InputStream;

public class MainView {
    private JFrame mainFrame;
    private JLabel farmerLbl, levelLbl, expLbl, daysLbl, coinsLbl;
    private JLabel bgLbl, feedbackLbl;
    private JPanel farmPanel, menuPanel, toolPanel;
    private JButton sleepBtn, plantBtn, lvlBtn, exitBtn;
    private JButton plowBtn, waterBtn, fertilizerBtn, pickaxeBtn, shovelBtn;

    public MainView() {

        ImageIcon logo = new ImageIcon("assets/logo.png");
        Border border = BorderFactory.createLineBorder(new Color(0xC27D63), 4);

        // Initializes the frame
        this.mainFrame = new JFrame("MyFarm");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setResizable(false);
        this.mainFrame.setSize(1280, 800);
        this.mainFrame.setLayout(null);
        this.mainFrame.setIconImage(logo.getImage());

        // Places background
        this.bgLbl = new JLabel();
        ImageIcon bgIcon = new ImageIcon("assets/farm.png");
        Image bg = bgIcon.getImage();
        Image newBg = bg.getScaledInstance(1280, 800,  Image.SCALE_SMOOTH);
        bgIcon = new ImageIcon(newBg);
        this.bgLbl.setIcon(bgIcon);
        this.bgLbl.setBounds(0, 0, 1280, 800);

        // Places farmer sprite
        this.farmerLbl = new JLabel();
        ImageIcon farmerIcon = new ImageIcon("assets/farmer.png");
        Image farmer = farmerIcon.getImage();
        Image farmerBg = farmer.getScaledInstance(160, 160,  Image.SCALE_SMOOTH);
        farmerIcon = new ImageIcon(farmerBg);
        this.farmerLbl.setIcon(farmerIcon);
        this.farmerLbl.setBounds(565,50, 160, 160);

        // Sets farmer level status
        this.levelLbl = new JLabel("Farmer | Lvl. 0");
        this.levelLbl.setForeground(new Color(0x96584F));
        this.levelLbl.setBounds(45, 26, 380, 50);

        try {
            InputStream is = MainView.class.getResourceAsStream("assets/Minecraft.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            levelLbl.setFont(font.deriveFont(Font.PLAIN, 21f));
        }
        catch(Exception e){}

        // Sets experience gained status
        this.expLbl = new JLabel("  Exp. Gained: 0", JLabel.LEFT);
        this.expLbl.setForeground(new Color(0xF5F8ED));

        try {
            InputStream is = MainView.class.getResourceAsStream("assets/Minecraft.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            expLbl.setFont(font.deriveFont(Font.PLAIN, 21f));
        }
        catch(Exception e){}

        this.expLbl.setBackground(new Color(0xDDB88A));
        this.expLbl.setOpaque(true);
        this.expLbl.setBorder(border);
        this.expLbl.setBounds(20, 75, 270, 50);

        // Sets number of days passed
        this.daysLbl = new JLabel("Days Passed: 1  ", JLabel.RIGHT);
        this.daysLbl.setForeground(new Color(0x96584F));

        try {
            InputStream is = MainView.class.getResourceAsStream("assets/Minecraft.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            daysLbl.setFont(font.deriveFont(Font.PLAIN, 21f));
        }
        catch(Exception e){}

        this.daysLbl.setBackground(new Color(0xFBE6DB));
        this.daysLbl.setOpaque(true);
        this.daysLbl.setBorder(border);
        this.daysLbl.setBounds(880, 20, 380, 50);

        // Sets Objectcoins of the Farmer
        this.coinsLbl = new JLabel("Objectcoins: 0  ", JLabel.RIGHT);
        this.coinsLbl.setForeground(new Color(0xF5F8ED));

        try {
            InputStream is = MainView.class.getResourceAsStream("assets/Minecraft.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            coinsLbl.setFont(font.deriveFont(Font.PLAIN, 21f));
        }
        catch(Exception e){}

        this.coinsLbl.setBackground(new Color(0xDDB88A));
        this.coinsLbl.setOpaque(true);
        this.coinsLbl.setBorder(border);
        this.coinsLbl.setBounds(990, 75, 270, 50);

        // Sets panel for tiles
        this.farmPanel = new JPanel();
        this.farmPanel.setBackground(new Color(0xE9D5AF));
        this.farmPanel.setBounds(240, 230, 800, 400);
        GridLayout farmLayout = new GridLayout(5, 10);
        this.farmPanel.setLayout(farmLayout);

        for (int i = 0; i < (10*5); i++) {
            farmPanel.add(new JButton("Tile"));
        }

        // Sets panel for menu buttons
        this.menuPanel = new JPanel();
        this.menuPanel.setBackground(new Color(0xE9D5AF));
        this.menuPanel.setBounds(20, 240, 130, 370);
        GridLayout menuLayout = new GridLayout(4, 1,0,15);
        this.menuPanel.setLayout(menuLayout);

        this.sleepBtn = new JButton("Sleep");
        this.plantBtn = new JButton("Plant");
        this.lvlBtn = new JButton("Level Up");
        this.exitBtn = new JButton("Exit");

        this.menuPanel.add(sleepBtn);
        this.menuPanel.add(plantBtn);
        this.menuPanel.add(lvlBtn);
        this.menuPanel.add(exitBtn);

        // Sets the feedback label
        this.feedbackLbl = new JLabel("Feedback", JLabel.CENTER);
        this.feedbackLbl.setForeground(new Color(0x96584F));
        this.feedbackLbl.setBackground(new Color(0xFBE6DB));
        this.feedbackLbl.setOpaque(true);
        this.feedbackLbl.setBorder(border);
        this.feedbackLbl.setBounds(1130, 240, 130, 370);

        // Sets the tool panel
        this.toolPanel = new JPanel();
        this.toolPanel.setBackground(new Color(0xE9D5AF));
        this.toolPanel.setBounds(385, 670, 500, 80);
        GridLayout toolLayout = new GridLayout(1, 1,10,0);
        this.toolPanel.setLayout(toolLayout);

        this.plowBtn = new JButton("Plow");
        this.waterBtn = new JButton("Water");
        this.fertilizerBtn = new JButton("Fertilize");
        this.pickaxeBtn = new JButton("Pickaxe");
        this.shovelBtn = new JButton("Shovel");

        this.toolPanel.add(plowBtn);
        this.toolPanel.add(waterBtn);
        this.toolPanel.add(fertilizerBtn);
        this.toolPanel.add(pickaxeBtn);
        this.toolPanel.add(shovelBtn);

        // Places components in the frame
        this.mainFrame.add(this.farmerLbl);
        this.mainFrame.add(this.levelLbl);
        this.mainFrame.add(this.expLbl);
        this.mainFrame.add(this.daysLbl);
        this.mainFrame.add(this.coinsLbl);
        this.mainFrame.add(this.farmPanel);
        this.mainFrame.add(this.menuPanel);
        this.mainFrame.add(this.feedbackLbl);
        this.mainFrame.add(this.toolPanel);
        this.mainFrame.add(this.bgLbl);

        this.mainFrame.setVisible(true);
    }

    public void setSleepBtnListener(ActionListener actionListener) {
        this.sleepBtn.addActionListener(actionListener);
    }

    public JFrame getMainFrame() {
        return this.mainFrame;
    }

    public JButton getSleepBtn() {
        return this.sleepBtn;
    }
}
