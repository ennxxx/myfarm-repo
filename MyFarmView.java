import javax.swing.*;

public class MyFarmView {
    private JFrame mainFrame;
    private JLabel levelLbl, expLbl, daysLbl, coinsLbl;
    // private JTextField
    // private JButton

    public MyFarmView() {

        this.mainFrame = new JFrame("MyFarm");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setResizable(false);
        this.mainFrame.setSize(1280, 800);

        ImageIcon image = new ImageIcon("logo.png");
        mainFrame.setIconImage(image.getImage());

        this.mainFrame.setVisible(true);
    }
}
