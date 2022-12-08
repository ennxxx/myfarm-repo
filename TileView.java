import javax.swing.*;
import java.awt.*;

public class TileView extends JPanel {
    private JPanel farmPanel;

    public TileView() {
        this.farmPanel = new JPanel();
        this.farmPanel.setOpaque(false);
        GridLayout farmLayout = new GridLayout(5, 10,8,8);
        this.farmPanel.setLayout(farmLayout);
        this.farmPanel.setBounds(250, 260, 772, 382);

        Icon unplowed = new ImageIcon("assets/tiles/unplowed.png");

        for (int i = 0; i < (10*5); i++) {
            farmPanel.add(new JButton(unplowed));
        }
    }

    public JPanel getTileView() {
        return farmPanel;
    }
}
