package view;

import view.FarmerView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.InputStream;

public class StoreFrame {
    private JFrame storeFrame;
    private JPanel menuPanel, seedPanel;
    private JLabel bgLbl, coinsLbl, feedbackLbl;
    private JButton turBtn, carBtn, potBtn, rosBtn, tulBtn, sunBtn, manBtn, appBtn;
    private JButton buyBtn, returnBtn;

    public StoreFrame() {

        // Initializes the frame
        this.storeFrame = new JFrame("Seed Store");
        this.storeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.storeFrame.setResizable(false);
        this.storeFrame.setSize(500, 650);
        this.storeFrame.setLayout(null);

        // Places background
        this.bgLbl = new JLabel();
        ImageIcon bgIcon = new ImageIcon("assets/seedStore/seedStore.png");
        this.bgLbl.setIcon(bgIcon);
        this.bgLbl.setBounds(0,-8,500,645);

        // Sets Objectcoins of the Farmer
        this.coinsLbl = new JLabel("0");
        this.coinsLbl.setForeground(new Color(0x633828));
        this.coinsLbl.setBounds(75, 210, 160, 70);
        changeLFont(this.coinsLbl);

        // Sets welcome and feedback message
        this.feedbackLbl = new JLabel("<html><center>" +
                "Welcome to the Seed Store! Pick a seed to plant." + "</center></html>");
        this.feedbackLbl.setForeground(new Color(0x633828));
        this.feedbackLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
        this.feedbackLbl.setBounds(51,285,100,160);

        // Set return button
        // (If return button only, make sure to add this.storeFrame.add(returnBtn))
        // this.returnBtn = new JButton();
        // Icon rtn = new ImageIcon("assets/seedStore/return.png");
        // this.returnBtn = new JButton(rtn);
        // this.returnBtn.setBounds(20,470,160,62);

        // Set menu panel
        this.menuPanel = new JPanel();
        this.menuPanel.setOpaque(false);
        GridLayout menuLayout = new GridLayout(2,1,0,10);
        this.menuPanel.setLayout(menuLayout);
        this.menuPanel.setBounds(20,465,160,134);

        Icon buy = new ImageIcon("assets/seedStore/buy.png");
        Icon rtn = new ImageIcon("assets/seedStore/return.png");

        this.buyBtn = new JButton(buy);
        this.returnBtn = new JButton(rtn);

        this.menuPanel.add(buyBtn);
        this.menuPanel.add(returnBtn);

        // Set panel for seeds
        this.seedPanel = new JPanel();
        this.seedPanel.setOpaque(false);
        GridLayout seedLayout = new GridLayout(8,1,0,8);
        this.seedPanel.setLayout(seedLayout);
        this.seedPanel.setBounds(235,240,214,336);

        Icon store = new ImageIcon("assets/seedStore/storePanel.png");

        this.turBtn = new JButton(store);
        this.carBtn = new JButton(store);
        this.potBtn = new JButton(store);
        this.rosBtn = new JButton(store);
        this.tulBtn = new JButton(store);
        this.sunBtn = new JButton(store);
        this.manBtn = new JButton(store);
        this.appBtn = new JButton(store);

        this.turBtn.setText("Turnip");
        this.carBtn.setText("Carrot");
        this.potBtn.setText("Potato");
        this.rosBtn.setText("Rose");
        this.tulBtn.setText("Tulips");
        this.sunBtn.setText("Sunflower");
        this.manBtn.setText("Mango");
        this.appBtn.setText("Apple");

        btnSettings(this.turBtn);
        btnSettings(this.carBtn);
        btnSettings(this.potBtn);
        btnSettings(this.rosBtn);
        btnSettings(this.tulBtn);
        btnSettings(this.sunBtn);
        btnSettings(this.manBtn);
        btnSettings(this.appBtn);

        this.seedPanel.add(turBtn);
        this.seedPanel.add(carBtn);
        this.seedPanel.add(potBtn);
        this.seedPanel.add(rosBtn);
        this.seedPanel.add(tulBtn);
        this.seedPanel.add(sunBtn);
        this.seedPanel.add(manBtn);
        this.seedPanel.add(appBtn);

        // Places components in the frame
        this.storeFrame.add(this.coinsLbl);
        this.storeFrame.add(this.feedbackLbl);
        this.storeFrame.add(this.menuPanel);
        this.storeFrame.add(this.seedPanel);
        this.storeFrame.add(this.bgLbl);

        // Store frame is not visible at the start
        this.storeFrame.setVisible(false);
    }

    public void btnSettings(JButton buttonName) {
        buttonName.setForeground(new Color(0x633828));
        buttonName.setVerticalTextPosition(AbstractButton.CENTER);
        buttonName.setHorizontalTextPosition(AbstractButton.CENTER);
        changeBFont(buttonName);
    }

    public void changeBFont(JButton buttonName) {
        try {
            InputStream is = FarmerView.class.getResourceAsStream("../assets/Minecraft.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            buttonName.setFont(font.deriveFont(Font.PLAIN, 16f));
        }
        catch(Exception e){}
    }

    public void changeLFont(JLabel labelName) {
        try {
            InputStream is = FarmerView.class.getResourceAsStream("../assets/Minecraft.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            labelName.setFont(font.deriveFont(Font.PLAIN, 19f));
        }
        catch(Exception e){}
    }

    public JFrame getStoreFrame() {

        return this.storeFrame;
    }
    public JButton getReturnBtn() {

        return this.returnBtn;
    }
    public void setFeedbackLblText(String text) {

        this.feedbackLbl.setText(text);
    }
    public void setReturnBtnListener(ActionListener actionListener) {

        this.returnBtn.addActionListener(actionListener);
    }
    public void setTurBtnListener(ActionListener actionListener) {
        this.turBtn.addActionListener(actionListener);
    }
    public void setCarBtnListener(ActionListener actionListener) {
        this.carBtn.addActionListener(actionListener);
    }
    public void setPotBtnListener(ActionListener actionListener) {
        this.potBtn.addActionListener(actionListener);
    }
    public void setRosBtnListener(ActionListener actionListener) {
        this.rosBtn.addActionListener(actionListener);
    }
    public void setTulBtnListener(ActionListener actionListener) {
        this.tulBtn.addActionListener(actionListener);
    }
    public void setSunBtnListener(ActionListener actionListener) {
        this.sunBtn.addActionListener(actionListener);
    }
    public void setAppBtnListener(ActionListener actionListener) {
        this.appBtn.addActionListener(actionListener);
    }
    public void setManBtnListener(ActionListener actionListener) {
        this.manBtn.addActionListener(actionListener);
    }

    public void setCoinsLbl(double coins){
        this.coinsLbl.setText(String.valueOf(coins));
    }

    public void setBuyBtnListener(ActionListener actionListener) {
        this.buyBtn.addActionListener(actionListener);
    }
}
