package view;

import model.Farmer;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

/**
 * This is a view class for the farmer's information.
 */
public class FarmerView extends JPanel {

    private JPanel farmerPanel;
    private JLabel farmerLbl, levelLbl, rankLbl, expLbl, daysLbl, coinsLbl;
    private Farmer defaultFarmer;

    public FarmerView() {
        this.defaultFarmer = new Farmer();
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
        this.rankLbl = new JLabel(this.defaultFarmer.getRank().getLevelTitle());
        this.rankLbl.setForeground(new Color(0x633828));
        this.rankLbl.setBounds(45, 22, 380, 50);
        changeFont(this.rankLbl);

        // Sets farmer level
        this.levelLbl = new JLabel("Lvl. " + this.defaultFarmer.getLevel());
        this.levelLbl.setForeground(new Color(0x633828));
        this.levelLbl.setBounds(320, 22, 380, 50);
        changeFont(this.levelLbl);

        // Sets experience gained
        this.expLbl = new JLabel("Exp. Gained: " + this.defaultFarmer.getExp());
        this.expLbl.setForeground(new Color(0x633828));
        this.expLbl.setBounds(45, 82, 270, 50);
        changeFont(this.expLbl);

        // Sets number of days passed
        this.daysLbl = new JLabel("Day " + this.defaultFarmer.getDays());
        this.daysLbl.setForeground(new Color(0x633828));
        this.daysLbl.setBounds(1160, 22, 380, 50);
        changeFont(this.daysLbl);

        // Sets Objectcoins of the Farmer
        this.coinsLbl = new JLabel("" + this.defaultFarmer.getObjectCoins());
        this.coinsLbl.setForeground(new Color(0x633828));
        this.coinsLbl.setBounds(1180, 81, 270, 50);
        changeFont(this.coinsLbl);

        // Places all labels in the panel
        this.farmerPanel.add(farmerLbl);
        this.farmerPanel.add(levelLbl);
        this.farmerPanel.add(rankLbl);
        this.farmerPanel.add(expLbl);
        this.farmerPanel.add(daysLbl);
        this.farmerPanel.add(coinsLbl);
    }

    /**
     * Changes the font and size of a label.
     *
     * @param labelName name of label
     */
    public void changeFont(JLabel labelName) {
        try {
            InputStream is = FarmerView.class.getResourceAsStream("../assets/Minecraft.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            labelName.setFont(font.deriveFont(Font.PLAIN, 18f));
        }
        catch(Exception e){}
    }

    /**
     * Updates the farmer view accordingly.
     *
     * @param farmer farmers rank
     */
    public void updateFarmerView(Farmer farmer) {
        this.rankLbl.setText(farmer.getRank().getLevelTitle());
        this.levelLbl.setText("Lvl. " + farmer.getLevel());
        this.expLbl.setText("Exp. Gained: " + farmer.getExp());
        this.daysLbl.setText("Day " + farmer.getDays());
        this.coinsLbl.setText("" + farmer.getObjectCoins());
        this.farmerPanel.revalidate();
        this.farmerPanel.repaint();
    }

    /**
     * Gets the farmer view.
     *
     * @return farmer panel
     */
    public JPanel getFarmerView() {
        return farmerPanel;
    }
}
