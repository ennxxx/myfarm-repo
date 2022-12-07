import javax.swing.*;
import java.awt.*;

public class RestView {
    private JFrame restFrame;
    private JLabel restLbl;

    RestView() {

        ImageIcon logo = new ImageIcon("assets/logo.png");

        // Initializes the frame
        this.restFrame = new JFrame("MyFarm");
        this.restFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.restFrame.setResizable(false);
        this.restFrame.setSize(1280, 800);
        this.restFrame.setLayout(null);
        this.restFrame.getContentPane().setBackground(new Color(0xc0d470));
        this.restFrame.setIconImage(logo.getImage());

        // Places sleeping farmer sprite
        this.restLbl = new JLabel("Sleeping...");
        this.restLbl.setBounds(100, 100, 380, 50);

        // Places components in the frame
        this.restFrame.add(this.restLbl);

        this.restFrame.setVisible(true);
    }
}
