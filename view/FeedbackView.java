package view;

import javax.swing.*;
import java.awt.*;

public class FeedbackView extends JLabel {
    private JLabel feedbackLbl;

    public FeedbackView() {

        this.feedbackLbl = new JLabel();
        this.feedbackLbl.setText("<html><center>" + "Welcome Farmer!" + "</center></html>");
        this.feedbackLbl.setForeground(new Color(0x633828));
        this.feedbackLbl.setFont(new Font("Verdana", Font.PLAIN, 16));
        this.feedbackLbl.setBounds(1160, 190,85, 350);
    }

    public void updateFeedback(String display) {
        this.feedbackLbl.setText("<html><center>" +
                display + "</center></html>");
        this.feedbackLbl.revalidate();
        this.feedbackLbl.repaint();
    }

    public JLabel getFeedbackView() {
        return this.feedbackLbl;
    }
}
