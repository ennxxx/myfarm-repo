import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FeedbackView extends JLabel {
    private JLabel feedbackLbl;

    public FeedbackView() {
        Border border = BorderFactory.createLineBorder(new Color(0xC27D63), 4);
        this.feedbackLbl = new JLabel("Feedback", JLabel.CENTER);
        this.feedbackLbl.setForeground(new Color(0x96584F));
        this.feedbackLbl.setBackground(new Color(0xFBE6DB));
        this.feedbackLbl.setOpaque(true);
        this.feedbackLbl.setBorder(border);
        this.feedbackLbl.setBounds(1130, 240, 130, 370);
    }

    public JLabel getFeedbackView() {
        return this.feedbackLbl;
    }
}
