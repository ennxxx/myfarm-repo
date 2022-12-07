import javax.swing.*;
import java.awt.*;

public class MyFarmView {
    private JFrame mainFrame;
    private JLabel levelLbl, expLbl, daysLbl, coinsLbl;
    // private JTextField
    // private JButton

    public MyFarmView() {

        // Initializes the frame
        this.mainFrame = new JFrame("MyFarm");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setResizable(false);
        this.mainFrame.setSize(1280, 800);

        // Sets the logo image
        ImageIcon image = new ImageIcon("assets/logo.png");
        this.mainFrame.setIconImage(image.getImage());

        this.mainFrame.setVisible(true);
    }
}
