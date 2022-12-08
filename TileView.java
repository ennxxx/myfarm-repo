import javax.swing.*;
import java.awt.*;

public class TileView extends JPanel {
    private JPanel farmPanel;

    public TileView() {
        this.farmPanel = new JPanel();
        this.farmPanel.setOpaque(false);
        GridLayout farmLayout = new GridLayout(5, 10,2,2);
        this.farmPanel.setLayout(farmLayout);
        this.farmPanel.setBounds(240, 230, 800, 400);

        for (int i = 0; i < (10*5); i++) {
            farmPanel.add(new JButton("Tile"));
        }
    }

    public JPanel getTileView() {
        return farmPanel;
    }
}
