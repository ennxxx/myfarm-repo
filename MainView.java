import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.InputStream;

public class MainView {
    private JFrame mainFrame;
    private JLabel farmerLbl, levelLbl, expLbl, daysLbl, coinsLbl;
    private JPanel farmPanel;
    private JButton sleepBtn, plantBtn, exitBtn;

    public MainView() {

        ImageIcon logo = new ImageIcon("assets/logo.png");
        Border border = BorderFactory.createLineBorder(new Color(0xC27D63), 4);

        // Initializes the frame
        this.mainFrame = new JFrame("MyFarm");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setResizable(false);
        this.mainFrame.setSize(1280, 800);
        this.mainFrame.setLayout(null);
        this.mainFrame.getContentPane().setBackground(new Color(0xc0d470));
        this.mainFrame.setIconImage(logo.getImage());

        // Places farmer sprite
        this.farmerLbl = new JLabel();
        this.farmerLbl.setIcon(new ImageIcon("assets/farmer.png"));
        this.farmerLbl.setBounds(600,60, 100, 100);

        // Sets farmer level status
        this.levelLbl = new JLabel("  Farmer |  Lvl. 0", JLabel.LEFT);
        this.levelLbl.setForeground(new Color(0x96584F));

        try {
            InputStream is = MainView.class.getResourceAsStream("assets/Minecraft.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            levelLbl.setFont(font.deriveFont(Font.PLAIN, 21f));
        }
        catch(Exception e){}

        this.levelLbl.setBackground(new Color(0xFBE6DB));
        this.levelLbl.setOpaque(true);
        this.levelLbl.setBorder(border);
        this.levelLbl.setBounds(20, 20, 380, 50);

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
        this.expLbl.setBounds(20, 90, 270, 50);

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
        this.coinsLbl.setBounds(990, 90, 270, 50);

        // Sets panel for tiles
        this.farmPanel = new JPanel();
        this.farmPanel.setBackground(new Color(0xE9D5AF));
        this.farmPanel.setBounds(240, 220, 800, 400);
        this.farmPanel.setLayout(new GridLayout(5, 10));

        for (int i = 0; i < (10*5); i++) {
            farmPanel.add(new JButton("Tile"));
        }

        // Sets button to sleep
        this.sleepBtn = new JButton("Sleep");
        this.sleepBtn.setBounds(20, 280, 160, 50);

        // Places components in the frame
        this.mainFrame.add(this.farmerLbl);
        this.mainFrame.add(this.levelLbl);
        this.mainFrame.add(this.expLbl);
        this.mainFrame.add(this.daysLbl);
        this.mainFrame.add(this.coinsLbl);
        this.mainFrame.add(this.farmPanel);
        this.mainFrame.add(this.sleepBtn);

        this.mainFrame.setVisible(true);
    }
}
