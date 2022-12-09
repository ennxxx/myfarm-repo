package view;

import javax.swing.*;
import java.awt.*;

public class FeedbackView extends JLabel {
    private JLabel feedbackLbl;

    public FeedbackView() {

        this.feedbackLbl = new JLabel();
        this.feedbackLbl.setText("<html><center>" +
                "This is a tester to see if the text will wrap around." + "</center></html>");
        this.feedbackLbl.setForeground(new Color(0x633828));
        this.feedbackLbl.setFont(new Font("Verdana", Font.PLAIN, 16));
        this.feedbackLbl.setBounds(1160, 190,85, 350);
    }

    public JLabel getFeedbackView() {
        return this.feedbackLbl;
    }
}
