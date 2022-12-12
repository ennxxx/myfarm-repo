package view;

import javax.swing.*;
import java.awt.*;

/**
 * This is a view class for the displayed feedback.
 */
public class FeedbackView extends JLabel {
    private JLabel feedbackLbl;

    /**
     * Sets the default message of a feedback.
     */
    public FeedbackView() {
        this.feedbackLbl = new JLabel();
        this.feedbackLbl.setText("<html><center>" + "Welcome Farmer!" + "</center></html>");
        this.feedbackLbl.setForeground(new Color(0x633828));
        this.feedbackLbl.setFont(new Font("Verdana", Font.PLAIN, 14));
        this.feedbackLbl.setBounds(1160, 200,85, 350);
    }

    /**
     * Updates feedback accordingly.
     *
     * @param display feedback based on actions done
     */
    public void updateFeedback(String display) {
        this.feedbackLbl.setText("<html><center>" +
                display + "</center></html>");
        this.feedbackLbl.revalidate();
        this.feedbackLbl.repaint();
    }

    /**
     * Gets the feedback view.
     *
     * @return feedback label.
     */
    public JLabel getFeedbackView() {
        return this.feedbackLbl;
    }
}
