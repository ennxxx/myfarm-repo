package view;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class FarmerView extends JPanel {

    private JPanel farmerPanel;
    private JLabel farmerLbl, levelLbl, rankLbl, expLbl, daysLbl, coinsLbl;

    public FarmerView() {

        this.farmerPanel = new JPanel();
        this.farmerPanel.setLayout(null);
        this.farmerPanel.setOpaque(false);
        this.farmerPanel.setBounds(0, 0, 1280, 800);

        // Places farmer sprite
        this.farmerLbl = new JLabel();
        ImageIcon farmerIcon = new ImageIcon("assets/farm/farmer.png");
        this.farmerLbl.setIcon(farmerIcon);
        this.farmerLbl.setBounds(565,50, 160, 160);

        // Sets farmer rank
        this.rankLbl = new JLabel("Distinguished Farmer");
        this.rankLbl.setForeground(new Color(0x633828));
        this.rankLbl.setBounds(45, 22, 380, 50);
        changeFont(this.rankLbl);

        // Sets farmer level
        this.levelLbl = new JLabel("Lvl. 11");
        this.levelLbl.setForeground(new Color(0x633828));
        this.levelLbl.setBounds(320, 22, 380, 50);
        changeFont(this.levelLbl);

        // Sets experience gained
        this.expLbl = new JLabel("Exp. Gained: 69");
        this.expLbl.setForeground(new Color(0x633828));
        this.expLbl.setBounds(45, 82, 270, 50);
        changeFont(this.expLbl);

        // Sets number of days passed
        this.daysLbl = new JLabel("Day 1");
        this.daysLbl.setForeground(new Color(0x633828));
        this.daysLbl.setBounds(1185, 22, 380, 50);
        changeFont(this.daysLbl);

        // Sets Objectcoins of the Farmer
        this.coinsLbl = new JLabel("0");
        this.coinsLbl.setForeground(new Color(0x633828));
        this.coinsLbl.setBounds(1225, 82, 270, 50);
        changeFont(this.coinsLbl);

        // Places all labels in the panel
        this.farmerPanel.add(farmerLbl);
        this.farmerPanel.add(levelLbl);
        this.farmerPanel.add(rankLbl);
        this.farmerPanel.add(expLbl);
        this.farmerPanel.add(daysLbl);
        this.farmerPanel.add(coinsLbl);
    }

    public void changeFont(JLabel labelName) {
        try {
            InputStream is = FarmerView.class.getResourceAsStream("../assets/Minecraft.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            labelName.setFont(font.deriveFont(Font.PLAIN, 19f));
        }
        catch(Exception e){}
    }

    public JPanel getFarmerView() {
        return farmerPanel;
    }
}
