import javax.swing.*;

public class StoreFrame {
    private JFrame storeFrame;
    private JLabel hello;

    public StoreFrame() {

        // Initializes the frame
        this.storeFrame = new JFrame("Seed Store");
        this.storeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.storeFrame.setResizable(false);
        this.storeFrame.setSize(400, 640);
        this.storeFrame.setLayout(null);

        this.hello = new JLabel("Hello!");

        this.storeFrame.add(this.hello);
        this.storeFrame.setVisible(true);
    }
}
